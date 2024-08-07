package school.sptech;

public class Paciente {

    // Atributos
    private int id;         // ID do paciente
    private String nome;    // Nome do paciente
    private int idade;      // Idade do paciente
    private String sintoma; // Sintoma do paciente
    private Boolean gestante;   // Se paciente eh gestante ou não


    // Construtor
    public Paciente(int id, String nome, int idade, String sintoma, Boolean gestante) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
        this.gestante = gestante;
    }

    // toString()

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sintoma='" + sintoma + '\'' +
                ", gestante=" + gestante +
                '}';
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }
}
