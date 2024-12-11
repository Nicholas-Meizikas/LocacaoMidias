package locacaomidias.dao;

import java.sql.PreparedStatement;
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
public class MidiaDAO extends DAO<Midia>{

    public MidiaDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                INSERT INTO 
                midia( titulo, ano_lancamento, codigo_barras, duracao_em_minutos,
                        ator_principal, ator_coadjuvante, genero_id, classificacao_etaria_id,
                        tipo_id, classificacao_interna_id) 
                VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );
                """,
                new String[]{ "insert_id" } );

        
        stmt.setString( 1, obj.getTitulo());
        stmt.setString( 2, obj.getAnoLancamento());
        stmt.setString( 3, obj.getCodigoBarras());
        stmt.setLong(4, obj.getDuracaoMinutos());
        stmt.setLong(5, obj.getPrincipal().getId()) ;
        stmt.setLong(6, obj.getCoadjuvante().getId()) ;
        stmt.setLong(7, obj.getGenero().getId()) ;
        stmt.setLong(8, obj.getClasseEtaria().getId()) ;
        stmt.setLong(9, obj.getTipo().getId()) ;
        stmt.setLong(10, obj.getClasseInterna().getId()) ;
        

        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void atualizar(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                UPDATE midia 
                    SET
                        titulo = ?, 
                        ano_lancamento = ?, 
                        codigo_barras = ?, 
                        duracao_em_minutos = ?,
                        ator_principal = ?, 
                        ator_coadjuvante = ?, 
                        genero_id = ?, 
                        classificacao_etaria_id = ?,
                        tipo_id = ?, 
                        classificacao_interna_id = ? 
                    WHERE
                        id = ? ;
                """,
                new String[]{ "insert_id" } );

        
        stmt.setString( 1, obj.getTitulo());
        stmt.setString( 2, obj.getAnoLancamento());
        stmt.setString( 3, obj.getCodigoBarras());
        stmt.setLong(4, obj.getDuracaoMinutos());
        stmt.setLong(5, obj.getPrincipal().getId()) ;
        stmt.setLong(6, obj.getCoadjuvante().getId()) ;
        stmt.setLong(7, obj.getGenero().getId()) ;
        stmt.setLong(8, obj.getClasseEtaria().getId()) ;
        stmt.setLong(9, obj.getTipo().getId()) ;
        stmt.setLong(10, obj.getClasseInterna().getId()) ;
        stmt.setLong(11, obj.getId());
        

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Midia obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                DELETE FROM midia
                WHERE
                    id = ?;
                """ );

        stmt.setLong( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Midia> listarTodos() throws SQLException {
        List<Midia> lista = new ArrayList<>() ;
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                 SELECT 
                    id, titulo, ano_lancamento, codigo_barras, duracao_em_minutos,
                    ator_principal, ator_coadjuvante, genero_id, classificacao_etaria_id,
                    tipo_id, classificacao_interna_id
                 FROM
                    midia
                 order by titulo, ano_lancamento ;
                """,
                new String[]{ "insert_id" } );

        ResultSet rs = stmt.executeQuery() ;
        AtorDAO ator = new AtorDAO() ;
        ClassificacaoEtariaDAO classE = new ClassificacaoEtariaDAO();
        ClassificacaoInternaDAO classI = new ClassificacaoInternaDAO() ;
        GeneroDAO genero = new GeneroDAO() ;
        TipoDAO tipo = new TipoDAO() ;
        while (rs.next()) {
            Midia m = new Midia() ;
            
            m.setAnoLancamento(rs.getString("ano_lancamento"));
            m.setCodigoBarras(rs.getString("codigo_barras"));
            m.setDuracaoMinutos(rs.getLong("duracao_em_minutos"));
            m.setId(rs.getLong("id"));
            m.setTitulo(rs.getString("titulo"));
            
            m.setClasseEtaria(classE.obterPorId(rs.getLong("classificacao_etaria_id")));
            m.setClasseInterna(classI.obterPorId(rs.getLong("classificacao_interna_id")));
            m.setPrincipal(ator.obterPorId(rs.getLong("ator_principal")));
            m.setTipo(tipo.obterPorId(rs.getLong("tipo_id")));
            m.setGenero(genero.obterPorId(rs.getLong("genero_id")));
            m.setCoadjuvante(ator.obterPorId(rs.getLong("ator_coadjuvante")));
            
            lista.add(m) ;
            
        }
        ator.close();
        classE.close();
        classI.close();
        genero.close();
        tipo.close();
        
        stmt.close();
        return lista ;
    }

    @Override
    public Midia obterPorId(Long id) throws SQLException {
        Midia m = new Midia() ;
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                 SELECT 
                    id, titulo, ano_lancamento, codigo_barras, duracao_em_minutos,
                    ator_principal, ator_coadjuvante, genero_id, classificacao_etaria_id,
                    tipo_id, classificacao_interna_id
                 FROM
                    midia
                 order by titulo, ano_lancamento ;
                """,
                new String[]{ "insert_id" } );

        ResultSet rs = stmt.executeQuery() ;
        
        AtorDAO ator = new AtorDAO() ;
        ClassificacaoEtariaDAO classE = new ClassificacaoEtariaDAO();
        ClassificacaoInternaDAO classI = new ClassificacaoInternaDAO() ;
        GeneroDAO genero = new GeneroDAO() ;
        TipoDAO tipo = new TipoDAO() ;
        
        if (rs.next()) {
            
            
            m.setAnoLancamento(rs.getString("ano_lancamento"));
            m.setCodigoBarras(rs.getString("codigo_barras"));
            m.setDuracaoMinutos(rs.getLong("duracao_em_minutos"));
            m.setId(rs.getLong("id"));
            m.setTitulo(rs.getString("titulo"));
            
            m.setClasseEtaria(classE.obterPorId(rs.getLong("classificacao_etaria_id")));
            m.setClasseInterna(classI.obterPorId(rs.getLong("classificacao_interna_id")));
            m.setPrincipal(ator.obterPorId(rs.getLong("ator_principal")));
            m.setTipo(tipo.obterPorId(rs.getLong("tipo_id")));
            m.setGenero(genero.obterPorId(rs.getLong("genero_id")));
            m.setCoadjuvante(ator.obterPorId(rs.getLong("ator_coadjuvante")));
            
        }
        ator.close();
        classE.close();
        classI.close();
        genero.close();
        tipo.close();
        
        stmt.close();
        return m ;
    }
    
}
