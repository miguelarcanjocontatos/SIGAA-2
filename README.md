# Projeto SIGAA 2 - Sistema de Gestão Acadêmica

Alunos:
- Rian Abdias Balbino de Azevedo
- Maria Letícia de Moura Silva
- Miguel Arcanjo Araújo de Sousa Pinheiro

# Detalhes do Projeto (IMPORTANTE!!!)

- Devido às outras materias que estavam sendo pagas pelos componentes do grupo, o versionamento do código não aconteceu e as discussões aconteceram no grupo do whatsapp.

- Por opção do grupo, e pra manter simplicidade, não usamos lambda functions.

- Tratamento de erros personalizado de forma que as mensagens ficassem mais modulares.

- Indentação feita pelo compilador da extensão do Java no VSCODE

- Vou citar abaixo onde estão o cumprimento dos requisitos, porém no código também está escrito onde foram alcançados os pontos para fins de avaliação.

# COMO RODAR O PROJETO (IMPORTANTE!!!)

- Ter java jdk 21.0.6

- Ter build java SE LTS (2021) 21.0.6

- Ir para pasta raiz SIGAA 2

- javac -d bin src/*.java (Para compilar)

- java -cp bin App (Para executar)

## Verificação dos Requisitos Mínimos

### 1. Mínimo 8 Classes
Fizemos 11 classes:
- `Pessoa.java` (Classe base abstrata)
- `Aluno.java`
- `Professor.java`
- `ComponenteAcademico.java` (Segunda classe base abstrata)
- `Disciplina.java`
- `Curso.java`
- `Turma.java`
- `Endereco.java`
- `Secretaria.java` (Classe de serviço que gerencia os dados)
- `App.java` (Classe principal para interação com o usuário)
- `RecursoNaoEncontradoException.java` (Classe de exceção personalizada)

### 2. Encapsulamento
Todas as entidades do sistema (Aluno, Professor, Disciplina, etc.) seguem o princípio do encapsulamento. Os atributos são declarados como `private`, e o acesso deles é controlado por meio de métodos públicos (`getters` e `setters`).
```

### 3. Mínimo 2 Heranças (com Classes Bases Diferentes)
O projeto implementa duas hierarquias de herança diferentes:

a. **Hierarquia de `Pessoa`:**
   - A classe abstrata `Pessoa` serve como base.
   - `Aluno` e `Professor` herdam de `Pessoa`, compartilhando os atributos `nome` e `cpf`.

b. **Hierarquia de `ComponenteAcademico`:**
   - A classe abstrata `ComponenteAcademico` serve como base.
   - `Disciplina` e `Curso` herdam de `ComponenteAcademico`, compartilhando os atributos `codigo` e `nome`, assim como o SIGAA faz.

### 4. Mínimo 2 Polimorfismos (de Classes Bases Diferentes)
O polimorfismo é demonstrado através da sobrescrita de métodos (`@Override`) das classes abstratas.

a. **Polimorfismo de `Pessoa.apresentar()`:**
   - O método `apresentar()` é declarado como `abstract` em `Pessoa`.
   - `Aluno` e `Professor` fornecem implementações específicas.
   
   **Demonstração em `App.java`:** Ao listar alunos, o código itera sobre uma lista de `Pessoa`, e a JVM decide em tempo de execução qual método `apresentar()` chamar.
     ```java
     // em App.gerenciarAlunos()
     for (Pessoa p : secretaria.listarAlunos()) {
         p.apresentar(); // Chama Aluno.apresentar()
     }
     ```

b. **Polimorfismo de `ComponenteAcademico.exibirDetalhes()`:**
   - O método `exibirDetalhes()` é `abstract` em `ComponenteAcademico`.
   - `Disciplina` e `Curso` implementam este método de formas diferentes.
   - **Demonstração em `App.java`:**
     ```java
     // em App.gerenciarDisciplinas()
     for (ComponenteAcademico ca : secretaria.listarDisciplinas()) {
         ca.exibirDetalhes(); // Chama Disciplina.exibirDetalhes()
     }
     ```

### 5. CRUD (Criar, Ler, Atualizar, Remover)
O sistema implementa operações CRUD para 6 entidades: Aluno, Professor, Disciplina, Curso, Turma e Endereço.
- A lógica de armazenamento e busca de dados está centralizada em `Secretaria.java`.
- A interação com o usuário para executar essas operações (menus para cadastrar, listar, atualizar e remover) está implementada nos métodos `gerenciar...()` da classe `App.java`.

### 6. Tratamento de Exceções
a. **Exceção Personalizada:**
   - A classe `RecursoNaoEncontradoException.java` foi criada para representar erros onde um item (como um aluno ou disciplina) não é encontrado no sistema. Ela herda de `Exception`.

b. **Validação de Dados com Exceções:**
   - Os métodos de busca na classe `Secretaria.java` (ex: `buscarAlunoPorMatricula`) lançam (`throws`) a `RecursoNaoEncontradoException` se o recurso não for localizado.
   - Na classe `App.java`, as chamadas a esses métodos são envolvidas em blocos `try-catch` para tratar o erro, exibindo uma mensagem para o usuário sem quebrar a execução do programa.
   - **Exemplo (`App.java`):**
     ```java
     try {
         System.out.print("Matrícula do aluno a remover: ");
         String matRemover = scanner.nextLine();
         secretaria.removerAluno(matRemover);
         System.out.println("Aluno removido!");
     } catch (RecursoNaoEncontradoException e) {
         System.err.println("Erro: " + e.getMessage());
     }
     ```

### 7. Diagrama de Classes – UML
No arquivo SIGAA 2 - Mermaid.png e diagrama_classes.md

### 8. Apresentação do Sistema Funcionando
A classe `App.java` contém o método `main`, que inicia um loop infinito com um menu de opções no console. O usuário pode interagir com o sistema através da linha de comando, escolhendo as operações que deseja realizar (cadastrar, listar, etc.), o que cumpre o requisito de interação.

```