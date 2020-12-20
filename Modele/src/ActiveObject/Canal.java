package ActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal{

    private Integer canalValue;
    private Capteur capteur;
    private Afficheur<Capteur> afficheur;
    private ScheduledExecutorService scheduler;
    private List<ObserverAsync> observers = new ArrayList<ObserverAsync>();

    public Canal(Integer canalValue, Capteur capteur){
        this.canalValue=canalValue;

    }

    public Future<Void> update(){
        return scheduler.schedule(new Update(),500, TimeUnit.MICROSECONDS);
    }

    public void attach(ObserverAsync observer) {

    }

    public void detach(ObserverAsync observer) {

    }

    public Future<Integer> getValue(){
        return scheduler.schedule(new GetValue(),500, TimeUnit.MICROSECONDS);
    }

    public void tick() {

    }

    public Future<Void> update(Capteur subject) {
        return null;
    }
}
