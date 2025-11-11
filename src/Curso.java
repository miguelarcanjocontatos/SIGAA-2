// src/Curso.java
public class Curso extends ComponenteAcademico {
    private int duracaoSemestres;

    public Curso(String codigo, String nome, int duracaoSemestres) {
        super(codigo, nome);
        this.duracaoSemestres = duracaoSemestres;
    }

    public int getDuracaoSemestres() {
        return duracaoSemestres;
    }

    public void setDuracaoSemestres(int duracaoSemestres) {
        this.duracaoSemestres = duracaoSemestres;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("CURSO: " + getNome() + " | Código: " + getCodigo() + " | Duração: " + duracaoSemestres + " semestres");
    }
}