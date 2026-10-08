public class Main {

    public static void main(String[] args) {

        // Cria o Carro informando o modelo e um objeto Tanque (comeca vazio)
        Carro carro = new Carro("Gol", new Tanque(0));
        System.out.println("Modelo: " + carro.getModelo());

        // Testa a regra de velocidade (maximo 200)
        carro.acelerar(50);
        System.out.println("Velocidade: " + carro.getVelocidade() + " km/h");

        // O Carro pede ao Tanque para abastecer (regra de 50 L fica no Tanque)
        carro.abastecer(30);
        System.out.println("Tanque: " + carro.getTanque() + " L");

        // Testa valores invalidos: nada deve mudar
        carro.acelerar(500); // passaria de 200
        carro.abastecer(-10); // quantidade negativa
        carro.abastecer(40); // 30 + 40 passaria de 50
        System.out.println("Velocidade apos teste invalido: " + carro.getVelocidade() + " km/h");
        System.out.println("Tanque apos teste invalido: " + carro.getTanque() + " L");
    }
}