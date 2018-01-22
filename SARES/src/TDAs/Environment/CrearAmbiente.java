
package TDAs.Environment;

import Constants.Constants;


public class CrearAmbiente {
    Ambiente amb;
    public Ambiente crearAmbiente(String nombre){
        if(nombre == "NORMAL"){
            amb = new Clasico();
            amb.setId(Integer.toString(Constants.normal));
            return amb;
        }
        else if(nombre == "VIP"){
            amb = new Vip();
            amb.setId(Integer.toString(Constants.preferencial));
            return amb;
        }
        return null;
    }
}
