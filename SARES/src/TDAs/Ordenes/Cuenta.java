
package TDAs.Ordenes;

import Constants.Prioridad;

public class Cuenta {
    private String id;
    private String idMesa;
    private int tratoEspecial;
    
    public Cuenta(String id, String idMesa, boolean tratoEspecial) {
        this.id = id;
        this.idMesa = idMesa;
        if(tratoEspecial)
            this.tratoEspecial = Prioridad.vip;
        else
            this.tratoEspecial = Prioridad.normal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }
    
}
