# Projeto Carro - POO
Atividade realizada em classe no dia **20/08/26** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu conteúdo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **carro**, representando o veículo utilizado no mundo real.

Ao longo das aulas, o projeto evoluiu com a aplicação de encapsulamento, construtores, associação entre objetos e herança (generalização). Atualmente, a classe `Carro` é a superclasse do projeto, utilizada por diferentes tipos de carro, como `Fiat` e `Toyota`.

## Classes
Atualmente, o projeto possui as seguintes classes:

* `Carro`: superclasse que representa as características e comportamentos comuns aos carros.
* `Fiat`: classe filha de `Carro`, representando um carro da Fiat.
* `Toyota`: classe filha de `Carro`, representando um carro da Toyota.
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

A classe `Fiat` possui o seguinte atributo:

* `arCondicionado`: representa se o ar-condicionado está disponível.

  * Inicia como `true`.

A classe `Toyota` possui o seguinte atributo:

* `modoHibrido`: representa se o modo híbrido está disponível.

  * Inicia como `true`.

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

Na aula de **24/09/26**, foram criadas as classes `Fiat` e `Toyota`, que herdam de `Carro` e usam `super()` para chamar o construtor da classe mãe:

```java
public Fiat() {
    super("Fiat Argo", new Tanque(0));
    this.arCondicionado = true;
}
```

```java
public Toyota() {
    super("Toyota Corolla", new Tanque(0));
    this.modoHibrido = true;
}
```

Dessa forma, as classes filhas aproveitam a estrutura já existente em `Carro`, enquanto adicionam suas próprias características.

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

### isArCondicionado() e setArCondicionado()
Pertencem à classe `Fiat`: retornam e alteram o valor de `arCondicionado`.

```java
public boolean isArCondicionado() {
    return arCondicionado;
}

public void setArCondicionado(boolean arCondicionado) {
    this.arCondicionado = arCondicionado;
}
```

### isModoHibrido() e setModoHibrido()
Pertencem à classe `Toyota`: retornam e alteram o valor de `modoHibrido`.

```java
public boolean isModoHibrido() {
    return modoHibrido;
}

public void setModoHibrido(boolean modoHibrido) {
    this.modoHibrido = modoHibrido;
}
```

## Associação entre objetos
Na aula de **17/09/26**, foi criada a classe `Tanque` para realizar uma associação com a classe `Carro`. O atributo que antes era um simples número (`combustivel`) passou a ser um objeto da classe `Tanque`:

```java
private Tanque tanque;
```

Essa associação permite que o `Carro` utilize os comportamentos do `Tanque`, enquanto o `Tanque` fica responsável por controlar seus litros e suas regras de negócio. O atributo `combustivel` e o método `getCombustivel()` deixaram de existir em `Carro`, pois essa informação agora pertence ao `Tanque`.

## Herança (Generalização)
Na aula de **24/09/26**, foi aplicado o conceito de herança, também chamado de generalização. A classe `Carro` passou a atuar como superclasse, contendo características e comportamentos comuns aos diferentes tipos de carro.

A classe `Fiat` herda de `Carro`:

```java
public class Fiat extends Carro {
```

E a classe `Toyota` também herda de `Carro`:

```java
public class Toyota extends Carro {
```

Por meio da herança, `Fiat` e `Toyota` recebem os métodos acessíveis de `Carro`, podendo utilizar comportamentos como:

* `getModelo()`
* `setModelo()`
* `acelerar()`
* `getVelocidade()`
* `abastecer()`
* `getTanque()`

Além disso, cada classe filha possui suas próprias características (`arCondicionado` na `Fiat` e `modoHibrido` na `Toyota`). Assim, a herança permite reutilizar o que é comum aos carros, enquanto cada filha tem o que é específico dela.

## Uso do super()
Nas classes `Fiat` e `Toyota`, o `super()` é utilizado para chamar o construtor da classe mãe (`Carro`):

```java
super("Fiat Argo", new Tanque(0));
```

O `super()` permite que a classe filha utilize o construtor da classe mãe para inicializar as características que pertencem à estrutura de `Carro`, evitando duplicar na filha a lógica de inicialização de `modelo` e `tanque`.

## Encapsulamento e herança
Os atributos das classes são privados (`private`) para proteger o estado dos objetos. Na herança, a classe filha possui acesso aos comportamentos disponibilizados pela classe mãe, mas não acessa diretamente os atributos privados dela.

Por exemplo, `Fiat` e `Toyota` não alteram diretamente `modelo` ou `tanque`. Para trabalhar com essas informações, utilizam os métodos da classe mãe, como `getModelo()`, `setModelo()`, `acelerar()` e `abastecer()`. Assim, o encapsulamento continua sendo aplicado mesmo com a utilização da herança.

## Testes
Na aula de **24/09/26**, o `Main.java` foi atualizado para testar os objetos das classes filhas `Fiat` e `Toyota`.

Primeiramente, foi criado um objeto `Fiat`:

```java
Fiat fiat = new Fiat();
```

Depois, foram testados seu modelo, o ar-condicionado, a velocidade e o tanque. Em seguida, foi criado um objeto `Toyota`:

```java
Toyota toyota = new Toyota();
```

Também foram testados seu modelo, o modo híbrido, a velocidade e o tanque. Por fim, foi testada a regra de negócio tentando abastecer a `Fiat` além do limite.

A saída obtida foi:

```text
FIAT
Modelo: Fiat Argo
Ar-condicionado: true
Velocidade: 60 km/h
Tanque: 40 L

TOYOTA
Modelo: Toyota Corolla
Modo hibrido: true
Velocidade: 80 km/h
Tanque: 30 L

Tanque da Fiat apos tentar passar do limite: 40 L
```

Os testes demonstram que `Fiat` e `Toyota` conseguem utilizar os comportamentos herdados de `Carro`, além de apresentarem suas próprias características.

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

## Projeto Carro - Pergunta de reflexão "A Árvore Genealógica - Herança (Generalização)" - Aula 24/09/26

**No nosso código, a mãe `Carro` possui o atributo `modelo` como `private`. Quando `Fiat` herda de `Carro`, ela recebe esse atributo, mas o código dentro de `Fiat` NÃO consegue fazer `this.modelo = "ABC"`. Ela é obrigada a usar o `super()` ou o `setModelo()`. Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?**

O Java não permite que a classe filha altere diretamente os atributos `private` da classe mãe porque esses atributos estão encapsulados e só podem ser acessados diretamente dentro da própria classe onde foram declarados. Isso protege os dados de alterações indevidas e permite que a classe mãe controle como seus atributos serão modificados. Por isso, a filha precisa utilizar o construtor com `super()` ou métodos como `setModelo()`, preservando o **encapsulamento** (princípio das aulas anteriores).

Neste projeto, isso se aplica aos atributos `modelo` e `tanque` de `Carro`. As classes `Fiat` e `Toyota`, mesmo herdando de `Carro`, não os alteram diretamente: usam `super()` e métodos como `setModelo()`. Assim, os dados continuam protegidos e organizados dentro da estrutura de herança.

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

### 24/09/26
* Aplicação do conceito de herança (generalização).
* Utilização da classe `Carro` como superclasse.
* Criação das classes `Fiat` e `Toyota` como classes filhas de `Carro`.
* Utilização de `extends` para estabelecer a herança entre as classes.
* Utilização de `super()` para chamar o construtor da classe `Carro`.
* Definição dos modelos `Fiat Argo` e `Toyota Corolla`.
* Criação do atributo `arCondicionado` na classe `Fiat` e `modoHibrido` na classe `Toyota`.
* Criação dos métodos `isArCondicionado()`, `setArCondicionado()`, `isModoHibrido()` e `setModoHibrido()`.
* Atualização do `Main.java` para testar objetos `Fiat` e `Toyota`.
* Teste dos comportamentos herdados de `Carro` e das características específicas de cada classe filha.
* Adição da reflexão sobre herança, generalização e proteção dos atributos privados por meio do encapsulamento.