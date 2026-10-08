public class Carro {

    // Atributos PRIVADOS: so a propria classe consegue mexer neles diretamente
    private String modelo; // modelo do carro (ex: Gol)
    private int combustivel; // litros de combustivel no tanque
    private int velocidade; // velocidade atual em km/h (comeca em 0)

    // Construtor: define o que o carro PRECISA ter para "nascer".
    // Sem informar o modelo nao e possivel criar um Carro.
    // Usa o setter para atribuir o modelo.
    public Carro(String modelo) {
        setModelo(modelo);
    }

    // Getter do modelo: permite apenas LER o valor
    public String getModelo() {
        return modelo;
    }

    // Setter do modelo: permite trocar o modelo do carro
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Aumenta a velocidade do carro.
    // Regra de negocio: a quantidade deve ser maior que zero
    // e a velocidade nao pode ultrapassar 200 km/h.
    public void acelerar(int quantidade) {
        if (quantidade > 0 && velocidade + quantidade <= 200) {
            velocidade = velocidade + quantidade;
        }
    }

    // Coloca combustivel no tanque.
    // Regra de negocio: a quantidade deve ser maior que zero
    // e o tanque nao pode passar de 50 litros.
    public void abastecer(int quantidade) {
        if (quantidade > 0 && combustivel + quantidade <= 50) {
            combustivel = combustivel + quantidade;
        }
    }

    // Retorna a velocidade atual (so leitura: nao existe setVelocidade de
    // proposito)
    public int getVelocidade() {
        return velocidade;
    }

    // Retorna os litros de combustivel (so leitura: nao existe setCombustivel de
    // proposito)
    public int getCombustivel() {
        return combustivel;
    }
}