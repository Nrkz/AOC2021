package ActiveObject;

public class CapteurImpl implements Capteur{

    private int value;

    @Override
    public void tick() {
        value++;
        //execute()
    }

    @Override
    public int getValue() {
        return value;
    }
}
