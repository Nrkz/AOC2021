package ActiveObject;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CanalImpl implements Canal{

    private Afficheur afficheur;
    private ScheduledExecutorService scheduler;

    public CanalImpl(Afficheur afficheur){
        this.afficheur=afficheur;
    }

    public Future<Void> update(){
        return scheduler.schedule(new Update(),500, TimeUnit.MICROSECONDS);
    }

    public Future<Integer> getValue(){
        return scheduler.schedule(new GetValue(),500, TimeUnit.MICROSECONDS);
    }
}
