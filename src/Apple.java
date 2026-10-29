
public class Apple extends Celular {

    private boolean faceId;

    public Apple(String modelo, Bateria bateria, boolean faceId) {
        super(modelo, bateria, false);
        this.faceId = faceId;
    }

    public boolean isFaceId() {
        return faceId;
    }
}
