class Funcionario(
    nome: String,
    idade: Int,
    casado: Boolean? = null,
    altura: Double? = null,
    var salario: Double
) : Pessoa(nome, idade, casado, altura) {


    override fun toString(): String {
        return "Funcionario(salario=$salario) ${super.toString()}"
    }
}