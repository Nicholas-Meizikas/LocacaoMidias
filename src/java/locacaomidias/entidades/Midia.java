package locacaomidias.entidades;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author nicho
 */
public class Midia {

    @NotNull
    private Long id;
    @NotNull
    private String titulo;
    @NotNull
    private String anoLancamento;
    @NotNull
    private String codigoBarras;
    @NotNull
    private Long duracaoMinutos;
    @NotNull
    private Ator principal;
    @NotNull
    private Ator coadjuvante;
    @NotNull
    private Genero genero;
    @NotNull
    private ClassificacaoEtaria classeEtaria;
    @NotNull
    private ClassificacaoInterna classeInterna;
    @NotNull
    private Tipo tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Long getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Long duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Ator getPrincipal() {
        return principal;
    }

    public void setPrincipal(Ator principal) {
        this.principal = principal;
    }

    public Ator getCoadjuvante() {
        return coadjuvante;
    }

    public void setCoadjuvante(Ator coadjuvante) {
        this.coadjuvante = coadjuvante;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ClassificacaoEtaria getClasseEtaria() {
        return classeEtaria;
    }

    public void setClasseEtaria(ClassificacaoEtaria classeEtaria) {
        this.classeEtaria = classeEtaria;
    }

    public ClassificacaoInterna getClasseInterna() {
        return classeInterna;
    }

    public void setClasseInterna(ClassificacaoInterna classeInterna) {
        this.classeInterna = classeInterna;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Midia{" + "id=" + id + ", titulo=" + titulo + ", anoLancamento=" + anoLancamento + ", codigoBarras=" + codigoBarras + ", duracaoMinutos=" + duracaoMinutos + ", principal=" + principal + ", coadjuvante=" + coadjuvante + ", genero=" + genero + ", classeEtaria=" + classeEtaria + ", classeInterna=" + classeInterna + ", tipo=" + tipo + '}';
    }
    
    
}
