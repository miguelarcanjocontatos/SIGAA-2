// src/ComponenteAcademico.java
public abstract class ComponenteAcademico {
    private String codigo;
    private String nome;

    public ComponenteAcademico(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Segundo método abstrato para Polimorfismo
    public abstract void exibirDetalhes();
}