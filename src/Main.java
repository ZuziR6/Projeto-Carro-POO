public class Main {

    public static void main(String[] args) {

        // Cria o objeto Carro e define o modelo direto no atributo (publico)
        Carro carro = new Carro();
        carro.modelo = "Gol";
        System.out.println("Modelo: " + carro.modelo);

        // Testa a regra de velocidade (maximo 200)
        carro.acelerar(50);
        System.out.println("Velocidade: " + carro.velocidade + " km/h");

        // Testa a regra do tanque (maximo 50 litros)
        carro.abastecer(30);
        System.out.println("Combustivel: " + carro.combustivel + " L");

        // PROBLEMA: como o atributo e publico, da para burlar a regra de negocio
        carro.velocidade = 500;
        System.out.println("Velocidade apos alteracao direta: " + carro.velocidade + " km/h");
    }
}