public class Disciplina extends ComponenteAcademico {
    private int cargaHoraria;

    public Disciplina(String codigo, String nome, int cargaHoraria) {
        super(codigo, nome);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("DISCIPLINA: " + getNome() + " | Código: " + getCodigo() + " | Carga Horária: " + cargaHoraria + "h");
    }
}