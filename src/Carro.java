public class Carro {

    // Atributos (nesta aula ainda PUBLICOS: qualquer classe consegue alterar
    // direto)
    public String modelo; // modelo do carro (ex: Gol)
    public int combustivel; // litros de combustivel no tanque
    public int velocidade; // velocidade atual em km/h (comeca em 0)

    // Aumenta a velocidade do carro.
    // Regra de negocio: a quantidade deve ser maior que zero
    // e a velocidade nao pode ultrapassar 200 km/h.
    public void acelerar(int quantidade) {
        if (quantidade > 0 && velocidade + quantidade <= 200) {
            velocidade = velocidade + quantidade;
        }
    }

    // Coloca combustivel no tanque.
    // Regra de negocio: a quantidade deve ser maior que zero
    // e o tanque nao pode passar de 50 litros.
    public void abastecer(int quantidade) {
        if (quantidade > 0 && combustivel + quantidade <= 50) {
            combustivel = combustivel + quantidade;
        }
    }
}