package ActiveObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * La classe Afficheur qui affiche la valeur du Capteur
 */
public class Afficheur{
	
	ArrayList<Integer> values;
	int id;


    /**
     * Constructeur de la Classe Afficheur
     * @param id id
     */
    public Afficheur(int id){
        this.id = id;
        //Values sert à comparer les valeurs pour les tests.
        this.values = new ArrayList<>();
    }

    /**
     * Met à jour l'afficheur et fais appel à getValue() de canal
     * @param canal canal
     * @return Void
     * @throws ExecutionException catch
     * @throws InterruptedException catch
     */
	public Void update(Canal canal) throws ExecutionException, InterruptedException {
        Future val = canal.getValue();
        Logger.getGlobal().info("Afficheur "+ id +" value : " + val.get());
        values.add((Integer) val.get());
        return null;
	}

    /**
     * Getter de values
     * @return values
     */
	public ArrayList<Integer> getValues(){
        return this.values;
    }

}
