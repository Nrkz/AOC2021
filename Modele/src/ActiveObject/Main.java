package ActiveObject;

import java.util.concurrent.ExecutionException;

import AlgoDiffusion.AlgoDiffusion;
import AlgoDiffusion.DiffusionAtomique;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        AlgoDiffusion algo = new DiffusionAtomique();
        CapteurImpl capteur = new CapteurImpl(algo);
        Canal c1 = new Canal(capteur);
        Canal c2 = new Canal(capteur);
        Canal c3 = new Canal(capteur);
        Canal c4 = new Canal(capteur);
        Afficheur a1 = new Afficheur(c1);
        Afficheur a2 = new Afficheur(c2);
        Afficheur a3 = new Afficheur(c3);
        Afficheur a4 = new Afficheur(c4);

        capteur.tick();
    }
}
