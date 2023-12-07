
open class Pessoa (
    nome: String,
    var idade: Int,
    var casado: Boolean? = null,
    var altura: Double? = null
) {

    var nome: String = nome
        get() = field
        set(value) {
            field = value
        }

    open fun calcularIdade(): Double {
        return 0.0
    }

    override fun toString(): String {
        return "Pessoa(nome='$nome', idade=$idade, casado=$casado, altura=$altura)"
    }
}


