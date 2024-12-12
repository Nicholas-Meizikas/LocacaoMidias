package locacaomidias.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.dao.MidiaDAO;
import locacaomidias.entidades.Exemplar;
import locacaomidias.utils.Utils;

/**
 *
 * @author nicho
 */
@WebServlet(name = "ExemplarServlet", urlPatterns = {"/pExemplar"})
public class ExemplarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher disp = null ;
        
        String acao = request.getParameter("acao")  ;
        
        try (ExemplarDAO dao = new ExemplarDAO()) {
            MidiaDAO midias = new MidiaDAO() ;
            
            if (acao.equals("inserir")) {
                
                Long midia = Long.valueOf(request.getParameter("idMidia")) ;
                int quantidade = Integer.parseInt(request.getParameter("quantidade")) ;
                
                for (int i = 0 ; i < quantidade ; i++) {
                    Exemplar e = new Exemplar() ;
                    e.setMidia(midias.obterPorId(midia));
                    
                    if (quantidade > 1) {
                        e.setDisponivel(Boolean.TRUE);
                    } else {
                        e.setDisponivel(Boolean.FALSE);
                    }
                    Utils.validar(e, "id");
                    dao.salvar(e);
                }
                
                disp = request.getRequestDispatcher("/formularios/exemplar/listagem.jsp") ;
                
            } else if (acao.equals("excluir")) {
                
                Long id = Long.valueOf(request.getParameter("id")) ;
                Exemplar e = dao.obterPorId(id) ;
                
                dao.excluir(e);
                
                List<Exemplar> lista = dao.listarTodos() ;
                
                List<Exemplar> quantidade = new ArrayList<>() ;
                for (Exemplar ex : lista) {
                    if (ex.getMidia().getId() == e.getMidia().getId() && ex.getDisponivel())  {
                        quantidade.add(ex) ;
                    }
                }
                
                if (quantidade.size() < 2) {
                    for (Exemplar exe : quantidade) {
                        exe.setDisponivel(Boolean.FALSE);
                        dao.atualizar(exe);
                    }
                }
                
                disp = request.getRequestDispatcher("/formularios/exemplar/listagem.jsp") ;
                
            } else {
                
                Long id = Long.valueOf(request.getParameter("id")) ;
                Exemplar e = dao.obterPorId(id) ;
                request.setAttribute("exemplar", e);
                
                if (acao.equals("prepararAlteracao")){
                    e.setDisponivel(Boolean.TRUE);
                    dao.atualizar(e);
                    disp = request.getRequestDispatcher("/formularios/exemplares/listagem.jsp") ;
                } else if (acao.equals("prepararExclusao")){
                    disp = request.getRequestDispatcher("/formularios/exemplares/excluir.jsp") ;
                }
            }
            
        } catch (SQLException ex) {
            Utils.prepararDespachoErro(request, ex.getMessage()) ;
        }
        
        if (disp != null) {
            disp.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}