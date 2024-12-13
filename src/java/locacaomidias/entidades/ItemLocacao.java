package locacaomidias.entidades;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author nicho
 */
public class ItemLocacao {
    @NotNull
    private Long id ;
    @NotNull
    private Locacao locacao ;
    @NotNull
    private Exemplar exemplar ;
    @NotNull
    private float valor ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ItemLocacao{" + "id=" + id + ", locacao=" + locacao.toString() + ", exemplar=" + exemplar + ", valor=" + valor + '}';
    }
    
}
