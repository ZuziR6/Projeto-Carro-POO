// "implements": Farol se compromete a cumprir o contrato da interface Ligavel.
// Farol NAO herda de Carro: e uma hierarquia DIFERENTE, mas tambem pode ser ligado.
public class Farol implements Ligavel {

    // Implementacao obrigatoria de ligar() (declarado na interface)
    @Override
    public String ligar() {
        return "Farol aceso";
    }

    // Implementacao obrigatoria de desligar() (declarado na interface)
    @Override
    public String desligar() {
        return "Farol apagado";
    }
}