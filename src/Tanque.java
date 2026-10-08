public class Tanque {

    // Litros de combustivel atualmente no tanque (privado para proteger o estado)
    private int litros;

    // Construtor: o tanque ja nasce com uma quantidade inicial de litros
    public Tanque(int litros) {
        this.litros = litros;
    }

    // Retorna os litros atuais
    public int getLitros() {
        return litros;
    }

    // Coloca combustivel no tanque.
    // Regra de negocio: quantidade maior que zero e capacidade maxima de 50 litros.
    public void abastecer(int quantidade) {
        if (quantidade > 0 && litros + quantidade <= 50) {
            litros = litros + quantidade;
        }
    }
}