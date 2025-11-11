import java.util.Scanner;

// REQUISITO 8: Esta classe é responsável pela interação com o usuário via linha de comando.
public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Secretaria secretaria = new Secretaria();

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();
            try { // Adicionado try-catch para evitar que o programa quebre com input inválido
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        gerenciarAlunos();
                        break;
                    case 2:
                        gerenciarProfessores();
                        break;
                    case 3:
                        gerenciarDisciplinas();
                        break;
                    case 4:
                        gerenciarCursos();
                        break;
                    case 5:
                        gerenciarTurmas();
                        break;
                    case 6:
                        gerenciarEnderecos();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Erro: Por favor, digite um número válido.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n\n\n\n--- SIGAA 2 - Menu Principal ---");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Gerenciar Disciplinas");
        System.out.println("4. Gerenciar Cursos");
        System.out.println("5. Gerenciar Turmas");
        System.out.println("6. Gerenciar Endereços");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // REQUISITO 5a: CRUD completo para a entidade Aluno
    private static void gerenciarAlunos() {
        System.out.println("\n\n\n\n--- Gerenciar Alunos ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Atualizar Aluno");
        System.out.println("4. Remover Aluno");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());

        switch (op) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Matrícula: ");
                String mat = scanner.nextLine();
                secretaria.adicionarAluno(new Aluno(nome, cpf, mat));
                System.out.println("Aluno cadastrado!");
                break;
            case 2:
                System.out.println("\n\n\n\n--- Lista de Alunos ---");
                // REQUISITO 4a: POLIMORFISMO em ação (base Pessoa).
                // O método apresentar() será o do Aluno ou do Professor, dependendo do objeto.
                for (Pessoa p : secretaria.listarAlunos()) {
                    p.apresentar();
                }
                break;
            case 3:
                // REQUISITO 6b: Tratando a exceção personalizada com try-catch.
                try {
                    System.out.print("Matrícula do aluno a atualizar: ");
                    String matAtualizar = scanner.nextLine();
                    Aluno aluno = secretaria.buscarAlunoPorMatricula(matAtualizar);
                    System.out.print("Novo nome: ");
                    aluno.setNome(scanner.nextLine());
                    System.out.print("Novo CPF: ");
                    aluno.setCpf(scanner.nextLine());
                    System.out.println("Aluno atualizado!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    System.out.print("Matrícula do aluno a remover: ");
                    String matRemover = scanner.nextLine();
                    secretaria.removerAluno(matRemover);
                    System.out.println("Aluno removido!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // REQUISITO 5b: CRUD completo para a entidade Professor
    private static void gerenciarProfessores() {
        System.out.println("\n\n\n\n--- Gerenciar Professores ---");
        System.out.println("1. Cadastrar Professor");
        System.out.println("2. Listar Professores");
        System.out.println("3. Atualizar Professor");
        System.out.println("4. Remover Professor");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Departamento: ");
                String depto = scanner.nextLine();
                secretaria.adicionarProfessor(new Professor(nome, cpf, depto));
                System.out.println("Professor cadastrado!");
                break;
            case 2:
                System.out.println("\n\n\n\n--- Lista de Professores ---");
                // REQUISITO 4a: Outro exemplo de POLIMORFISMO (base Pessoa).
                for (Pessoa p : secretaria.listarProfessores()) {
                    p.apresentar();
                }
                break;
            case 3:
                try {
                    System.out.print("CPF do professor a atualizar: ");
                    String cpfAtualizar = scanner.nextLine();
                    Professor prof = secretaria.buscarProfessorPorCpf(cpfAtualizar);
                    System.out.print("Novo nome: ");
                    prof.setNome(scanner.nextLine());
                    System.out.print("Novo departamento: ");
                    prof.setDepartamento(scanner.nextLine());
                    System.out.println("Professor atualizado!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                try {
                    System.out.print("CPF do professor a remover: ");
                    String cpfRemover = scanner.nextLine();
                    secretaria.removerProfessor(cpfRemover);
                    System.out.println("Professor removido!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // REQUISITO 5c: CRUD completo para a entidade Disciplina
    private static void gerenciarDisciplinas() {
        System.out.println("\n\n\n\n--- Gerenciar Disciplinas ---");
        System.out.println("1. Cadastrar Disciplina");
        System.out.println("2. Listar Disciplinas");
        System.out.println("3. Atualizar Disciplina");
        System.out.println("4. Remover Disciplina");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1:
                System.out.print("Código: ");
                String cod = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Carga Horária: ");
                int ch = Integer.parseInt(scanner.nextLine());
                secretaria.adicionarDisciplina(new Disciplina(cod, nome, ch));
                System.out.println("Disciplina cadastrada!");
                break;
            case 2:
                System.out.println("\n\n\n\n--- Lista de Disciplinas ---");
                // REQUISITO 4b: POLIMORFISMO da segunda árvore de herança (base
                // ComponenteAcademico).
                for (ComponenteAcademico ca : secretaria.listarDisciplinas()) {
                    ca.exibirDetalhes();
                }
                break;
            case 3:
                try {
                    System.out.print("Código da disciplina a atualizar: ");
                    String codAtualizar = scanner.nextLine();
                    Disciplina disc = secretaria.buscarDisciplinaPorCodigo(codAtualizar);
                    System.out.print("Novo nome: ");
                    disc.setNome(scanner.nextLine());
                    System.out.print("Nova Carga Horária: ");
                    disc.setCargaHoraria(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Disciplina atualizada!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Carga horária deve ser um número.");
                }
                break;
            case 4:
                try {
                    System.out.print("Código da disciplina a remover: ");
                    String codRemover = scanner.nextLine();
                    secretaria.removerDisciplina(codRemover);
                    System.out.println("Disciplina removida!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // REQUISITO 5d: CRUD completo para a entidade Curso
    private static void gerenciarCursos() {
        System.out.println("\n\n\n\n--- Gerenciar Cursos ---");
        System.out.println("1. Cadastrar Curso");
        System.out.println("2. Listar Cursos");
        System.out.println("3. Atualizar Curso");
        System.out.println("4. Remover Curso");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1:
                System.out.print("Código: ");
                String cod = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Duração (semestres): ");
                int duracao = Integer.parseInt(scanner.nextLine());
                secretaria.adicionarCurso(new Curso(cod, nome, duracao));
                System.out.println("Curso cadastrado!");
                break;
            case 2:
                System.out.println("\n\n\n\n--- Lista de Cursos ---");
                // REQUISITO 4b: Outro exemplo de POLIMORFISMO (base ComponenteAcademico).
                for (ComponenteAcademico ca : secretaria.listarCursos()) {
                    ca.exibirDetalhes();
                }
                break;
            case 3:
                try {
                    System.out.print("Código do curso a atualizar: ");
                    String codAtualizar = scanner.nextLine();
                    Curso curso = secretaria.buscarCursoPorCodigo(codAtualizar);
                    System.out.print("Novo nome: ");
                    curso.setNome(scanner.nextLine());
                    System.out.print("Nova Duração (semestres): ");
                    curso.setDuracaoSemestres(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Curso atualizado!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Duração deve ser um número.");
                }
                break;
            case 4:
                try {
                    System.out.print("Código do curso a remover: ");
                    String codRemover = scanner.nextLine();
                    secretaria.removerCurso(codRemover);
                    System.out.println("Curso removido!");
                } catch (RecursoNaoEncontradoException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    // REQUISITO 5e: CRUD completo para a entidade Turma
    private static void gerenciarTurmas() {
        System.out.println("\n\n\n\n--- Gerenciar Turmas ---");
        System.out.println("1. Criar Turma");
        System.out.println("2. Listar Turmas");
        System.out.println("3. Adicionar Aluno à Turma");
        System.out.println("4. Remover Turma");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        try {
            switch (op) {
                case 1:
                    System.out.print("Código da nova turma: ");
                    String codTurma = scanner.nextLine();
                    System.out.print("Código da disciplina: ");
                    String codDisc = scanner.nextLine();
                    Disciplina disc = secretaria.buscarDisciplinaPorCodigo(codDisc);
                    System.out.print("CPF do professor: ");
                    String cpfProf = scanner.nextLine();
                    Professor prof = secretaria.buscarProfessorPorCpf(cpfProf);
                    secretaria.adicionarTurma(new Turma(codTurma, disc, prof));
                    System.out.println("Turma criada!");
                    break;
                case 2:
                    System.out.println("\n\n\n\n--- Lista de Turmas ---");
                    for (Turma t : secretaria.listarTurmas()) {
                        t.exibirInformacoes();
                    }
                    break;
                case 3: // Exemplo de "Update" para Turma
                    System.out.print("Código da turma: ");
                    String codTurmaAdd = scanner.nextLine();
                    Turma turma = secretaria.buscarTurmaPorCodigo(codTurmaAdd);
                    System.out.print("Matrícula do aluno: ");
                    String matAluno = scanner.nextLine();
                    Aluno aluno = secretaria.buscarAlunoPorMatricula(matAluno);
                    turma.adicionarAluno(aluno);
                    System.out.println("Aluno matriculado na turma!");
                    break;
                case 4:
                    System.out.print("Código da turma a remover: ");
                    String codTurmaRemover = scanner.nextLine();
                    secretaria.removerTurma(codTurmaRemover);
                    System.out.println("Turma removida!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (RecursoNaoEncontradoException e) {
            System.err.println("Erro ao gerenciar turma: " + e.getMessage());
        }
    }

    // REQUISITO 5f: CRUD completo para a entidade Endereco
    private static void gerenciarEnderecos() {
        System.out.println("\n\n\n\n--- Gerenciar Endereços ---");
        System.out.println("1. Cadastrar Endereço");
        System.out.println("2. Listar Endereços");
        System.out.println("3. Atualizar Endereço");
        System.out.println("4. Remover Endereço");
        System.out.print("Opção: ");
        int op = Integer.parseInt(scanner.nextLine());
        try {
            switch (op) {
                case 1:
                    System.out.print("CPF da pessoa (ID do endereço): ");
                    String id = scanner.nextLine();
                    
                    // Validação para ver se a pessoa (aluno ou professor) existe
                    try {
                        secretaria.buscarAlunoPorCpf(id);
                    } catch (RecursoNaoEncontradoException eAluno) {
                        // Se não encontrou aluno, tenta buscar professor. Se falhar, a exceção será propagada.
                        secretaria.buscarProfessorPorCpf(id);
                    }

                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    secretaria.adicionarEndereco(new Endereco(id, rua, cidade));
                    System.out.println("Endereço cadastrado!");
                    break;
                case 2:
                    System.out.println("\n\n\n\n--- Lista de Endereços ---");
                    for (Endereco end : secretaria.listarEnderecos()) {
                        System.out.println(end); // Usa o método toString() da classe Endereco
                    }
                    break;
                case 3:
                    System.out.print("ID (CPF) do endereço a atualizar: ");
                    String idAtualizar = scanner.nextLine();
                    Endereco end = secretaria.buscarEnderecoPorId(idAtualizar);
                    System.out.print("Nova rua: ");
                    end.setRua(scanner.nextLine());
                    System.out.print("Nova cidade: ");
                    end.setCidade(scanner.nextLine());
                    System.out.println("Endereço atualizado!");
                    break;
                case 4:
                    System.out.print("ID (CPF) do endereço a remover: ");
                    String idRemover = scanner.nextLine();
                    secretaria.removerEndereco(idRemover);
                    System.out.println("Endereço removido!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (RecursoNaoEncontradoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}