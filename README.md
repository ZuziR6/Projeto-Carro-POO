# Projeto Carro - POO
Atividade realizada em classe no dia **20/08/26** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu conteúdo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **carro**, representando o veículo utilizado no mundo real.

## Classes
* `Carro`: classe principal, representa o carro.
* `Tanque`: classe responsável por representar o tanque e controlar seus litros.
* `Main`: classe responsável por criar os objetos e realizar os testes do projeto.

## Atributos
A classe `Carro` possui os seguintes atributos:

* `modelo`: representa o modelo do carro.
* `tanque`: representa o objeto `Tanque` associado ao carro.
* `velocidade`: representa a velocidade atual em km/h.

  * Inicia em 0.

A classe `Tanque` possui o seguinte atributo:

* `litros`: representa os litros de combustível no tanque.

Os atributos são privados (`private`) para proteger o estado do objeto.

## Construtores
Na aula de **10/09/26**, foi criado um construtor para `Carro`, definindo o atributo essencial para o nascimento do objeto. Posteriormente, na aula de **17/09/26**, com a associação entre `Carro` e `Tanque`, o construtor passou a receber também um objeto `Tanque`:

```java
public Carro(String modelo, Tanque tanque) {
    this.modelo = modelo;
    this.tanque = tanque;
}
```

A classe `Tanque` também possui construtor, e o `Main.java` cria o carro assim:

```java
Carro carro = new Carro("Gol", new Tanque(0));
```

## Métodos

### getModelo() e setModelo()
Retornam e alteram o modelo do carro.

### acelerar()
Aumenta a velocidade do carro. A quantidade deve ser maior que zero e a velocidade não pode ultrapassar 200 km/h.

```java
public void acelerar(int quantidade) {
    if (quantidade > 0 && velocidade + quantidade <= 200) {
        velocidade = velocidade + quantidade;
    }
}
```

### abastecer() (em Carro)
O método `abastecer(int quantidade)` solicita que o objeto `Tanque` associado realize o abastecimento.

```java
public void abastecer(int quantidade) {
    tanque.abastecer(quantidade);
}
```

A regra de negócio do abastecimento permanece sob responsabilidade da classe `Tanque`.

### getTanque()
O método `getTanque()` retorna os litros do tanque por meio do objeto `Tanque` associado.

```java
public int getTanque() {
    return tanque.getLitros();
}
```

### getVelocidade()
Retorna a velocidade atual.

### getLitros()
Pertence à classe `Tanque` e retorna os litros atuais.

```java
public int getLitros() {
    return litros;
}
```

### abastecer() (em Tanque)
Pertence à classe `Tanque` e aumenta os litros.

Regra de negócio:

* A quantidade deve ser maior que zero.
* O tanque não pode passar de 50 litros.

```java
public void abastecer(int quantidade) {
    if (quantidade > 0 && litros + quantidade <= 50) {
        litros = litros + quantidade;
    }
}
```

## Associação entre objetos
Na aula de **17/09/26**, foi criada a classe `Tanque` para realizar uma associação com a classe `Carro`. O atributo que antes era um simples número (`combustivel`) passou a ser um objeto da classe `Tanque`:

```java
private Tanque tanque;
```

Essa associação permite que o `Carro` utilize os comportamentos do `Tanque`, enquanto o `Tanque` fica responsável por controlar seus litros e suas regras de negócio. O atributo `combustivel` e o método `getCombustivel()` deixaram de existir em `Carro`, pois essa informação agora pertence ao `Tanque`.

## Testes
O `Main.java` foi atualizado para criar o `Carro` com um objeto `Tanque` associado e testar abastecimento válido e inválido.

Saída obtida:

```text
Modelo: Gol
Velocidade: 50 km/h
Tanque: 30 L
Velocidade apos teste invalido: 50 km/h
Tanque apos teste invalido: 30 L
```

## Projeto Carro - Pergunta de Reflexão "Clean Code" - Aula 10/09/26

**Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente na sua IDE? Como as nossas decisões protegem o sistema de fraudes e falhas de lógica?**

Gerar getters e setters para tudo pode causar um sério problema de informações não reais. Nem toda informação do objeto deve ser alterada livremente. Se existisse um `setLitros()` público no `Tanque`, qualquer pessoa poderia colocar 500 litros num tanque de 50, invalidando a lógica do sistema, mesmo com o atributo privado.

Por isso, em vez de um setter, usamos métodos que representem ações reais do objeto e validem a regra, como o `abastecer()`:

```java
public void abastecer(int quantidade) {
    if (quantidade > 0 && litros + quantidade <= 50) {
        litros = litros + quantidade;
    }
}
```

O usuário não define qualquer valor: ele informa quanto quer adicionar, e o sistema verifica se a quantidade é maior que zero e se o tanque não passará de 50 litros.

## Projeto Carro - Pergunta de reflexão "Associação entre objetos" - Aula 17/09/26

**Se o `Carro` só precisa mostrar dados do tanque, não seria mais simples e mais leve guardar apenas um `int` com os litros em vez do objeto `Tanque`?**

Não. Um `int` guarda apenas o dado, e um objeto guarda o dado mais o comportamento e as regras. Se o `Carro` tivesse só um número, ele precisaria conhecer e repetir a regra do limite de 50 litros para poder abastecer. Com o objeto `Tanque`, o `Carro` apenas pede `tanque.abastecer(quantidade)` e cada classe mantém suas próprias responsabilidades, deixando o código mais organizado.

## Evolução do projeto

### 20/08/26
* Criação da classe `Carro`.
* Definição dos atributos `modelo`, `combustivel` e `velocidade`.
* Criação dos métodos `acelerar()` e `abastecer()` com regras para impedir valores inválidos.
* Criação do `Main.java` para testar o funcionamento do objeto.
* Identificação do problema dos atributos públicos.

### 10/09/26
* Aplicação do encapsulamento: atributos passaram a ser privados (`private`).
* Criação dos métodos `getModelo()`, `setModelo()`, `getVelocidade()` e `getCombustivel()`.
* Alteração do `Main.java` para usar os métodos de acesso e testar valores inválidos.
* Adição da reflexão sobre getters, setters e proteção contra falhas de lógica.
* Criação do construtor da classe `Carro`, exigindo o modelo como parâmetro obrigatório.
* Utilização do método `setModelo()` no construtor.
* Alteração do `Main.java` para utilizar o novo construtor.

### 17/09/26
* Criação da nova classe `Tanque`.
* Criação do atributo `litros`, do construtor, de `getLitros()` e de `abastecer()` na classe `Tanque`.
* Associação entre as classes `Carro` e `Tanque`.
* Substituição do atributo `combustivel` do `Carro` pelo objeto `Tanque`.
* Atualização do construtor de `Carro` para receber um objeto `Tanque`.
* Atualização do método `abastecer()` para utilizar o objeto `Tanque` associado.
* Criação de `getTanque()` e remoção de `getCombustivel()`.
* Adição da reflexão sobre associação entre objetos e responsabilidades das classes.