// "implements": Radio tambem cumpre o contrato da interface Ligavel.
// Radio e outra hierarquia DIFERENTE (nao tem relacao com Carro nem com Farol).
public class Radio implements Ligavel {

    // Implementacao obrigatoria de ligar() (declarado na interface)
    @Override
    public String ligar() {
        return "Radio tocando";
    }

    // Implementacao obrigatoria de desligar() (declarado na interface)
    @Override
    public String desligar() {
        return "Radio desligado";
    }
}