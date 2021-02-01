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
     * @param id
     */
    public Afficheur(int id){
        this.id = id;
        ArrayList<Integer> values = new ArrayList<>();
        this.values = values;
    }

    /**
     * Met à jour l'afficheur et fais appel à getValue() de canal
     * @param canal
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
	public Void update(Canal canal) throws ExecutionException, InterruptedException {
        Future<Integer> val = canal.getValue();
        Logger.getGlobal().info("Afficheur "+ id +" value : " + val.get());
        values.add(val.get());
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
