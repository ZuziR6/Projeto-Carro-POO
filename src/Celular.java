
public abstract class Celular implements Recarregavel {

    private String modelo;
    private Bateria bateria;
    private boolean ligado;

    public Celular(String modelo, Bateria bateria, boolean ligado) {
        this.modelo = modelo;
        this.bateria = bateria;
        this.ligado = ligado;
    }

    public String getModelo() {
        return modelo;
    }

    public int getNivelBateria() {
        return bateria.getPorcentagem();
    }

    public Bateria getBateria() {
        return bateria;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    @Override
    public void recarregar(int quantidade) {
        bateria.carregar(quantidade);
    }
}
