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
        Canal c1 = new Canal(capteur,scheduler);
        Canal c2 = new Canal(capteur,scheduler);
        Canal c3 = new Canal(capteur,scheduler);
        Canal c4 = new Canal(capteur,scheduler);
        Afficheur a1 = new Afficheur(c1);
        Afficheur a2 = new Afficheur(c2);
        Afficheur a3 = new Afficheur(c3);
        Afficheur a4 = new Afficheur(c4);

        List<Canal> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        algo.configure(capteur,c);
        capteur.tick();
        c1.getScheduler().shutdown();
        c2.getScheduler().shutdown();
        c3.getScheduler().shutdown();
        c4.getScheduler().shutdown();
    }
}
