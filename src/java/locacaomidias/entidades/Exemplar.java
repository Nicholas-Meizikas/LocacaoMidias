package locacaomidias.entidades;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author nicho
 */
public class Exemplar {
    @NotNull
    private Long id;
    @NotNull
    private Boolean disponivel;
    @NotNull
    private Midia midia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    @Override
    public String toString() {
        return "Exemplar{" + "id=" + id + ", disponivel=" + disponivel + ", midia=" + midia + '}';
    }
    
    
    
}
