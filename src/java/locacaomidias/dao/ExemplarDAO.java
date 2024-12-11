package locacaomidias.dao;

import java.sql.PreparedStatement;
import locacaomidias.entidades.Exemplar;
import locacaomidias.entidades.Midia ;
import java.sql.ResultSet ;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.utils.Utils;

/**
 *
 * @author nicho
 */
public class ExemplarDAO extends DAO<Exemplar>{

    public ExemplarDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Exemplar obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                INSERT INTO 
                exemplar( disponivel, midia_id ) 
                VALUES( ?, ? );
                """,
                new String[]{ "insert_id" } );

        stmt.setBoolean(1, obj.getDisponivel());
        stmt.setLong(2, obj.getMidia().getId());
        
        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void atualizar(Exemplar obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                UPDATE exemplar
                SET
                    disponivel = ?,
                    midia_id = ?
                WHERE
                    id = ?;
                """ );

        stmt.setBoolean(1, obj.getDisponivel());
        stmt.setLong(2, obj.getMidia().getId());
        stmt.setLong( 3, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Exemplar obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                DELETE FROM exemplar
                WHERE
                    id = ?;
                """ );

        stmt.setLong( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Exemplar> listarTodos() throws SQLException {
        List<Exemplar> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    codigo_interno,
                    disponivel,
                    midia_id
                FROM
                    exemplar
                ORDER BY midia_id, disponivel;
                """ );

        ResultSet rs = stmt.executeQuery();
        
        MidiaDAO midia = new MidiaDAO() ;
        while ( rs.next() ) {

            Exemplar e = new Exemplar();
            
            e.setId(rs.getLong("codigo_interno"));
            e.setDisponivel(rs.getBoolean("disponivel"));
            e.setMidia(midia.obterPorId(rs.getLong("midia_id")));
            
            lista.add( e );

        }
        
        midia.close();
        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Exemplar obterPorId(Long id) throws SQLException {
        Exemplar e = new Exemplar();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    codigo_interno,
                    disponivel,
                    midia_id
                FROM
                    exemplar
                ORDER BY midia_id, disponivel;
                """ );

        ResultSet rs = stmt.executeQuery();
        
        MidiaDAO midia = new MidiaDAO() ;
        while ( rs.next() ) {

            e.setId(rs.getLong("codigo_interno"));
            e.setDisponivel(rs.getBoolean("disponivel"));
            e.setMidia(midia.obterPorId(rs.getLong("midia_id")));
            
        }
        
        midia.close();
        rs.close();
        stmt.close();

        return e;
    }
    
}
