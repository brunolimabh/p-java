fun main(args: Array<String>) {

    val lista = mutableListOf("a","b","c")
    lista.add("d")
    lista.add("e")

    println(soma(5,9))
}

fun soma(a:Int, b:Int):Int {
    return a+b
}