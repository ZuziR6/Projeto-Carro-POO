public class Bateria implements Recarregavel {

    private int porcentagem;

    public Bateria(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void carregar(int quantidade) {
        if (quantidade > 0 && porcentagem + quantidade <= 100) {
            porcentagem = porcentagem + quantidade;
        }
    }

    public void setPorcentagem(int porcentagem) {
        if (porcentagem >= 0 && porcentagem <= 100) {
            this.porcentagem = porcentagem;
        }
    }

    @Override
    public void recarregar(int percentual) {
      
    }
}