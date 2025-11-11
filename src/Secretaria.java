import java.util.ArrayList;
import java.util.List;

// REQUISITO 5: Esta classe centraliza a lógica de negócio e o acesso aos dados (CRUD).

public class Secretaria {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    // --- CRUD ALUNO ---
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    // Não vou utilizar stream/lambda aqui para manter consistência com o restante do código
    public Aluno buscarAlunoPorMatricula(String mat) throws RecursoNaoEncontradoException {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(mat)) {
                return aluno;
            }
        }
        throw new RecursoNaoEncontradoException("Aluno com matrícula " + mat + " não encontrado.");
    }
    
    public Aluno buscarAlunoPorCpf(String cpf) throws RecursoNaoEncontradoException {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        throw new RecursoNaoEncontradoException("Aluno com CPF " + cpf + " não encontrado.");
    }

    public void removerAluno(String mat) throws RecursoNaoEncontradoException {
        Aluno aluno = buscarAlunoPorMatricula(mat);
        alunos.remove(aluno);
    }

    // --- CRUD PROFESSOR ---
    public void adicionarProfessor(Professor p) {
        professores.add(p);
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    // Não vou utilizar stream/lambda aqui para manter consistência com o restante do código
    public Professor buscarProfessorPorCpf(String cpf) throws RecursoNaoEncontradoException {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        throw new RecursoNaoEncontradoException("Professor com CPF " + cpf + " não encontrado.");
    }

    public void removerProfessor(String cpf) throws RecursoNaoEncontradoException {
        Professor p = buscarProfessorPorCpf(cpf);
        professores.remove(p);
    }

    // --- CRUD DISCIPLINA ---
    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscarDisciplinaPorCodigo(String cod) throws RecursoNaoEncontradoException {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(cod)) {
                return disciplina;
            }
        }
        throw new RecursoNaoEncontradoException("Disciplina com código " + cod + " não encontrada.");
    }

    public void removerDisciplina(String cod) throws RecursoNaoEncontradoException {
        Disciplina d = buscarDisciplinaPorCodigo(cod);
        disciplinas.remove(d);
    }

    // --- CRUD CURSO ---
    public void adicionarCurso(Curso c) {
        cursos.add(c);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }
    
    public Curso buscarCursoPorCodigo(String cod) throws RecursoNaoEncontradoException {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(cod)) {
                return curso;
            }
        }
        throw new RecursoNaoEncontradoException("Curso com código " + cod + " não encontrado.");
    }

    public void removerCurso(String cod) throws RecursoNaoEncontradoException {
        Curso c = buscarCursoPorCodigo(cod);
        cursos.remove(c);
    }

    // --- CRUD TURMA ---
    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }
    
    public Turma buscarTurmaPorCodigo(String cod) throws RecursoNaoEncontradoException {
        for (Turma turma : turmas) {
            if (turma.getCodigoTurma().equals(cod)) {
                return turma;
            }
        }
        throw new RecursoNaoEncontradoException("Turma com código " + cod + " não encontrada.");
    }

    public void removerTurma(String cod) throws RecursoNaoEncontradoException {
        Turma t = buscarTurmaPorCodigo(cod);
        turmas.remove(t);
    }

    // --- CRUD ENDEREÇO ---
    public void adicionarEndereco(Endereco e) {
        enderecos.add(e);
    }

    public List<Endereco> listarEnderecos() {
        return enderecos;
    }
    
    public Endereco buscarEnderecoPorId(String id) throws RecursoNaoEncontradoException {
        for (Endereco endereco : enderecos) {
            if (endereco.getId().equals(id)) {
                return endereco;
            }
        }
        throw new RecursoNaoEncontradoException("Endereço com ID (CPF) " + id + " não encontrado.");
    }

    public void removerEndereco(String id) throws RecursoNaoEncontradoException {
        Endereco e = buscarEnderecoPorId(id);
        enderecos.remove(e);
    }
}