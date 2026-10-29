
public class Tanque {

    private int litros;

    public Tanque(int litros) {
        if (litros >= 0 && litros <= 50) {
            this.litros = litros;
        } else {
            this.litros = 0;
        }
    }

    public int getLitros() {
        return litros;
    }

    public void abastecer(int quantidade) {
        if (quantidade > 0 && litros + quantidade <= 50) {
            litros += quantidade;
        }
    }
}
