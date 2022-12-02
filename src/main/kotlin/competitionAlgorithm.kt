const val NUMBER_OF_TESTS = 10
const val N_ELEMENTS = 1000000

val participants = arrayListOf(
    ::winner,
    ::loser,
)

fun main() {
    // Tests de robustesa i fiabilitat
    testCorrectnessAndRobustness()

    // Provem la rapidesa
    testQuickness()
}

fun testCorrectnessAndRobustness() {
    val zeroTest = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).shuffled()
    val expectedResult = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    participants.removeIf { algorithm ->
        try {
            roundCorrectness(algorithm, clone(zeroTest))
        } catch (e: Exception) {
            println("Algorithm ${algorithm.name} has produced the exception: $e")
            println("For this reason, it has been disqualified!")

            askContinue()
            return@removeIf true // Remove
        }

        val isAlgorithmCorrect = roundCorrectness(algorithm, clone(zeroTest), expectedResult)
        if (!isAlgorithmCorrect) {
            println("Algorithm ${algorithm.name} hasn't pass the correctness test. The result is not sorted!")
            println("For this reason, it has been disqualified!")

            askContinue()
            return@removeIf true // Remove
        }

        false// Aproved
    }

    println("The competition will start with the following participants!")
    println(participants.map { it.name })
    askContinue()
}

fun testQuickness() {
    // Creem llistes de nombres aleatoris que farem servir per ordenar
    val tests = List(NUMBER_OF_TESTS) {
        List(N_ELEMENTS) {
            (-N_ELEMENTS..N_ELEMENTS).random()
        }
    }

    // Creem una matriu per annotar els resultats
    val results = List(participants.size) { arrayListOf<Long>() } as ArrayList

    tests.forEachIndexed { number, test ->
        println("\n=====================")
        println("Starting TEST $number")
        println("=====================\n")

        participants.forEachIndexed { n, algorithm ->
            val mark = roundTime(algorithm, test)
            results[n].add(mark)

            println("Algorithm ${algorithm.name} has achieved a mark of $mark")
        }
    }

    askContinue()

    println("\n**********************")
    println("CLASSIFICATION")
    println("**********************\n")
    results.map { it.average() }.sorted().forEachIndexed { pos, time ->
        println("At position ${pos + 1} algorithm ${participants[pos].name} with average time of $time millis")
    }

    println("\nSo that, ${participants[0].name} has won +0.5 :)")
}

// FUNCIONS AUXILIARS

fun clone(array: List<Int>) = array.map { it }

fun roundCorrectness(
    sortingAlgorithm: (ArrayList<Int>) -> Unit,
    test: List<Int>,
    correction: List<Int> = listOf()
): Boolean {

    // Invoke sort
    sortingAlgorithm(test as ArrayList)

    // Comprovem que la llista ha quedat ben ordenada
    return test.zip(correction) { e1, e2 ->
        e1 == e2
    }.fold(true) { acc, b -> acc && b }
}

fun roundTime(sortingAlgorithm: (ArrayList<Int>) -> Unit, test: List<Int>): Long {
    val start = System.currentTimeMillis()

    // Invoke algorithm with a clone of test
    // (to avoid sort the original)
    sortingAlgorithm(clone(test) as ArrayList)

    return System.currentTimeMillis() - start
}

fun askContinue() {
    println("\nContinue? [press enter]")
    readln()
}

// ==========================================================
//                    ALGORITMES
// ==========================================================

fun winner(array: ArrayList<Int>) =
    array.sort()


fun loser(array: ArrayList<Int>) {
    array.sort()
    Thread.sleep(100)
}