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

fun powers(list: List<Int?>): List<Int>{
    return list.filterNotNull().mapIndexed { index, it ->
        (it.toDouble().pow(index)).toInt()
    }
}


/*

 */

fun main() {
    println("Ex 1: ")
    println(dialectalEOf("panas".map { it }))
    println(dialectalOf("Bon dia nois", Dialect.A))
    println("Ex 2: ")
    println(productOfPairs(listOf(1, 2, 3, 4, 5, 6)))
    println("Ex 3")
    println(powers(listOf(1,3,4,5,6,7,8,9,10,11)))


}