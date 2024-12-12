package locacaomidias.dao;

import java.sql.SQLException;
import java.util.List;
import locacaomidias.entidades.Ator ;
import locacaomidias.utils.Utils;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.ArrayList;
/**
 *
 * @author nicho
 */
public class AtorDAO extends DAO<Ator> {

    public AtorDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                INSERT INTO 
                ator( nome, sobrenome, data_estreia ) 
                VALUES( ?, ?, ? );
                """,
                new String[]{ "insert_id" } );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome());
        stmt.setDate( 3, obj.getDataEstreia());
        

        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                UPDATE ator
                SET
                    nome = ?,
                    sobrenome = ?,
                    data_estreia = ?
                WHERE
                    id = ?;
                """ );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate( 3, obj.getDataEstreia());
        stmt.setLong( 4, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                DELETE FROM ator
                WHERE
                    id = ?;
                """ );

        stmt.setLong( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Ator> listarTodos() throws SQLException {
        List<Ator> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    id,
                    nome,
                    sobrenome,
                    data_estreia
                FROM
                    ator
                ORDER BY nome, sobrenome;
                """ );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Ator a = new Ator();
            
            a.setId(rs.getLong("id"));
            a.setDataEstreia(rs.getDate("data_estreia"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));

            lista.add( a );

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Ator obterPorId(Long id) throws SQLException {
        Ator a = new Ator() ;

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    id,
                    nome,
                    sobrenome,
                    data_estreia
                FROM
                    ator
                WHERE
                    id = ?
                ORDER BY nome, sobrenome;
                """ );

        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            a.setId(rs.getLong("id"));
            a.setDataEstreia(rs.getDate("data_estreia"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));

        }

        rs.close();
        stmt.close();

        return a;
    }
    
}
