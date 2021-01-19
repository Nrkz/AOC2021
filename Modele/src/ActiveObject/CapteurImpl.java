package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CapteurImpl implements  Capteur{

    private int value;
    private AlgoDiffusion algoD;
    public boolean verrou;


    public CapteurImpl(AlgoDiffusion algo){
        value = 0;
        this.algoD = algo;
    }

    public void tick() throws ExecutionException, InterruptedException{
        value++;
        algoD.execute();
    }

    @Override
    public int getValue() {
        return value;
    }

}
