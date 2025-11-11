public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf); // Chama o construtor da classe pai (Pessoa)
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    // Polimorfismo!
    public void apresentar() {
        System.out.println("ALUNO: " + getNome() + " | Matrícula: " + this.matricula + " | CPF: " + getCpf());
    }
}