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

Os atributos agora são privados (`private`) para proteger o estado do objeto (encapsulamento).

## Construtores
Na aula de **10/09/26**, foi criado um construtor para a classe `Carro`, definindo o atributo essencial para o nascimento do objeto: o modelo. Agora não é possível criar um `Carro` sem informar o modelo (parâmetro obrigatório).

```java
public Carro(String modelo) {
    setModelo(modelo);
}
```

O construtor utiliza o método `setModelo()` para atribuir o valor, mantendo o acesso ao atributo em um único lugar.

O `Main.java` passou a criar o objeto assim:

```java
Carro carro = new Carro("Gol");
```

## Métodos

### getModelo()
O método `getModelo()` retorna o modelo do carro.

```java
public String getModelo() {
    return modelo;
}
```

### setModelo()
O método `setModelo(String modelo)` permite alterar o modelo do carro.

```java
public void setModelo(String modelo) {
    this.modelo = modelo;
}
```

### acelerar()
Aumenta a velocidade do carro. A quantidade deve ser maior que zero e a velocidade não pode ultrapassar 200 km/h.

```java
public void acelerar(int quantidade) {
    if (quantidade > 0 && velocidade + quantidade <= 200) {
        velocidade = velocidade + quantidade;
    }
}
```

### abastecer()
Coloca combustível no tanque. A quantidade deve ser maior que zero e o tanque não pode passar de 50 litros.

```java
public void abastecer(int quantidade) {
    if (quantidade > 0 && combustivel + quantidade <= 50) {
        combustivel = combustivel + quantidade;
    }
}
```

### getVelocidade() e getCombustivel()
Retornam a velocidade atual e os litros de combustível. Não foram criados `setVelocidade()` nem `setCombustivel()` de propósito: esses valores só mudam pelos métodos `acelerar()` e `abastecer()`, que validam as regras.

```java
public int getVelocidade() {
    return velocidade;
}

public int getCombustivel() {
    return combustivel;
}
```

## Encapsulamento
Na aula de **10/09/26**, os atributos de `Carro` passaram de `public` para `private`. Agora o `Main` não consegue mais fazer `carro.velocidade = 500`, e o acesso é feito por métodos que protegem as regras de negócio.

## Testes
O `Main.java` foi atualizado para criar o objeto com o novo construtor e continua testando valores inválidos, que são ignorados pelas regras dos métodos.

Saída obtida:

```text
Modelo: Gol
Velocidade: 50 km/h
Combustivel: 30 L
Velocidade apos teste invalido: 50 km/h
Combustivel apos teste invalido: 30 L
```

## Projeto Carro - Pergunta de Reflexão "Clean Code" - Aula 10/09/26

**Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas decisões protegem o sistema de fraudes e falhas de lógica?**

Gerar getters e setters para tudo pode causar um sério problema de informações não reais. Nem toda informação do objeto deve ser alterada livremente. Se existisse um `setCombustivel()` público, mesmo com o atributo privado, qualquer pessoa poderia colocar 500 litros num tanque de 50, invalidando a lógica do sistema.

Por isso, ao criar um atributo privado não devemos criar automaticamente um setter público. Quando for necessário alterar um atributo, criamos métodos com condições que representem ações reais do objeto e possam ser validadas. Por exemplo:

```java
public void abastecer(int quantidade) {
    if (quantidade > 0 && combustivel + quantidade <= 50) {
        combustivel = combustivel + quantidade;
    }
}
```

O usuário não define qualquer valor para o tanque: ele informa quanto quer adicionar, e o sistema verifica se a quantidade é maior que zero e se o tanque não passará de 50 litros. O mesmo vale para a velocidade, que só muda por `acelerar()`.

## Evolução do projeto

### 20/08/26
* Criação da classe `Carro`.
* Definição dos atributos `modelo`, `combustivel` e `velocidade`.
* Criação dos métodos `acelerar()` e `abastecer()` com regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.
* Identificação do problema dos atributos públicos.

### 10/09/26
* Aplicação do encapsulamento: atributos passaram a ser privados (`private`).
* Criação dos métodos `getModelo()` e `setModelo()`.
* Criação de `getVelocidade()` e `getCombustivel()`, sem setters para esses atributos.
* Alteração do `Main.java` para usar os métodos de acesso e testar valores inválidos.
* Aplicação dos conceitos de encapsulamento e Clean Code.
* Adição da reflexão sobre getters, setters e proteção contra falhas de lógica.
* Criação do construtor da classe `Carro`, exigindo o modelo como parâmetro obrigatório.
* Utilização do método `setModelo()` no construtor.
* Alteração do `Main.java` para utilizar o novo construtor.