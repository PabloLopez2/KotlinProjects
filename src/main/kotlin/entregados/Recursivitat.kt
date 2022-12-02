package entregados

/*NOM DEL GRUP: Monfratelos
COMPONENTS: Pablo, Erik, Guillem
*/

//Ex 1 Fes una funció recursiva que calculi el factorial d’un nombre n,

fun factorial(n: Int): Int {
    if (n == 0 || n == 1) { // Cas base
        return 1
    }

    print("$n, ") // Inducció

    return n * factorial(n - 1)
}

//Ex 2 Fes una funció recursiva que compta el nombre de dígits de n.

fun comptaDigits(n: Int): Int {
    return if (n < 10 && n > -10) {
        1
    } else {
        1 + comptaDigits(n / 10)
    }
}

// Ex 3 Fes una funció recursiva que suma els dígits de n.

fun sumaDigits(n: Int): Int {
    if (n == 0) {
        return 0
    }
    return sumaDigits(n / 10) + n % 10
}

//Ex 4 Fes una funció recursiva que digui si un mot p és palíndrom.

fun esPalindrom2(p: String): Boolean {
    if (p == "" || p.length == 1)
        return true

    if (p.first().lowercase() != p.last().lowercase())
        return false

    // else
    return esPalindrom2(p.drop(1).dropLast(1))

}

//Ex 5 Fes una funció recursiva que li doni la volta a una llista.

fun invert(list: ArrayList<Any>) {
    println(invertRec(list))
}

fun invertRec(list: List<Any>): List<Any> {
    if (list.isEmpty())
        return arrayListOf()
    return invertRec(list.drop(1)) + list.first()
}

/*Ex 6 Una famosa propietat matemàtica diu que un nombre  enter és múltiple de tres si la suma dels seus dígits també és múltiple de tres.
Per exemple, la suma dels dígits de 8472 és 8 + 4 + 7 + 2 = 21, el qual és múltiple de tres. Per tant, 8472 també és múltiple de tres.
Fes una funció recursiva que indiqui si el natural estrictament positiu n és múltiple de    tres o no. */

fun esMultiple3(n: Int): Boolean {
    if (n < 10) {
        return n == 3 || n == 6 || n == 9
    }
    return (esMultiple3(sumaDigits(n)))
}

// Ex 7 Fes una funció recursiva que imprimeix la successió de Fibonacci fins que arriba a imprimir un valor més petit que n.

fun fibonacci(n: Int) {
    fibonacciRecursiu(0, 1, n)
}

fun fibonacciRecursiu(fibo1: Int, fibo2: Int, n: Int) {
    val sumaFibonacci = fibo1 + fibo2
    print("$fibo2, ")
    if (sumaFibonacci >= n) {
        return //CAS BASE
    }

    fibonacciRecursiu(fibo2, sumaFibonacci, n)

}
/*Ex 8 Dissenyeu i implementeu un algorisme que imprimeixi totes les possibles descomposicions d'un nombre natural com a suma
de nombres menors que ell (sumes amb més d'un sumand. [opcional]

fun buscaSumands(n: Int)*/


//Ex 9  Fes una funció recursiva que cerqui un element en una llista que està ordenada i retorna la posició on es troba.

fun cerca(element: Int, list: List<Int>): Int? {
    return cercaRecursiva(element, list, 0, list.size - 1)
}

fun cercaRecursiva(element: Int, list: List<Int>, ini: Int, fin: Int): Int? {
    if (ini == fin) {
        return if (list[ini] == element) { // si a la llista ini hi ha aquest element
            ini //retorna'm l'element
        } else
            null
    }

    val pivoteMedio = (fin + ini) / 2

    return if (list[pivoteMedio] == element) {
        pivoteMedio
    } else if (list[pivoteMedio] > element) {
        cercaRecursiva(element, list, ini, pivoteMedio - 1)
    } else { //if(list[pivoteMedio] < element){
        cercaRecursiva(element, list, pivoteMedio + 1, fin)
    }

    /*if (ini == fin && list[ini] == element)
        return ini
    else if(ini == fin && list[ini] != element)
        return null*/
}
/*
// Ex 10 Fes una funció que implementi el quick sort. (No les sabem fer)
fun quickSort(list: ArrayList<Int>){

}
*/


/*
// Ex 11 Fes una funció que implementi el merge sort. (No les sabem fer)
fun mergeSort(list: ArrayList<Int>){

}
*/

fun main() {

    println("Ex 1: El factorial del numero es: ")
    println(factorial(10))
    println()
    println("Ex 2: Les xifres son: ")
    println(comptaDigits(-33))
    println()
    println("Ex 3: La suma del digits es: ")
    println(sumaDigits(456))
    println()
    println("Ex 4: La paraula es palindrom: ")
    println(esPalindrom2("Reconocer")) //Poner el lowercase porque es key sensitive
    println()
    println("Ex 5: Inverteixme la següent llista: buenas, gente, iepa, company, xd")
    invert(arrayListOf("buenas", "gente", "iepa", "company", "xd"))
    println()
    println("Ex 6: Observa si aquest numero es múltiple de 3")
    println(esMultiple3(sumaDigits(123)))
    println()
    println("Ex 7: Successió de fibonacci: ")
    fibonacci(11500)
    println()
    println("\nEx 9: Cerca a quina posició de la llista: 1, 3, 5, 7, 8, 10 es troba el numero 3:")
    println(cerca(3, listOf(1, 3, 5, 7, 8, 10)))
    println()


}