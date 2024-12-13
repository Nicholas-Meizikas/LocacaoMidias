package locacaomidias.entidades;

import jakarta.validation.constraints.NotNull;
import java.sql.Date ;

/**
 *
 * @author nicho
 */
public class Ator {
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;
    @NotNull
    private Date dataEstreia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Date dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    @Override
    public String toString() {
        return "Ator{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataEstreia=" + dataEstreia + '}';
    }
    
    
}
