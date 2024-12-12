package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.Locacao ;
import locacaomidias.utils.Utils;
import java.sql.ResultSet ;
/**
 *
 * @author nicho
 */
public class LocacaoDAO extends DAO<Locacao>{

    public LocacaoDAO() throws SQLException {
        super() ;
    }

    
    @Override
    public void salvar(Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                INSERT INTO 
                locacao( data_inicio, data_fim, cancelada, cliente_id ) 
                VALUES( ?, ?, ?, ? );
                """,
                new String[]{ "insert_id" } );

        stmt.setDate(1, obj.getDataInicio());
        stmt.setDate( 2, obj.getDataFim());
        stmt.setBoolean( 3, obj.getCancelada());
        stmt.setLong( 3, obj.getCliente().getId());
        

        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void atualizar(Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                UPDATE locacao
                SET
                    data_inicio = ?,
                    data_fim = ?,
                    cliente_id = ?,
                    cancelada = ?
                WHERE
                    id = ?;
                """ );

        stmt.setDate( 1, obj.getDataInicio());
        stmt.setDate( 2, obj.getDataFim());
        stmt.setLong( 3, obj.getCliente().getId());
        stmt.setBoolean( 4, obj.getCancelada());
        stmt.setLong( 5, obj.getId() );
        

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Locacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                DELETE FROM locacao
                WHERE
                    id = ?;
                """ );

        stmt.setLong( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Locacao> listarTodos() throws SQLException {
        List<Locacao> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    id,
                    data_inicio,
                    data_fim,
                    cancelada,
                    cliente_id
                FROM
                    locacao
                ORDER BY data_inicio;
                """ );

        ResultSet rs = stmt.executeQuery();

        ClienteDAO cliente = new ClienteDAO() ;
        while ( rs.next() ) {
            
            Locacao l = new Locacao();
            
            l.setId(rs.getLong("id"));
            l.setDataFim(rs.getDate("data_fim"));
            l.setDataInicio(rs.getDate("data_inicio"));
            l.setCancelada(rs.getBoolean("cancelada"));
            l.setCliente(
                cliente.obterPorId(rs.getLong("cliente_id")));
           
            lista.add( l );
        }
        return lista ;
    }

    @Override
    public Locacao obterPorId(Long id) throws SQLException {
        Locacao l = new Locacao();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    id,
                    data_inicio,
                    data_fim,
                    cancelada,
                    cliente_id
                FROM
                    locacao
                ORDER BY data_inicio;
                """ );

        ResultSet rs = stmt.executeQuery();

        ClienteDAO cliente = new ClienteDAO() ;
        if ( rs.next() ) {
            
            l.setId(rs.getLong("id"));
            l.setDataFim(rs.getDate("data_fim"));
            l.setDataInicio(rs.getDate("data_inicio"));
            l.setCancelada(rs.getBoolean("cancelada"));
            l.setCliente(
                cliente.obterPorId(rs.getLong("cliente_id")));
           
        }
        return l ;
    }
    
}
