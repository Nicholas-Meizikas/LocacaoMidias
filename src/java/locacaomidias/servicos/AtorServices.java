package locacaomidias.servicos;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import locacaomidias.entidades.Ator;
import locacaomidias.dao.AtorDAO ;

/**
 *
 * @author nicho
 */
public class AtorServices {
    public List<Ator> getTodos() {

        List<Ator> lista = new ArrayList<>();

        try ( AtorDAO dao = new AtorDAO() ) {
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        }

        return lista;

    }
}
