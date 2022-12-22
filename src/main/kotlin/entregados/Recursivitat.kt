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
de nombres menors que ell (sumes amb més d'un sumand). [opcional]*/

fun printSummations(n: Int, currentSum: Int, summands: List<Int>) {
    if (currentSum > n) return

    if (currentSum == n) {
        println(summands)
        return
    }

    val start = if (summands.isNotEmpty()) summands.last() + 1 else 1
    for (i in start until n) {
        printSummations(n, currentSum + i, summands + i)
    }
}
/*
La función toma tres parámetros:
    n: el número natural del que queremos obtener las descomposiciones.
    currentSum: la suma actual de los números menores que n.
    summands: la lista de números menores que se han utilizado para llegar a la suma actual.

La función funciona de la siguiente manera:
    1-Si la suma actual es mayor que n, se sale de la función.
    2-Si la suma actual es igual a n, se imprime la lista de números menores que se han utilizado para llegar a la suma y se sale de la función.
    3-Si la suma actual es menor que n, se itera sobre todos los números menores que n y mayores que el último elemento de la lista summands.
    Para cada número, se llama recursivamente a la función con la suma actual aumentada en ese número y la lista summands con ese número
    añadido al final.
 */

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

// Ex 10 Fes una funció que implementi el quick sort.

fun quickSort(list: ArrayList<Int>) {
    if (list.size <= 1) return

    val pivot = list[list.size / 2]
    val lesser = ArrayList<Int>()
    val greater = ArrayList<Int>()

    for (i in list.indices) {
        if (i == list.size / 2) continue
        if (list[i] < pivot) {
            lesser.add(list[i])
        } else {
            greater.add(list[i])
        }
    }

    quickSort(lesser)
    quickSort(greater)

    list.clear()
    list.addAll(lesser)
    list.add(pivot)
    list.addAll(greater)
}

/*
La función toma una lista de enteros y utiliza el método de ordenamiento rápido para ordenarla. El algoritmo funciona dividiendo la lista
en dos partes, una con elementos menores que el pivote y otra con elementos mayores que el pivote. Luego, se llama recursivamente a la
función para ordenar cada una de las dos partes y finalmente se combinan en una sola lista ordenada.
 */

// Ex 11 Fes una funció que implementi el merge sort.
fun mergeSort(list: ArrayList<Int>): ArrayList<Int> {
    if (list.size <= 1) return list

    val middle = list.size / 2
    val left = ArrayList(list.subList(0, middle))
    val right = ArrayList(list.subList(middle, list.size))

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: ArrayList<Int>, right: ArrayList<Int>): ArrayList<Int> {
    val result = ArrayList<Int>()

    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < left.size && rightIndex < right.size) {
        if (left[leftIndex] <= right[rightIndex]) {
            result.add(left[leftIndex])
            leftIndex++
        } else {
            result.add(right[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < left.size) {
        result.add(left[leftIndex])
        leftIndex++
    }

    while (rightIndex < right.size) {
        result.add(right[rightIndex])
        rightIndex++
    }

    return result
}
/*
La función mergeSort toma una lista de enteros y utiliza el método de ordenamiento por mezcla para ordenarla.
El algoritmo funciona dividiendo la lista en dos partes y llamando recursivamente a la función para ordenar cada una de las dos partes.
Luego, se combinan las dos listas ordenadas mediante la función merge.

La función merge combina dos listas ordenadas en una sola lista ordenada mediante el proceso de mezcla.
Se comparan los elementos de cada lista y se añaden al resultado en el orden correcto hasta que se han agotado
los elementos de una de las dos listas.
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
    println("Ex 4: La paraula es palindrom:  ")
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
    println("\nEx 8: Funció busca sumands: ")
    printSummations(10, 0, emptyList())
    println()
    println("\nEx 9: Cerca a quina posició de la llista: 1, 3, 5, 7, 8, 10 es troba el numero 3:")
    println(cerca(3, listOf(1, 3, 5, 7, 8, 10)))

    println("\nEx 10: Implementa la funció quicksort en aquesta llista: 5, 3, 8, 1, 9, 2, 4, 7, 6")
    val list = arrayListOf(5, 3, 8, 1, 9, 2, 4, 7, 6)
    quickSort(list)
    for (i in list){
        print("$i, ")
    }

    println()

    println("\nEx 11: Implemneta la funció mergesort en aquesta llista: 6, 3, 4, 1, 7, 2, 8, 9, 5")
    val list1 = arrayListOf(6, 3, 4, 1, 7, 2, 8, 9, 5)
    val sortedList = mergeSort(list1)
    for (i in sortedList){
        print("$i, ")
    }
}
