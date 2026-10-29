# Projeto Carro - POO
Atividade realizada em classe no dia **20/08/26** na aula de Programação Orientada a Objetos, a qual será dada continuidade a cada aula até o fim do semestre. Portanto, esse Readme.md irá ser atualizado conforme a evolução do projeto, podendo haver alterações no seu conteúdo, bem como remoção de antigas informações que não fazem mais sentido e adição de novas.

## Sobre o projeto
Este projeto foi desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO), no qual o objeto escolhido foi um **carro**, representando o veículo utilizado no mundo real.

Ao longo das aulas, o projeto evoluiu com a aplicação de encapsulamento, construtores, associação entre objetos, herança (generalização), polimorfismo de sobrescrita, classe abstrata e interface. Atualmente, a classe `Carro` é a superclasse do projeto, utilizada por diferentes tipos de carro, como `Fiat` e `Toyota`.

## Classes
Atualmente, o projeto possui as seguintes classes:

* `Ligavel`: interface que define o comportamento de poder ser ligado e desligado (`ligar()` e `desligar()`).
* `Carro`: superclasse **abstrata** que representa as características e comportamentos comuns aos carros. Não pode ser instanciada diretamente. Implementa `Ligavel`.
* `Fiat`: classe filha de `Carro`, representando um carro da Fiat. Sobrescreve `buzinar()` e implementa `exibirTipo()`.
* `Toyota`: classe filha de `Carro`, representando um carro da Toyota. Sobrescreve `buzinar()` e implementa `exibirTipo()`.
* `Tanque`: classe responsável por representar o tanque e controlar seus litros.
* `Farol`: classe que representa o farol do carro. Implementa `Ligavel` e não tem relação de herança com `Carro`.
* `Radio`: classe que representa o rádio do carro. Implementa `Ligavel` e não tem relação de herança com `Carro`.
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

A classe `Tanque` também possui construtor. Até a aula de **01/10/26**, o `Main.java` criava o carro diretamente com `new Carro("Gol", new Tanque(0))`. Na aula de **15/10/26**, `Carro` se tornou abstrata e não pode mais ser instanciada diretamente: o construtor continua existindo, mas só é chamado pelas classes filhas por meio do `super()`.

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

### buzinar()
Pertence à classe `Carro` e retorna o som padrão da buzina de um carro. Esse método é sobrescrito pelas classes filhas (veja a seção Polimorfismo de sobrescrita).

```java
public String buzinar() {
    return "Beep beep!";
}
```

### exibirTipo()
Declarado como **método abstrato** na classe `Carro` (sem corpo) e implementado por `Fiat` e `Toyota`. Retorna o tipo do carro (veja a seção Classe abstrata).

```java
public abstract String exibirTipo();
```

### ligar() e desligar()
Declarados na interface `Ligavel` (sem corpo) e implementados por `Carro` (herdados por `Fiat` e `Toyota`), `Farol` e `Radio`, cada um do seu jeito (veja a seção Interface).

```java
String ligar();
String desligar();
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

## Polimorfismo de sobrescrita
Na aula de **01/10/26**, foi aplicado o polimorfismo de sobrescrita (override). A classe `Carro` possui o método `buzinar()` com um comportamento padrão, e as classes filhas `Fiat` e `Toyota` sobrescrevem esse método, mantendo a mesma assinatura, mas com um comportamento próprio. A anotação `@Override` indica que o método está sendo sobrescrito:

```java
// Na classe Carro
public String buzinar() {
    return "Beep beep!";
}
```

```java
// Na classe Fiat
@Override
public String buzinar() {
    return "Fiat: Pi-pi!";
}
```

```java
// Na classe Toyota
@Override
public String buzinar() {
    return "Toyota: Pim-pim!";
}
```

O polimorfismo aparece quando uma variável do tipo `Carro` guarda objetos de classes diferentes (`Fiat` e `Toyota`, pois as filhas também são `Carro`). A chamada é sempre a mesma (`c.buzinar()`), mas o resultado muda conforme o objeto real:

```java
Carro[] carros = { fiat, toyota };

for (Carro c : carros) {
    System.out.println(c.getModelo() + " -> " + c.buzinar());
}
```

Dessa forma, o código que usa `Carro` não precisa saber qual é o tipo exato de cada carro: o Java escolhe automaticamente a versão correta do método em tempo de execução.

## Classe abstrata
Na aula de **15/10/26**, a classe `Carro` foi transformada em uma **classe abstrata** com a palavra-chave `abstract`. Uma classe abstrata serve de modelo para as classes filhas e **não pode ser instanciada**: `new Carro(...)` passou a gerar erro de compilação. Na prática isso faz sentido, pois no mundo real não existe "um carro genérico", e sim um Fiat, um Toyota e assim por diante.

```java
public abstract class Carro {
```

Também foi criado o método abstrato `exibirTipo()`, que só tem a assinatura e **não tem corpo**. Assim, cada classe filha é **obrigada** a implementar o seu próprio `exibirTipo()`; se esquecer, o código não compila:

```java
// Na classe Carro
public abstract String exibirTipo();
```

```java
// Na classe Fiat
@Override
public String exibirTipo() {
    return "Hatch compacto";
}
```

```java
// Na classe Toyota
@Override
public String exibirTipo() {
    return "Sedan medio";
}
```

Com isso, `Carro` define **o que** todo carro deve ter (um tipo), e cada filha define **como** isso é feito. A classe abstrata continua podendo ser usada como tipo, então o polimorfismo segue funcionando: um array de `Carro` guarda `Fiat` e `Toyota`, e cada chamada de `exibirTipo()` executa a versão da classe real do objeto. O `Main.java` precisou ser alterado para não criar mais um `Carro` diretamente.

## Interface
Na aula de **22/10/26**, foi aplicado o conceito de interface. Uma interface define um **comportamento** (um "contrato") que classes diferentes podem ter, sem dizer como ele é feito: os métodos da interface não têm corpo, e cada classe que a implementa com `implements` é **obrigada** a escrever o seu. Foi criada a interface `Ligavel`, com os métodos `ligar()` e `desligar()`:

```java
public interface Ligavel {
    String ligar();
    String desligar();
}
```

(A interface completa, com a documentação JavaDoc, aparece na seção do checklist de Clean Code mais abaixo.)

A classe `Carro` implementa `Ligavel`, e como `Carro` é abstrata, `Fiat` e `Toyota` herdam `ligar()` e `desligar()` prontos:

```java
public abstract class Carro implements Ligavel {

    @Override
    public String ligar() {
        return modelo + ": motor ligado";
    }

    @Override
    public String desligar() {
        return modelo + ": motor desligado";
    }
}
```

Também foram criadas duas classes que **não têm relação de herança com `Carro`**, mas também implementam `Ligavel`:

```java
public class Farol implements Ligavel {

    @Override
    public String ligar() {
        return "Farol aceso";
    }

    @Override
    public String desligar() {
        return "Farol apagado";
    }
}
```

```java
public class Radio implements Ligavel {

    @Override
    public String ligar() {
        return "Radio tocando";
    }

    @Override
    public String desligar() {
        return "Radio desligado";
    }
}
```

A interface permite que objetos de hierarquias totalmente diferentes (`Fiat`, `Toyota`, `Farol` e `Radio`) sejam tratados pelo mesmo tipo (`Ligavel`). Se uma classe declarar `implements Ligavel` e esquecer um dos métodos, o código não compila (`Radio is not abstract and does not override abstract method desligar() in Ligavel`).

A diferença para a classe abstrata é que a classe abstrata representa o que o objeto **é** (um `Carro`) e pode ter atributos e métodos prontos, enquanto a interface representa o que o objeto **sabe fazer** (ser ligado), e classes sem nenhuma relação entre si podem implementá-la.

## Testes
Na aula de **24/09/26**, o `Main.java` foi atualizado para testar os objetos das classes filhas `Fiat` e `Toyota`. Na aula de **01/10/26** foi acrescentado o teste do polimorfismo de sobrescrita, na aula de **15/10/26**, o teste da classe abstrata e, na aula de **22/10/26**, o teste da interface.

Primeiramente, foi criado um objeto `Fiat`:

```java
Fiat fiat = new Fiat();
```

Depois, foram testados seu modelo, o ar-condicionado, a velocidade e o tanque. Em seguida, foi criado um objeto `Toyota`:

```java
Toyota toyota = new Toyota();
```

Também foram testados seu modelo, o modo híbrido, a velocidade e o tanque. Foi testada a regra de negócio tentando abastecer a `Fiat` além do limite. Por fim, foi criado um array de `Carro` com a `Fiat` e a `Toyota` para chamar `buzinar()` e `exibirTipo()` em cada um. Além disso, foi criado um array do tipo `Ligavel` com `Fiat`, `Toyota`, `Farol` e `Radio` para chamar `ligar()` e `desligar()` em cada um.

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

POLIMORFISMO
Fiat Argo -> Fiat: Pi-pi! | Tipo: Hatch compacto
Toyota Corolla -> Toyota: Pim-pim! | Tipo: Sedan medio

INTERFACE LIGAVEL
Fiat Argo: motor ligado
Fiat Argo: motor desligado
Toyota Corolla: motor ligado
Toyota Corolla: motor desligado
Farol aceso
Farol apagado
Radio tocando
Radio desligado
```

Os testes demonstram que `Fiat` e `Toyota` conseguem utilizar os comportamentos herdados de `Carro`, além de apresentarem suas próprias características, sobrescreverem `buzinar()`, implementarem o método abstrato `exibirTipo()` e serem tratadas pela interface `Ligavel` junto com classes de outras hierarquias.

## Projeto Carro - Microdesafio Pessoal "Transforme em Abstrata" - Aula 15/10/26

**Analise sua classe principal. Faz sentido existir um objeto APENAS `Carro`, sem ser uma Fiat, uma Toyota ou outro modelo específico?**

Não. No mundo real não existe um "carro genérico": todo carro que existe é de uma marca e de um modelo, como uma Fiat ou uma Toyota. `Carro` é apenas o conceito geral que reúne o que todos têm em comum (modelo, tanque, velocidade, acelerar, abastecer). Por isso a classe foi transformada em `abstract`:

```java
public abstract class Carro {
```

**Método abstrato que todas as subclasses devem implementar:** foi criado o `exibirTipo()`, que só tem a assinatura em `Carro` e é implementado de forma diferente em cada filha: `"Hatch compacto"` na `Fiat` e `"Sedan medio"` na `Toyota`.

```java
public abstract String exibirTipo();
```

**Teste: tentar criar um objeto da classe abstrata.** No `Main.java`, a linha abaixo foi testada e gerou erro de compilação:

```java
Carro carro = new Carro("Gol", new Tanque(0));
```

```text
Carro is abstract; cannot be instantiated
```

Como a classe abstrata é só um modelo, o Java não permite criar objetos dela. Depois do teste, a linha foi deixada comentada para o projeto continuar compilando.

**Prova de que as subclasses funcionam:** os objetos foram criados normalmente pelas classes filhas (`new Fiat()` e `new Toyota()`) e cada um respondeu com a sua própria implementação de `exibirTipo()`:

```text
Fiat Argo -> Fiat: Pi-pi! | Tipo: Hatch compacto
Toyota Corolla -> Toyota: Pim-pim! | Tipo: Sedan medio
```

## Projeto Carro - Microdesafio Pessoal "Crie suas Interfaces" - Aula 22/10/26

**Pense em um comportamento que objetos diferentes podem ter.**

O comportamento escolhido foi **poder ser ligado e desligado**. Um carro liga, um farol liga e um rádio liga, mas são objetos de naturezas diferentes e sem relação de herança entre si.

**Crie uma interface com 1 ou 2 métodos.** Foi criada a interface `Ligavel`, com dois métodos:

```java
public interface Ligavel {
    String ligar();
    String desligar();
}
```

**Faça 2 ou 3 classes, de hierarquias diferentes, implementarem a interface.** Foram feitas três implementações:

* `Carro` (hierarquia `Carro`, `Fiat`, `Toyota`): liga e desliga o motor.
* `Farol`: acende e apaga.
* `Radio`: toca e desliga.

**No `main`, crie um array da interface e chame os métodos polimorficamente.** Foi criado um array do tipo `Ligavel` com objetos das três hierarquias, e a mesma chamada produz um resultado diferente conforme o objeto real:

```java
Ligavel[] ligaveis = { fiat, toyota, new Farol(), new Radio() };

for (Ligavel item : ligaveis) {
    System.out.println(item.ligar());
    System.out.println(item.desligar());
}
```

```text
Fiat Argo: motor ligado
Fiat Argo: motor desligado
Toyota Corolla: motor ligado
Toyota Corolla: motor desligado
Farol aceso
Farol apagado
Radio tocando
Radio desligado
```

## Projeto Carro - Checklist Clean Code (Interfaces) - Aula 22/10/26

A interface `Ligavel` foi conferida contra o checklist de Clean Code para interfaces:

* **Nome descritivo:** `Ligavel` é um adjetivo que indica uma **capacidade** (poder ser ligado), como `Recarregavel`, `Voavel` e `Pagavel`.
* **Convenção "able":** em inglês seria `Switchable`; em português, usamos o adjetivo terminado em "-vel", que tem a mesma função.
* **Contrato claro:** `ligar()` e `desligar()` fazem parte de um único comportamento coeso (ligar e desligar um objeto), sem misturar responsabilidades aleatórias.
* **Poucos métodos:** a interface tem apenas 2 métodos, o que facilita a implementação por qualquer classe (Interface Segregation Principle). Por isso `Farol` e `Radio` precisam implementar só o que realmente fazem.
* **Documentação:** a interface foi documentada com JavaDoc, explicando **o que esperar de quem a implementa**: retornar uma mensagem descrevendo o que aconteceu, nunca retornar `null` nem vazio e não lançar exceção se for chamado mais de uma vez seguida.

```java
/**
 * Contrato para objetos que podem ser LIGADOS e DESLIGADOS.
 *
 * <p>Quem implementa esta interface deve garantir que:
 * <ul>
 *   <li>{@link #ligar()} coloque o objeto em funcionamento e retorne uma mensagem
 *       descrevendo o que aconteceu;</li>
 *   <li>{@link #desligar()} interrompa o funcionamento e retorne uma mensagem
 *       descrevendo o que aconteceu;</li>
 *   <li>as mensagens retornadas nunca sejam {@code null} nem vazias;</li>
 *   <li>nenhum dos dois metodos lance excecao se for chamado mais de uma vez seguida.</li>
 * </ul>
 */
public interface Ligavel {
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

### 01/10/26
* Aplicação do polimorfismo de sobrescrita.
* Criação do método `buzinar()` na classe `Carro`.
* Sobrescrita do método `buzinar()` nas classes `Fiat` e `Toyota` com `@Override`.
* Atualização do `Main.java` com um array de `Carro` para demonstrar o polimorfismo.

### 15/10/26
* Transformação da classe `Carro` em classe abstrata (`abstract`).
* Criação do método abstrato `exibirTipo()` na classe `Carro`.
* Implementação de `exibirTipo()` nas classes `Fiat` e `Toyota` com `@Override`.
* Atualização do `Main.java`, que deixou de instanciar `Carro` diretamente e passou a testar `exibirTipo()`.
* Resolução do microdesafio "Transforme em Abstrata" com a análise da classe `Carro`.
* Teste de criação de objeto da classe abstrata, que gerou erro de compilação.
* Adição da resposta do microdesafio ao README.

### 22/10/26
* Aplicação do conceito de interface.
* Criação da interface `Ligavel` com os métodos `ligar()` e `desligar()`.
* Implementação de `Ligavel` na classe `Carro`, herdada por `Fiat` e `Toyota`.
* Criação das classes `Farol` e `Radio`, de hierarquias diferentes, que também implementam `Ligavel`.
* Atualização do `Main.java` com um array do tipo `Ligavel` para demonstrar o polimorfismo.
* Resolução do microdesafio "Crie suas Interfaces" e adição da resposta ao README.
* Aplicação do checklist de Clean Code para interfaces (nome descritivo, contrato coeso e poucos métodos).
* Documentação da interface `Ligavel` com JavaDoc, explicando o que esperar de quem a implementa.