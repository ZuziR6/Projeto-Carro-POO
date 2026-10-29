
public class Motorola extends Celular {

    private boolean leitorDigital;

    public Motorola(String modelo, Bateria bateria, boolean leitorDigital) {
        super(modelo, bateria, false);
        this.leitorDigital = leitorDigital;
    }

    public boolean isLeitorDigital() {
        return leitorDigital;
    }
}
