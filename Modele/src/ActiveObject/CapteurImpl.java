package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CapteurImpl implements  Capteur{

    private int value;
    AlgoDiffusion algo;
    List<ObserverAsync> listobs;
    ArrayList<ObserverAsync> listAlgo;


    public CapteurImpl(AlgoDiffusion algo){
        value = 0;
        this.algo = algo;
    }

    @Override
    public void tick() throws ExecutionException, InterruptedException {
        //lock
        value++;
        for(int i=0;i<listobs.size();i++){
            listobs.get(i).update(this);
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    public boolean lock(){
        return true;
    }
}
