# Projeto Carro - POO
Atividade realizada em classe no dia **20/08/26** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu conteúdo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **carro**, representando o veículo utilizado no mundo real.

## Classes
* `Carro`: classe principal, representa o carro.
* `Main`: classe responsável por criar o objeto e realizar os testes do projeto.

## Atributos
A classe `Carro` possui os seguintes atributos:

* `modelo`: representa o modelo do carro.
* `combustivel`: representa os litros de combustível no tanque.
* `velocidade`: representa a velocidade atual em km/h.

  * Inicia em 0.

Nesta aula os atributos ainda são públicos (`public`), o que gera um problema que será corrigido nas aulas seguintes (veja a seção Testes).

## Métodos

### acelerar()
O método `acelerar(int quantidade)` aumenta a velocidade do carro de acordo com a quantidade informada.

Regra de negócio:

* A quantidade deve ser maior que zero.
* A velocidade não pode ultrapassar 200 km/h.

```java
public void acelerar(int quantidade) {
    if (quantidade > 0 && velocidade + quantidade <= 200) {
        velocidade = velocidade + quantidade;
    }
}
```

### abastecer()
O método `abastecer(int quantidade)` coloca combustível no tanque.

Regra de negócio:

* A quantidade deve ser maior que zero.
* O tanque não pode passar de 50 litros.

```java
public void abastecer(int quantidade) {
    if (quantidade > 0 && combustivel + quantidade <= 50) {
        combustivel = combustivel + quantidade;
    }
}
```

## Testes
Foi criado o `Main.java`, que cria um objeto `Carro`, testa `acelerar()` e `abastecer()` e, ao final, altera a velocidade diretamente para mostrar o problema dos atributos públicos.

Saída obtida:

```text
Modelo: Gol
Velocidade: 50 km/h
Combustivel: 30 L
Velocidade apos alteracao direta: 500 km/h
```

Repare que a velocidade chegou a **500 km/h**, ultrapassando o limite de 200 definido na regra de negócio. Como o atributo é público, qualquer código consegue ignorar as regras do método `acelerar()`.

## Evolução do projeto

### 20/08/26
* Criação da classe `Carro`.
* Definição dos atributos `modelo`, `combustivel` e `velocidade`.
* Criação do método `acelerar()`.
* Criação do método `abastecer()`.
* Implementação das regras para impedir valores inválidos nos métodos.
* Criação do `Main.java` para testar o funcionamento do objeto.
* Identificação do problema dos atributos públicos.