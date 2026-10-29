
public abstract class Carro implements Ligavel {

    private String modelo;
    private int velocidade;

    public Carro(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void acelerar(int quantidade) {
        if (quantidade > 0 && velocidade + quantidade <= 200) {
            velocidade += quantidade;
        }
    }

    public String buzinar() {
        return "Beep beep!";
    }

    public abstract String exibirTipo();

    @Override
    public String ligar() {
        return modelo + ": veículo ligado";
    }

    @Override
    public String desligar() {
        return modelo + ": veículo desligado";
    }
}
