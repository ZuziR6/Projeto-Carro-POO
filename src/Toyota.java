// extends: Toyota HERDA tudo que e acessivel em Carro (acelerar, abastecer, getters...)
public class Toyota extends Carro {

    // Caracteristica propria da Toyota (nao existe em Carro)
    private boolean modoHibrido;

    public Toyota() {
        // super(): chama o construtor de Carro para definir modelo e tanque
        super("Toyota Corolla", new Tanque(0));
        this.modoHibrido = true;
    }

    // Retorna se o modo hibrido esta disponivel
    public boolean isModoHibrido() {
        return modoHibrido;
    }

    // Ativa ou desativa o modo hibrido
    public void setModoHibrido(boolean modoHibrido) {
        this.modoHibrido = modoHibrido;
    }

    // @Override: indica que estamos SOBRESCREVENDO o metodo buzinar() herdado de
    // Carro.
    // Mesma assinatura, mas com o comportamento proprio da Toyota.
    @Override
    public String buzinar() {
        return "Toyota: Pim-pim!";
    }
}