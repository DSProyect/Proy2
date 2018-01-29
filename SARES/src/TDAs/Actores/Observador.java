
package TDAs.Actores;

import java.util.ArrayList;
import java.util.List;

public class Observador {
    private List<Update> observers;

    public Observador() {
        super();
        observers=new ArrayList<>();
    }
    public void suscribirObservador(Update obs){
        observers.add(obs);
    }
    public void removerObservador(Update obs){
        observers.remove(obs);
    }
    public void notificarObservadores(){
        for(Update obs: observers){
            obs.update();
        }
    }
}