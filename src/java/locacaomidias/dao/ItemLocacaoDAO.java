package locacaomidias.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaomidias.entidades.ItemLocacao ;
import locacaomidias.utils.Utils;
/**
 *
 * @author nicho
 */
public class ItemLocacaoDAO extends DAO<ItemLocacao>{

    public ItemLocacaoDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(ItemLocacao obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                INSERT INTO 
                item_locacao(  locacao_id, exemplar_codigo_interno, valor) 
                VALUES( ?, ?, ? );
                """,
                new String[]{ "insert_id" } );

        stmt.setLong( 1, obj.getLocacao().getId() );
        stmt.setLong( 2, obj.getExemplar().getId());
        stmt.setFloat(3, obj.getValor());
        

        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void atualizar(ItemLocacao obj) throws SQLException {
        //Não faz sentido
    }

    @Override
    public void excluir(ItemLocacao obj) throws SQLException {
        //Não faz sentido
    }

    @Override
    public List<ItemLocacao> listarTodos() throws SQLException {
        //não faz sentido
        return null ;
    }

    @Override
    public ItemLocacao obterPorId(Long id) throws SQLException {
        //Não faz sentido
        return null ;
    }
    
    public List<ItemLocacao> ObterPorLocacaoID(Long id) throws SQLException {
        List<ItemLocacao> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    locacao_id,
                    exemplar_codigo_interno,
                    valor
                FROM
                    item_locacao
                WHERE
                    locacao_id = ?
                ORDER BY exemplar_codigo_interno;
                """ );
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        LocacaoDAO locacao = new LocacaoDAO() ;
        ExemplarDAO exemplar = new ExemplarDAO() ;
        while ( rs.next() ) {

            ItemLocacao i = new ItemLocacao();
            i.setExemplar(exemplar.obterPorId(rs.getLong("exemplar_codigo_interno")));
            i.setLocacao(locacao.obterPorId(rs.getLong("locacao_id")));
            i.setValor(rs.getFloat("valor"));
            

            lista.add( i );

        }

        locacao.close();
        exemplar.close() ;
        rs.close();
        stmt.close();

        return lista;
    }
    public List<ItemLocacao> ObterPorExemplar(Long id) throws SQLException {
        List<ItemLocacao> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    locacao_id,
                    exemplar_codigo_interno,
                    valor
                FROM
                    item_locacao
                WHERE
                    exemplar_codigo_interno = ?
                ORDER BY exemplar_codigo_interno;
                """ );
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        LocacaoDAO locacao = new LocacaoDAO() ;
        ExemplarDAO exemplar = new ExemplarDAO() ;
        while ( rs.next() ) {

            ItemLocacao i = new ItemLocacao();
            i.setExemplar(exemplar.obterPorId(rs.getLong("exemplar_codigo_interno")));
            i.setLocacao(locacao.obterPorId(rs.getLong("locacao_id")));
            i.setValor(rs.getFloat("valor"));
            

            lista.add( i );

        }

        locacao.close();
        exemplar.close() ;
        rs.close();
        stmt.close();

        return lista;
    }
        
}
