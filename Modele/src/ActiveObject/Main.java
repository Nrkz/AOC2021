package ActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import AlgoDiffusion.AlgoDiffusion;
import AlgoDiffusion.DiffusionAtomique;
import AlgoDiffusion.DiffusionEpoque;
import AlgoDiffusion.DiffusionSequentielle;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AlgoDiffusion algo = new DiffusionAtomique();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        CapteurImpl capteur = new CapteurImpl(algo);
        Afficheur a1 = new Afficheur(1);
        Afficheur a2 = new Afficheur(2);
        Afficheur a3 = new Afficheur(3);
        Afficheur a4 = new Afficheur(4);
        Canal c1 = new Canal(capteur,scheduler,a1,algo);
        Canal c2 = new Canal(capteur,scheduler,a2,algo);
        Canal c3 = new Canal(capteur,scheduler,a3,algo);
        Canal c4 = new Canal(capteur,scheduler,a4,algo);


        List<Canal> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        algo.configure(capteur,c);
        for(int i = 0; i <10; i++){
            capteur.tick();
            Thread.sleep(700);
        }
        c1.getScheduler().shutdown();
        c2.getScheduler().shutdown();
        c3.getScheduler().shutdown();
        c4.getScheduler().shutdown();
    }
}
