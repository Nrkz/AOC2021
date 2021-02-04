package test;

import ActiveObject.*;
import AlgoDiffusion.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

class DiffusionEpoqueTest {

    @Test
    void execute() throws ExecutionException, InterruptedException {

        AlgoDiffusion algo = new DiffusionEpoque();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        CapteurImpl capteur = new CapteurImpl(algo);
        Afficheur a1 = new Afficheur(1);
        Afficheur a2 = new Afficheur(2);
        Afficheur a3 = new Afficheur(3);
        Afficheur a4 = new Afficheur(4);
        Canal c1 = new Canal(capteur, scheduler, a1);
        Canal c2 = new Canal(capteur, scheduler, a2);
        Canal c3 = new Canal(capteur, scheduler, a3);
        Canal c4 = new Canal(capteur, scheduler, a4);


        List<Canal> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);

        algo.configure(capteur);
        for (int i = 0; i < 10; i++) {
            capteur.tick();
            Thread.sleep(700);
        }

        ArrayList<Integer> val1 = a1.getValues();
        ArrayList<Integer> val2 = a2.getValues();
        ArrayList<Integer> val3 = a3.getValues();
        ArrayList<Integer> val4 = a4.getValues();


        assertFalse(val1.isEmpty());
        assertFalse(val2.isEmpty());
        assertFalse(val3.isEmpty());
        assertFalse(val4.isEmpty());

        c1.getScheduler().shutdown();
        c2.getScheduler().shutdown();
        c3.getScheduler().shutdown();
        c4.getScheduler().shutdown();

        }
}