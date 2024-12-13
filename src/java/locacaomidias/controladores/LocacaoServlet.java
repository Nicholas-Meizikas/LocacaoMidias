package locacaomidias.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Date;
import locacaomidias.dao.ClienteDAO;
import locacaomidias.dao.ExemplarDAO;
import locacaomidias.dao.ItemLocacaoDAO;
import locacaomidias.dao.LocacaoDAO;
import locacaomidias.entidades.Locacao;
import locacaomidias.entidades.ItemLocacao;
import locacaomidias.entidades.Exemplar;
import locacaomidias.utils.Utils;

/**
 *
 * @author nicho
 */
@WebServlet(name = "LocacaoServlet", urlPatterns = {"/pLocacao"})
public class LocacaoServlet extends HttpServlet {

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
        String acao = request.getParameter("acao") ;
        RequestDispatcher disp = null ;
        
        try (LocacaoDAO dao = new LocacaoDAO()) {
            ItemLocacaoDAO itemLDAO = new ItemLocacaoDAO() ;
            ExemplarDAO exem = new ExemplarDAO() ;
            ClienteDAO cli = new ClienteDAO() ;
             
            if (acao.equals("inserir")) {
                Long cliente = Long.valueOf(request.getParameter("idCliente")) ;
                Long exemplar = Long.valueOf(request.getParameter("idExemplar")) ;
                Float valor = Float.valueOf(request.getParameter("valor")) ;
                
                Locacao  l = new Locacao() ;
                
                Date dia = new Date(System.currentTimeMillis());
                l.setDataInicio(dia);
                Date fim = new Date(System.currentTimeMillis()) ;
                fim.setDate(fim.getDate()+7);
                l.setDataFim(fim);
                l.setCancelada(Boolean.FALSE);
                l.setCliente(cli.obterPorId(cliente));
                
                Utils.validar(l, "id");
                dao.salvar(l);
                
                Exemplar e = exem.obterPorId(exemplar) ;
                e.setDisponivel(Boolean.FALSE);
                exem.atualizar(e);
                
                ItemLocacao itemL = new ItemLocacao() ;
                
                itemL.setLocacao(l);
                itemL.setExemplar(e);
                itemL.setValor(valor);
                
                Utils.validar(itemL, "id");
                itemLDAO.salvar(itemL);
                
                disp = request.getRequestDispatcher("/formularios/locacoes/listagem.jsp") ;
            } else if (acao.equals("excluir")) {
                Long idI = Long.valueOf(request.getParameter("idLocacao")) ;
                
                Long idE = Long.valueOf(request.getParameter("idExemplar")) ;
                
                ItemLocacao itemL = itemLDAO.ObterPorLocacaoIDExemplarId(idI, idE) ;
                Locacao l = itemL.getLocacao() ;
                l.setCancelada(Boolean.TRUE);
                dao.atualizar(l);
                
                disp = request.getRequestDispatcher("/formularios/locacoes/listagem.jsp") ;
            } else {
                Long idI = Long.valueOf(request.getParameter("idLocacao")) ;
                
                Long idE = Long.valueOf(request.getParameter("idExemplar")) ;
                
                ItemLocacao itemL = itemLDAO.ObterPorLocacaoIDExemplarId(idI, idE) ;
                
                
                request.setAttribute("itemLocacao", itemL);
                if (acao.equals("prepararAlteracao")) {
                    
                    itemL.getLocacao().setCancelada(Boolean.TRUE);
                    itemL.getExemplar().setDisponivel(Boolean.TRUE);

                    dao.atualizar(itemL.getLocacao());
                    exem.atualizar(itemL.getExemplar());

                    disp = request.getRequestDispatcher("/formularios/locacoes/listagem.jsp") ;
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher("/formularios/locacoes/excluir.jsp") ;
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Utils.prepararDespachoErro(request, ex.getMessage()) ;
        }
        
        if (disp != null ){
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
