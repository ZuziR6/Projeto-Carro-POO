// extends: Fiat HERDA tudo que e acessivel em Carro (acelerar, abastecer, getters...)
public class Fiat extends Carro {

    // Caracteristica propria da Fiat (nao existe em Carro)
    private boolean arCondicionado;

    public Fiat() {
        // super(): chama o construtor de Carro para definir modelo e tanque
        super("Fiat Argo", new Tanque(0));
        this.arCondicionado = true;
    }

    // Retorna se o ar-condicionado esta disponivel
    public boolean isArCondicionado() {
        return arCondicionado;
    }

    // Liga ou desliga o ar-condicionado
    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    // @Override: indica que estamos SOBRESCREVENDO o metodo buzinar() herdado de
    // Carro.
    // Mesma assinatura, mas com o comportamento proprio da Fiat.
    @Override
    public String buzinar() {
        return "Fiat: Pi-pi!";
    }
}