package ActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import AlgoDiffusion.AlgoDiffusion;
import AlgoDiffusion.DiffusionAtomique;
import AlgoDiffusion.DiffusionEpoque;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AlgoDiffusion algo = new DiffusionEpoque();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        CapteurImpl capteur = new CapteurImpl(algo);
        Afficheur a1 = new Afficheur(1);
        Afficheur a2 = new Afficheur(2);
        Afficheur a3 = new Afficheur(3);
        Afficheur a4 = new Afficheur(4);
        Canal c1 = new Canal(capteur,scheduler,a1);
        Canal c2 = new Canal(capteur,scheduler,a2);
        Canal c3 = new Canal(capteur,scheduler,a3);
        Canal c4 = new Canal(capteur,scheduler,a4);


        List<Canal> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        algo.configure(capteur,c);
        capteur.tick();

    }
}
