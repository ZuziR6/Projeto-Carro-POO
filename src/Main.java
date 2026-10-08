public class Main {

    public static void main(String[] args) {

        // ---------- Teste da classe filha Fiat ----------
        Fiat fiat = new Fiat();

        System.out.println("FIAT");
        System.out.println("Modelo: " + fiat.getModelo()); // herdado de Carro
        System.out.println("Ar-condicionado: " + fiat.isArCondicionado()); // proprio da Fiat

        fiat.acelerar(60); // herdado de Carro
        System.out.println("Velocidade: " + fiat.getVelocidade() + " km/h");

        fiat.abastecer(40); // herdado de Carro
        System.out.println("Tanque: " + fiat.getTanque() + " L");

        // ---------- Teste da classe filha Toyota ----------
        Toyota toyota = new Toyota();

        System.out.println("\nTOYOTA");
        System.out.println("Modelo: " + toyota.getModelo()); // herdado de Carro
        System.out.println("Modo hibrido: " + toyota.isModoHibrido()); // proprio da Toyota

        toyota.acelerar(80);
        System.out.println("Velocidade: " + toyota.getVelocidade() + " km/h");

        toyota.abastecer(30);
        System.out.println("Tanque: " + toyota.getTanque() + " L");

        // ---------- Teste de regra de negocio nas filhas ----------
        fiat.abastecer(20); // 40 + 20 passaria de 50: deve ser ignorado
        System.out.println("\nTanque da Fiat apos tentar passar do limite: " + fiat.getTanque() + " L");

        // ---------- Polimorfismo de sobrescrita ----------
        // Um array de Carro pode guardar Carro, Fiat e Toyota (as filhas TAMBEM sao
        // Carro)
        Carro[] carros = { new Carro("Gol", new Tanque(0)), fiat, toyota };

        System.out.println("\nPOLIMORFISMO");
        for (Carro c : carros) {
            // Mesma chamada (c.buzinar()), resultado diferente conforme o objeto real
            System.out.println(c.getModelo() + " -> " + c.buzinar());
        }
    }
}