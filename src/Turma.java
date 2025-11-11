import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados;

    public Turma(String codigoTurma, Disciplina disciplina, Professor professor) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
    }
    
    public void adicionarAluno(Aluno aluno) {
        this.alunosMatriculados.add(aluno);
    }
    
    public void exibirInformacoes() {
        System.out.println("\n\n\n\n--- Turma: " + codigoTurma + " ---");
        disciplina.exibirDetalhes();
        professor.apresentar();
        System.out.println("Alunos Matriculados: " + alunosMatriculados.size());
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(" - " + aluno.getNome());
        }
        System.out.println("------------------------");
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}