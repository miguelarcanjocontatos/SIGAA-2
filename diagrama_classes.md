classDiagram
    %% --- Classes ---
    class Pessoa {
        <<abstract>>
        -String nome
        -String cpf
        +getNome() String
        +setNome(String) void
        +getCpf() String
        +setCpf(String) void
        +apresentar()*
    }

    class Aluno {
        -String matricula
        +getMatricula() String
        +setMatricula(String) void
        +apresentar() void
    }

    class Professor {
        -String departamento
        +getDepartamento() String
        +setDepartamento(String) void
        +apresentar() void
    }

    class ComponenteAcademico {
        <<abstract>>
        -String codigo
        -String nome
        +getCodigo() String
        +getNome() String
        +exibirDetalhes()*
    }

    class Disciplina {
        -int cargaHoraria
        +getCargaHoraria() int
        +exibirDetalhes() void
    }

    class Curso {
        -int duracaoSemestres
        +getDuracaoSemestres() int
        +exibirDetalhes() void
    }

    class Endereco {
        -String id
        -String rua
        -String cidade
    }

    class Turma {
        -String codigoTurma
        +adicionarAluno(Aluno) void
        +exibirInformacoes() void
    }

    class Secretaria {
        -List~Aluno~ alunos
        -List~Professor~ professores
        -List~Disciplina~ disciplinas
        -List~Curso~ cursos
        -List~Turma~ turmas
        -List~Endereco~ enderecos
        +adicionarAluno(Aluno) void
        +removerAluno(String) void
        +... CRUDs
    }

    class App {
        -Scanner scanner
        -Secretaria secretaria
        +main(String[]) void
        -gerenciarAlunos() void
        -gerenciarProfessores() void
        - ...
    }
    
    class Exception {
        %% Mermaid não tem uma notação padrão para herança de classes nativas como Exception
        %% Esta é uma representação visual
    }

    class RecursoNaoEncontradoException {
        +RecursoNaoEncontradoException(String)
    }

    %% --- Relacionamentos de Herança ---
    Pessoa <|-- Aluno
    Pessoa <|-- Professor
    ComponenteAcademico <|-- Disciplina
    ComponenteAcademico <|-- Curso
    Exception <|-- RecursoNaoEncontradoException

    %% --- Relacionamentos de Composição/Agregação ---
    Secretaria "1" *-- "0..*" Aluno
    Secretaria "1" *-- "0..*" Professor
    Secretaria "1" *-- "0..*" Disciplina
    Secretaria "1" *-- "0..*" Curso
    Secretaria "1" *-- "0..*" Turma
    Secretaria "1" *-- "0..*" Endereco

    Turma --> "1" Disciplina
    Turma --> "1" Professor
    Turma "1" *-- "0..*" Aluno

    %% --- Relacionamentos de Dependência/Uso ---
    App ..> Secretaria : usa
    Secretaria ..> RecursoNaoEncontradoException : lança
    App ..> RecursoNaoEncontradoException : trata