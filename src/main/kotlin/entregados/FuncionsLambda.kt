package entregados

import kotlin.math.pow

/* Ex 1: Escriu una funció que calculi canviï totes les vocals d’una frase per la lletra “e”.
fun dialectalEOf(sentence: List<Char>): List<Char>
a) Implementa la funció. */

fun dialectalEOf(sentence: List<Char>): List<Char> {
    val vocalsList = listOf('a', 'e', 'i', 'o', 'u')
    val sentenceWithE = sentence.map {

        if (it in vocalsList) {
            'e'
        } else {
            it
        }
    }
    return sentenceWithE
}

/* b) Implementa una altra funció, més genèrica, que substitueixi totes les vocals per una en concret.
El paràmetre dialect ha de ser una enum class que permet discernir per quina vocal se substituirà la frase. */

enum class Dialect(val vocal: Char) {
    A('a'), E('e'), I('i'), O('o'), U('u')
}

fun dialectalOf(sentence: String, dialect: Dialect): String {
    val vocalsList = listOf('a', 'e', 'i', 'o', 'u')
    val sentenceWithVocal = sentence.map {

        if (it in vocalsList) {
            dialect.vocal
        } else {
            it
        }
    }
    return String(sentenceWithVocal.toCharArray())
}

/*Ex 2: Escriu una funció que calculi el producte dels nombres parells d’una llista.
fun productOfPairs(list: List<Int>): Double*/

fun productOfPairs(list: List<Int>): Double {
    return list.filter { it % 2 == 0 }.reduce { acc, it ->
        acc * it
    }.toDouble()
}

/* Ex 3: Una funció rep una llista de Int que poden ser null. L’objectiu és calcular la potència de cada nombre elevat al seu índex.
Per exemple, si la llista conté el número 10 a la posició 2, a la llista resultant hi haurà d’haver un 100 a la posició 2.
fun powers(list: List<Int?>): List<Int>*/

fun powers(list: List<Int?>): List<Int> {
    return list.filterNotNull().mapIndexed { index, it ->
        (it.toDouble().pow(index)).toInt()
    }
}

/*Ex 4: Implementa una funció que indiqui si dues llistes són iguals
(tenen exactament els mateixos elements en la mateixa posició). Podeu fer servir la capçalera que preferiu .*/

fun <E> equals(l1: List<E>, l2: List<E>): Boolean {
    l1.zip(l2) { e1, e2 ->
        if (e1 != e2) {
            return false
        }

    }
    return true
}

/* Altre manera de fer el Ex4:*/

fun <E> equals2(l1: List<E>, l2: List<E>): Boolean {
    if (l1.size != l2.size) {
        return false
    }
    return l1.zip(l2) { e1, e2 ->
        e1 == e2
    }.any { !it }
}

/* Ex 5: Implementa una funció que indiqui si dues llistes contenen els mateixos elements (tenen els mateixos elements,
tot i que no importa si estan en el mateix ordre ni repetits). Podeu fer servir la capçalera que preferiu. */

fun <E> similar(l1: List<E>, l2: List<E>): Boolean {
    return l1.all { l2.contains(it) } && l2.all { l1.contains(it) }
}


/*Ex 8: Una funció rep dos nombres i una funció lambda amb la següent capçalera:
Fes que la funció anonymousMathOperation retorni el resultat d’aplicar la funció lambda operation sobre els nombres a i b.
Utilitza la funció anonymousMathOperation que acabes d’implementar i proposa 3 exemples de crides variant el paràmetre operation. */
fun anonymousMathOperation(a: Int, b: Int, operation: (Int, Int) -> Double): Double {
    return operation(a, b)
}


fun main() {
    println("\nEx 1: ")
    println(dialectalEOf("panas".map { it }))
    println(dialectalOf("Bon dia nois", Dialect.A))
    println(dialectalOf("Bon dia nois", Dialect.E))
    println(dialectalOf("Bon dia nois", Dialect.I))
    println(dialectalOf("Bon dia nois", Dialect.O))
    println(dialectalOf("Bon dia nois", Dialect.U))
    println("\nEx 2: ")
    println(productOfPairs(listOf(1, 2, 3, 4, 5, 6)))
    println("\nEx 3: ")
    println(powers(listOf(1, 3, 4, 5, 6, 7, 8, 9, 10, 11)))
    println("\nEx 4: ")
    println(equals(listOf(1, 2, 3, 4), listOf(1, 3, 4)))
    println(equals2(listOf(0, 1, 3), listOf(0, 1, 2)))
    println("\nEx 5: ")
    println(similar(listOf(1, 2, 3), listOf(1, 2, 4)))
    println("\nEx 8: ")
    println(anonymousMathOperation(3, 6) { a, b ->
        a * b.toDouble()
    })

}