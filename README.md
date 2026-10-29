
# Projeto FiapRide - [Seu Nome Completo]

## Informações do Aluno

- **Nome:** Gabriel Guimarães de Oliveira
- **RM:** 567835
- **Turma:** 2ccpb
- **Curso:** Ciência da Computação
- **GitHub:** @ZuziR6

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos um sistema de veículos com foco em encapsulamento, construtores, associação, herança, polimorfismo, classes abstratas e interfaces.

O sistema possui uma classe abstrata Carro, implementada por Tesla e Toyota. O Tesla representa um veículo elétrico e possui uma bateria recarregável associada, enquanto o Toyota representa um veículo híbrido e possui um tanque de combustível. As classes Tanque e Bateria controlam seus próprios estados e validam as operações realizadas.

O projeto também utiliza as interfaces Ligavel e Recarregavel. A primeira define comportamentos de ligar e desligar, implementados por veículos, faróis e rádios. A segunda estabelece o contrato de recarga, implementado pelo Tesla e pela Bateria. No Main, os conceitos são demonstrados por meio de arrays polimórficos e chamadas realizadas através das interfaces.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil criar variáveis soltas no `main`? E se o sistema tiver um milhão de usuários?

**Sua Resposta:**

Criar uma classe permite reunir em uma única estrutura os atributos e comportamentos relacionados a um objeto. Se utilizássemos variáveis soltas para representar cada passageiro, teríamos que criar e controlar diversas variáveis individualmente, tornando o código difícil de manter. Com uma classe, podemos criar quantos objetos forem necessários a partir de um mesmo modelo. No nosso projeto, a classe `Carro` reúne características e comportamentos comuns aos veículos. Assim, `Tesla` e `Toyota` podem reutilizar essa estrutura sem duplicar todo o código. Essa organização facilita a manutenção e a evolução do sistema. Mesmo que a quantidade de objetos aumente, podemos trabalhar com coleções e estruturas polimórficas.

---

### Aula 2 - Métodos

**Pergunta:** Por que criar um método específico como `adicionarSaldo(valor)` em vez de alterar diretamente o saldo? Quais seriam os riscos de permitir alterações sem controle?

**Sua Resposta:**

Métodos específicos permitem centralizar as regras de negócio e controlar como os dados são modificados. Se qualquer parte do código pudesse alterar diretamente um valor, seria possível realizar operações inválidas e comprometer a consistência do sistema. No nosso projeto, o método `abastecer()` da classe `Tanque` verifica se a quantidade informada é positiva e se a capacidade máxima de 50 litros não será ultrapassada. Da mesma forma, o método `carregar()` da classe `Bateria` impede que a carga ultrapasse 100%. Dessa maneira, cada classe controla as operações relacionadas à sua própria responsabilidade. Isso reduz falhas de lógica e torna o comportamento dos objetos mais previsível.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar os métodos `get` públicos, mas perigoso deixar os atributos originais públicos? Qual é a diferença entre entregar uma cópia de um documento e entregar o original?

**Sua Resposta:**

Os métodos `get` permitem consultar informações sem conceder acesso direto aos atributos internos do objeto. Quando os atributos são privados, outras classes não podem modificá-los diretamente, preservando o encapsulamento. É semelhante a entregar uma cópia de um documento para consulta, em vez de permitir que outra pessoa altere o original. No projeto, atributos como `porcentagem`, `litros`, `modelo` e `velocidade` são privados. As consultas são realizadas por métodos públicos, enquanto as alterações acontecem por operações específicas que podem validar os valores recebidos. Assim, evitamos estados inválidos, como uma bateria com mais de 100% de carga ou um tanque com mais de 50 litros.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gerar getters e setters para tudo automaticamente? Como as decisões de não permitir alterações irrestritas protegem o sistema?

**Sua Resposta:**

Gerar getters e setters para todos os atributos sem avaliar sua necessidade pode permitir alterações que não fazem sentido para as regras de negócio. Um atributo privado perde parte de sua proteção se qualquer classe puder modificá-lo por meio de um setter público sem validação. No projeto, os construtores inicializam os objetos com os dados necessários e definem seus estados iniciais. A classe `Bateria`, por exemplo, valida a porcentagem recebida no construtor, enquanto o método `carregar()` controla as recargas posteriores. A classe `Tanque` também verifica se a quantidade inicial está dentro da capacidade permitida. Essas decisões evitam valores inválidos e mantêm as responsabilidades de cada classe bem definidas.

---

### Aula 5 - Associação

**Pergunta:** Por que receber o objeto inteiro no construtor pode ser melhor do que receber apenas uma `String` com o nome? O que acontece quando precisamos acessar comportamentos do objeto associado?

**Sua Resposta:**

Receber um objeto permite acessar não apenas uma informação isolada, mas também os comportamentos e as regras de negócio relacionados a ele. Uma `String` contendo somente um nome não permite executar operações próprias de outro objeto. No nosso projeto, o Tesla possui uma associação com um objeto da classe `Bateria`. Essa associação permite que o veículo solicite a recarga da bateria sem precisar controlar diretamente a porcentagem armazenada. A classe `Bateria` é responsável por validar a quantidade de carga recebida. Dessa maneira, cada classe mantém sua própria responsabilidade e o sistema fica mais organizado. A associação também facilita a reutilização e a manutenção do código.

---

### Aula 6 - Herança

**Pergunta:** Por que o Java não permite que uma classe filha altere diretamente os atributos privados da classe mãe? Qual princípio isso protege?

**Sua Resposta:**

O Java não permite o acesso direto aos atributos `private` de outra classe porque esses atributos estão protegidos pelo encapsulamento. Isso garante que a classe responsável pelos dados controle como eles são consultados e modificados. No projeto, `Tesla` e `Toyota` herdam de `Carro`, compartilhando características e comportamentos comuns, como o modelo, a velocidade e a aceleração. Entretanto, não precisam acessar diretamente os atributos privados da classe mãe. O acesso às informações ocorre por métodos públicos apropriados. Essa separação permite reutilizar o código sem comprometer a proteção dos dados. Além disso, cada classe filha pode implementar características específicas sem duplicar toda a estrutura da classe base.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se o método `calcularAutonomia()` não existisse na classe base, seria possível chamá-lo em um loop usando uma referência do tipo `Veiculo`? Por que o contrato precisa existir na base da hierarquia?

**Sua Resposta:**

Uma variável declarada com um tipo de referência só pode acessar os métodos disponíveis nesse tipo, considerando também os métodos herdados. Se um método não estiver declarado na classe base nem for herdado por ela, não poderemos chamá-lo diretamente usando uma referência desse tipo. No projeto, o método `exibirTipo()` é declarado como abstrato na classe `Carro` e implementado por `Tesla` e `Toyota`. Assim, podemos percorrer um array de `Carro` e chamar o método sem precisar verificar individualmente a classe de cada objeto. Cada veículo fornece sua própria implementação. Isso demonstra o polimorfismo e permite adicionar novos tipos de veículos com menos alterações no código principal.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos declarar explicitamente uma classe como `abstract`? Qual é o risco de permitir a criação de um objeto genérico que não representa um tipo específico?

**Sua Resposta:**

Uma classe abstrata representa uma estrutura geral que não deve ser instanciada diretamente. No projeto, `Carro` reúne características comuns, mas os veículos concretos são representados por classes como `Tesla` e `Toyota`. Declarar `Carro` como `abstract` informa explicitamente ao Java que essa classe deve servir como base para outras classes. O compilador não deduz essa intenção automaticamente, pois uma classe comum pode ser instanciável mesmo que seu nome represente algo genérico. Se não utilizássemos `abstract`, seria possível criar objetos diretamente de `Carro`, contrariando a estrutura desejada. A classe abstrata também exige que as subclasses concretas implementem o método abstrato `exibirTipo()`, garantindo um comportamento comum.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite implementar várias interfaces, mas não herdar de várias classes? Como as interfaces ajudam a evitar conflitos e permitem compartilhar comportamentos entre hierarquias diferentes?

**Sua Resposta:**

As interfaces definem contratos de comportamento sem exigir que as classes pertençam à mesma hierarquia de herança. Java permite implementar várias interfaces porque isso possibilita que uma classe cumpra diferentes contratos sem herdar o estado e a implementação de múltiplas classes. A herança múltipla de classes poderia gerar ambiguidades caso diferentes classes mães definissem implementações conflitantes de um mesmo método. No projeto, `Ligavel` define as operações de ligar e desligar, implementadas pelos veículos, pelo farol e pelo rádio. Já `Recarregavel` define o comportamento de recarga, implementado por `Tesla` e `Bateria`. No `Main`, arrays dessas interfaces permitem chamar os comportamentos sem depender das classes concretas dos objetos.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**

O domínio escolhido foi um sistema de veículos elétricos e híbridos, com representação de veículos, controle de combustível e bateria recarregável.

**Quais classes você criou?**

- `Carro`: classe abstrata com características e comportamentos comuns aos veículos.
- `Tesla`: representa um veículo elétrico e possui uma bateria associada.
- `Toyota`: representa um veículo híbrido e possui um tanque associado.
- `Tanque`: controla a quantidade de combustível e sua capacidade máxima.
- `Bateria`: controla a porcentagem de carga e as regras de recarga.
- `Farol`: representa um componente que pode ser ligado e desligado.
- `Radio`: representa outro componente que pode ser ligado e desligado.
- `Ligavel`: interface que define o contrato de ligar e desligar.
- `Recarregavel`: interface que define o contrato de recarga.
- `Main`: contém os arrays polimórficos e as chamadas dos métodos por meio das interfaces.

**Qual foi o maior desafio técnico que você enfrentou?**

O maior desafio técnico foi integrar os conceitos dos dois projetos sem perder a coerência entre as classes e suas responsabilidades. Inicialmente, a classe `Carro` possuía um tanque de combustível associado, o que não representava adequadamente um veículo elétrico como o Tesla. Para resolver isso, o tanque passou a pertencer ao Toyota, enquanto o Tesla recebeu uma bateria recarregável associada. Outro desafio foi organizar as interfaces para que diferentes objetos pudessem executar comportamentos comuns. A interface `Ligavel` foi mantida para ligar e desligar veículos e componentes, enquanto a interface `Recarregavel` foi criada para controlar o contrato de recarga. A classe `Bateria` implementa esse contrato e continua responsável pela validação da porcentagem de carga. O Tesla delega a operação de recarga à bateria, evitando duplicar regras de negócio. Por fim, o `Main` foi simplificado para demonstrar o polimorfismo por meio de arrays de classes abstratas e interfaces, sem realizar testes individuais de cada objeto. Essa reorganização tornou o projeto mais coerente e demonstrou como associação, herança, polimorfismo e interfaces podem trabalhar em conjunto.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**

Ao longo das nove aulas, aprendi a organizar programas utilizando os princípios da Programação Orientada a Objetos. Compreendi como classes e objetos representam elementos de um sistema e como métodos definem seus comportamentos. Aprendi a proteger os atributos com encapsulamento, inicializar objetos por meio de construtores e relacionar objetos por associação. Também compreendi como a herança permite reutilizar características comuns, enquanto o polimorfismo permite executar comportamentos diferentes por meio de uma referência genérica. As classes abstratas ajudam a definir estruturas que não devem ser instanciadas diretamente. Por fim, as interfaces permitem estabelecer contratos compartilhados por classes diferentes, tornando o código mais flexível e organizado.

**Qual conceito foi mais difícil de entender?**

O conceito mais difícil foi compreender como associação e interfaces se relacionam com o polimorfismo. Inicialmente, pode parecer que basta colocar todos os comportamentos em uma única classe, mas isso dificulta a manutenção e mistura responsabilidades. Durante a integração, ficou mais claro que a bateria deve controlar sua própria carga, enquanto o Tesla utiliza a bateria por associação. A interface `Recarregavel` permite que os dois tipos de objeto ofereçam o comportamento de recarga sem depender da mesma classe base. Com a implementação dos arrays polimórficos, compreendi melhor como chamar métodos por meio de contratos comuns, mesmo quando os objetos possuem estruturas diferentes.

**O que você melhoraria no seu projeto se pudesse refazer?**

Se pudesse refazer o projeto, melhoraria a organização dos pacotes, separando as classes de domínio, as interfaces e a classe principal. Também adicionaria testes automatizados para verificar os limites de combustível e de carga da bateria, além de testar aceleração, herança e implementações das interfaces. Outra melhoria seria desenvolver um controle mais completo da recarga do Tesla, incluindo estados de carga e regras específicas de utilização. Também documentaria melhor as responsabilidades de cada classe e ampliaria os testes para verificar o comportamento de novos veículos sem precisar modificar o código principal. Essas melhorias ajudariam a tornar o sistema mais fácil de manter, testar e expandir.
