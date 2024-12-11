package locacaomidias.entidades;

import jakarta.validation.constraints.NotNull;
import java.sql.Date;

/**
 *
 * @author nicho
 */
public class Locacao {
    @NotNull
    private Long id;
    @NotNull
    private Long dataInicio;
    @NotNull
    private Date dataFim;
    @NotNull
    private Boolean cancelada;
    @NotNull
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Long dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", cancelada=" + cancelada + ", cliente=" + cliente + '}';
    }
}
