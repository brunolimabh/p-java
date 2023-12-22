fun main(args: Array<String>) {

    val lista = mutableListOf("a","b","c")
    lista.add("d")
    lista.add("e")

    println(soma(5,9))

    var pessoa = Pessoa(
        "Diego",
        18,
        true,
        1.83
    )

    println("Nome: ${pessoa.nome}")
    println("Idade: ${pessoa.idade}")
    println(pessoa)

    var funcionario = Funcionario(
        "Manoel",
        23,
        salario = 100.00
    )

    println(funcionario)
}

fun soma(a:Int, b:Int):Int {
    return a+b
}