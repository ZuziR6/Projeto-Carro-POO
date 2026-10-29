
public class Main {

    public static void main(String[] args) {

        // 1. Lista polimórfica de carros
        Carro[] carros = {
                new Tesla(),
                new Toyota()
        };

        System.out.println("=== LISTA POLIMORFICA DE CARROS ===");

        for (Carro carro : carros) {
            System.out.println(
                    carro.getModelo()
                            + " | "
                            + carro.exibirTipo()
                            + " | "
                            + carro.buzinar());
        }

        // 2. Lista polimórfica da interface Ligavel
        Ligavel[] ligaveis = {
                new Tesla(),
                new Toyota(),
                new Farol(),
                new Radio()
        };

        System.out.println("\n=== INTERFACE LIGAVEL ===");

        for (Ligavel item : ligaveis) {
            System.out.println(item.ligar());
            System.out.println(item.desligar());
        }

        // 3. Lista polimórfica da interface Recarregavel
        Recarregavel[] recarregaveis = {
                new Tesla(),
                new Apple("iPhone 17 Pro Max", new Bateria(0), true),
                new Motorola("Moto G", new Bateria(0), true)
        };

        System.out.println("\n=== INTERFACE RECARREGAVEL ===");

        for (Recarregavel item : recarregaveis) {
            item.recarregar(85);
            System.out.println(
                    "Objeto recarregavel: "
                            + item.getClass().getSimpleName());
        }
    }
}
