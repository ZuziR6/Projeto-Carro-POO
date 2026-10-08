public class Carro {

    // Atributos privados: so a propria classe consegue mexer neles diretamente
    private String modelo; // modelo do carro (ex: Gol)
    private Tanque tanque; // ASSOCIACAO: o carro possui um objeto Tanque
    private int velocidade; // velocidade atual em km/h (comeca em 0)

    // Construtor: o carro so nasce se receber um modelo e um Tanque
    public Carro(String modelo, Tanque tanque) {
        this.modelo = modelo;
        this.tanque = tanque;
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

    // O carro apenas PEDE para o Tanque abastecer.
    // A regra de negocio (limite de 50 L) continua sendo do Tanque.
    public void abastecer(int quantidade) {
        tanque.abastecer(quantidade);
    }

    // Faz o carro buzinar. Este e o comportamento PADRAO de qualquer carro.
    // As classes filhas podem SOBRESCREVER (override) este metodo.
    public String buzinar() {
        return "Beep beep!";
    }

    // Retorna a velocidade atual
    public int getVelocidade() {
        return velocidade;
    }

    // Retorna os litros do tanque, perguntando ao objeto Tanque associado
    public int getTanque() {
        return tanque.getLitros();
    }
}