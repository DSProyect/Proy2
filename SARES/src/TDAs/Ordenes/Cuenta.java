
package TDAs.Ordenes;

import Constants.Constants;


public class Cuenta {
    private String id;
    private String idMesa;
    private int tratoEspecial;
    private int total;
    
    public Cuenta(String id, String idMesa, boolean tratoEspecial) {
        this.id = id;
        this.idMesa = idMesa;
        if(tratoEspecial)
            this.tratoEspecial = Constants.preferencial;
        else
            this.tratoEspecial = Constants.normal;
    }

    public int getTratoEspecial() {
        return tratoEspecial;
    }

    public void setTratoEspecial(int tratoEspecial) {
        this.tratoEspecial = tratoEspecial;
    }

    public int getTotal() {
        return total;
    }

    public void calcularTotal() {
        //Obtener total de la cuenta 
        //obtenerTotalCuenta(int id);
        this.total = total;
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
