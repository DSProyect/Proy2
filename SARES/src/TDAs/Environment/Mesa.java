package TDAs.Environment;

public class Mesa {
    private String idMesa;
    private int asientos;
    private boolean disponibilidad,eliminado;
    private Ambiente ambiente;

    public Mesa(String idMesa, int asientos, Ambiente ambiente) {
        this.idMesa = idMesa;
        this.asientos = asientos;
        this.ambiente = ambiente;
        this.disponibilidad = true;
        this.eliminado = false;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
}
