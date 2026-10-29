/**
 * Contrato para objetos que podem ser LIGADOS e DESLIGADOS.
 *
 * <p>
 * Quem implementa esta interface deve garantir que:
 * <ul>
 * <li>{@link #ligar()} coloque o objeto em funcionamento e retorne uma mensagem
 * descrevendo o que aconteceu;</li>
 * <li>{@link #desligar()} interrompa o funcionamento e retorne uma mensagem
 * descrevendo o que aconteceu;</li>
 * <li>as mensagens retornadas nunca sejam {@code null} nem vazias;</li>
 * <li>nenhum dos dois metodos lance excecao se for chamado mais de uma vez
 * seguida.</li>
 * </ul>
 *
 * <p>
 * Exemplos de implementacoes neste projeto: {@link Carro} (e suas filhas
 * {@link Fiat} e {@link Toyota}), {@link Farol} e {@link Radio}.
 */
public interface Ligavel {

    /**
     * Liga o objeto.
     *
     * @return mensagem descrevendo que o objeto foi ligado (ex: "Farol aceso")
     */
    String ligar();

    /**
     * Desliga o objeto.
     *
     * @return mensagem descrevendo que o objeto foi desligado (ex: "Farol apagado")
     */
    String desligar();
}