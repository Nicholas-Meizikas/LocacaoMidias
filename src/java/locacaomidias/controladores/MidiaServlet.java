package locacaomidias.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import locacaomidias.dao.MidiaDAO;
import locacaomidias.entidades.*;
import locacaomidias.utils.Utils;

/**
 *
 * @author nicho
 */
@WebServlet(name = "MidiaServlet", urlPatterns = {"/processaMidia"})
public class MidiaServlet extends HttpServlet {

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
        String acao = request.getParameter("acao") ;
        try (MidiaDAO dao = new MidiaDAO()) {
            
            if (acao.equals("inserir")) {
                
                
                String titulo = request.getParameter("titulo") ;
                String anoLan = request.getParameter("anoLancamento") ;
                String codigoB = request.getParameter("codigoBarras") ;
                Long duracaoM = Long.valueOf(request.getParameter("duracao")) ;
                Long AtorPrincipal = Long.valueOf(request.getParameter("idAtorPrincipal")) ;
                Long AtorCoadjuvante = Long.valueOf(request.getParameter("idAtorCoadjuvante")) ;
                Long genero = Long.valueOf(request.getParameter("idGenero")) ;
                Long ClassEtaria = Long.valueOf(request.getParameter("idClassEtaria")) ;
                Long ClassInterna = Long.valueOf(request.getParameter("idClassInterna")) ;
                Long Tipo = Long.valueOf(request.getParameter("idTipo")) ;
                
                ClassificacaoEtaria classE = new ClassificacaoEtaria() ;
                classE.setId(ClassEtaria);
                ClassificacaoInterna classI = new ClassificacaoInterna() ;
                classI.setId(ClassInterna);
                Ator coad = new Ator() ;
                coad.setId(AtorCoadjuvante);
                Ator prin = new Ator() ;
                prin.setId(AtorPrincipal);
                Genero gen = new Genero() ;
                gen.setId(genero);
                Tipo tipo = new Tipo() ;
                tipo.setId(Tipo);
                
                Midia m = new Midia() ;
                
                m.setTitulo(titulo);
                m.setDuracaoMinutos(duracaoM);
                m.setCodigoBarras(codigoB);
                m.setAnoLancamento(anoLan);
                
                m.setClasseEtaria(classE);
                m.setClasseInterna(classI);
                m.setCoadjuvante(coad);
                m.setGenero(gen);
                m.setPrincipal(prin);
                m.setTipo(tipo);
                
                Utils.validar(m, "id");
                dao.salvar(m);
                
                disp = request.getRequestDispatcher( 
                            "/formularios/midias/listagem.jsp" );
            } else if (acao.equals("alterar")) {
                
                Long id = Long.valueOf(request.getParameter("id")) ;
                String titulo = request.getParameter("titulo") ;
                String anoLan = request.getParameter("anoLancamento") ;
                String codigoB = request.getParameter("codigoBarras") ;
                Long duracaoM = Long.valueOf(request.getParameter("duracao")) ;
                Long AtorPrincipal = Long.valueOf(request.getParameter("idAtorPrincipal")) ;
                Long AtorCoadjuvante = Long.valueOf(request.getParameter("idAtorCoadjuvante")) ;
                Long genero = Long.valueOf(request.getParameter("idGenero")) ;
                Long ClassEtaria = Long.valueOf(request.getParameter("idClassEtaria")) ;
                Long ClassInterna = Long.valueOf(request.getParameter("idClassInterna")) ;
                Long Tipo = Long.valueOf(request.getParameter("idTipo")) ;
                
                ClassificacaoEtaria classE = new ClassificacaoEtaria() ;
                classE.setId(ClassEtaria);
                ClassificacaoInterna classI = new ClassificacaoInterna() ;
                classI.setId(ClassInterna);
                Ator coad = new Ator() ;
                coad.setId(AtorCoadjuvante);
                Ator prin = new Ator() ;
                prin.setId(AtorPrincipal);
                Genero gen = new Genero() ;
                gen.setId(genero);
                Tipo tipo = new Tipo() ;
                tipo.setId(Tipo);
                
                Midia m = new Midia() ;
                
                m.setId(id);
                m.setTitulo(titulo);
                m.setDuracaoMinutos(duracaoM);
                m.setCodigoBarras(codigoB);
                m.setAnoLancamento(anoLan);
                
                m.setClasseEtaria(classE);
                m.setClasseInterna(classI);
                m.setCoadjuvante(coad);
                m.setGenero(gen);
                m.setPrincipal(prin);
                m.setTipo(tipo);
                
                Utils.validar(m);
                dao.atualizar(m);
                
                
                disp = request.getRequestDispatcher( 
                            "/formularios/midias/listagem.jsp" );
            } else if (acao.equals("excluir")) {
                
                Long id = Long.valueOf(request.getParameter("id")) ;
                
                Midia m = dao.obterPorId(id) ;
                
                dao.excluir(m);
                
                disp = request.getRequestDispatcher( 
                            "/formularios/midias/listagem.jsp" );
            } else {
                
                Long id = Utils.getLong( request, "id" );
                Midia e = dao.obterPorId( id );
                request.setAttribute( "Midia", e );
                
                if ( acao.equals( "prepararAlteracao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/midias/alterar.jsp" );
                } else if ( acao.equals( "prepararExclusao" ) ) {
                    disp = request.getRequestDispatcher( 
                            "/formularios/midias/excluir.jsp" );
                }
                
            }
            
        } catch (SQLException ex) {
            disp = Utils.prepararDespachoErro(request, ex.getMessage()) ;
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
