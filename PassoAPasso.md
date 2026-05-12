### Projeto - Melhor Preço

#### Equipe:

- Isabella Corrêa 

- Marcus Jhuan


- Lucas Gabriel 

### 1. Introdução

O sistema utiliza algoritmos de Estrutura de Dados (Lista Sequencial Dinâmica e
Bubble Sort) para processar e ordenar as informações coletadas nos buscadores dos
supermercados Giassi, Bistek e Fort Atacadista.

**2. Estrutura do Projeto**

O projeto segue a estrutura padrão do Gradle:
src/main/java/esd/ : Contém a implementação da ListaSequencial.
src/main/java/sm/ : Contém as classes de negócio (Buscadores, Produto,
Main).

**3. Como Executar**

- Java JDK 11 ou superior instalado.
- Gradle instalado (ou utilize o gradlew incluso no projeto).

**Passo a passo**
1. Abra o terminal na pasta raiz do projeto.
2. Compile o projeto utilizando o comando:

gradle build

**3. Execute a aplicação:**

gradle run

**4. Utilização do Programa**

Ao iniciar, o programa solicitará a entrada dos produtos. Siga os passos abaixo:

Inserção: Digite o nome do produto (ex: Arroz 5kg ) e pressione Enter.
Repetição: Continue adicionando quantos itens desejar.
Finalização: Quando terminar sua lista, digite fim .
Resultado: O sistema processará as buscas e exibirá uma tabela ordenada do
supermercado mais barato para o mais caro.
