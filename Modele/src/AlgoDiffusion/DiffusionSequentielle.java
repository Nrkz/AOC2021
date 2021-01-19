package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class DiffusionSequentielle implements AlgoDiffusion{
    private Capteur capteur;
    private List<Canal> canaux = new ArrayList<>();
    private List<Future> listeFuture = new ArrayList<>();

    @Override
    public void configure(Capteur capteur, List<Canal> canaux) {
        this.capteur = capteur;
        this.canaux = canaux;
    }

    @Override
    public void execute() {
        if(futuresDone()){
            this.listeFuture = new ArrayList<>();
            for (Canal canal : canaux){
                listeFuture.add(canal.update());
            }
        }
    }

    @Override
    public int getValue(Canal canal) throws InterruptedException {
        return capteur.getValue();
    }

    @Override
    public List<Canal> getCanalList() {
        return this.canaux;
    }

    public boolean futuresDone(){
        boolean result = true;
        for(Future future : listeFuture){
            result &= future.isDone();
        }
        return result;
    }


}
