package ActiveObject;

import AlgoDiffusion.AlgoDiffusion;

import java.util.concurrent.ExecutionException;

public class CapteurImpl implements  Capteur{

    private int value;
    private AlgoDiffusion algoD;
    public boolean lock;


    public CapteurImpl(AlgoDiffusion algo){
        this.value = 0;
        this.algoD = algo;
        this.lock = false;
    }

    public void tick() throws ExecutionException, InterruptedException{
        if(!isLock()) {
            value++;
            algoD.execute();
        }
    }

    @Override
    public int getValue() {
        return value;
    }

    public boolean isLock(){
        return this.lock;
    }

    public void verrou(boolean bol){
        this.lock = bol;
    }

}
