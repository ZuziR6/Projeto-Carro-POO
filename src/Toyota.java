
public class Toyota extends Carro {

    private boolean modoHibrido;
    private Tanque tanque;

    public Toyota() {
        super("Toyota Corolla");
        this.modoHibrido = true;
        this.tanque = new Tanque(0);
    }

    public boolean isModoHibrido() {
        return modoHibrido;
    }

    public void setModoHibrido(boolean modoHibrido) {
        this.modoHibrido = modoHibrido;
    }

    public void abastecer(int quantidade) {
        tanque.abastecer(quantidade);
    }

    public int getTanque() {
        return tanque.getLitros();
    }

    @Override
    public String exibirTipo() {
        return "Sedan híbrido";
    }

    @Override
    public String buzinar() {
        return "Toyota: Pim-pim!";
    }
}
