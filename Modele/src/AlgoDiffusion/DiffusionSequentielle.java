package AlgoDiffusion;

import ActiveObject.Canal;
import ActiveObject.Capteur;
import ActiveObject.CapteurImpl;

import java.util.ArrayList;
import java.util.List;

public class DiffusionSequentielle implements AlgoDiffusion{
    private Capteur capteur;
    private List<Canal> canaux = new ArrayList<>();
    private List<Canal> liste = new ArrayList<>();

    @Override
    public void configure(Capteur capteur, List<Canal> canaux) {
        this.capteur = capteur;
        this.canaux.addAll(canaux);
        this.liste.addAll(canaux);
    }

    @Override
    public void execute() {
        for(Canal canal : canaux){
            canal.update();
        }
    }

    @Override
    public int getValue(Canal canal) throws InterruptedException {
        lock(canal);
        return capteur.getValue();
    }

    @Override
    public List<Canal> getCanalList() {
        return this.liste;
    }

    public void lock(Canal canal) throws InterruptedException {
        List<Canal> listeCanaux = getCanalList();
        listeCanaux.remove(canal);
        while (!listeCanaux.isEmpty()){Thread.sleep(1);}
        Thread.sleep(5);
        if(listeCanaux.isEmpty())liste.addAll(canaux);
        canal.update();
    }
}
