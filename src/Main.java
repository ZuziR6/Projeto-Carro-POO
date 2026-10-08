public class Main {

    public static void main(String[] args) {

        // Cria o objeto Carro; agora o modelo so muda pelo setter
        Carro carro = new Carro();
        carro.setModelo("Gol");
        System.out.println("Modelo: " + carro.getModelo());

        // Testa a regra de velocidade (maximo 200)
        carro.acelerar(50);
        System.out.println("Velocidade: " + carro.getVelocidade() + " km/h");

        // Testa a regra do tanque (maximo 50 litros)
        carro.abastecer(30);
        System.out.println("Combustivel: " + carro.getCombustivel() + " L");

        // Testa valores invalidos: as regras protegem o objeto e nada muda
        carro.acelerar(500); // passaria de 200
        carro.abastecer(-10); // quantidade negativa
        System.out.println("Velocidade apos teste invalido: " + carro.getVelocidade() + " km/h");
        System.out.println("Combustivel apos teste invalido: " + carro.getCombustivel() + " L");

        // carro.velocidade = 500; <- agora da ERRO de compilacao (atributo private)
    }
}