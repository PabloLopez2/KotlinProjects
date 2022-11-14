package entregados.proyectos
import kotlin.math.ln

//Fet per: Pablo López, Guillem Agullò, Lluc Galceran

var MAX_X = 0
var MAX_Y = 0

fun plotFunction(functionResults: List<Double>): List<List<String>> {//Crea una matriu (llista de llistes) i la itera, comprovant
// en cada iteració i posant el resultat

    val espaibuit = " "

    val matrix = arrayListOf<ArrayList<String>>()

    for (i in 0..MAX_Y * 2) {
        matrix.add(arrayListOf())

        for (j in 0..MAX_X * 2) {
            val y = MAX_Y  - i
            val x = - MAX_X  + j

            if (checkIfResultBelongsToY(y, functionResults[j])) {
                matrix[i].add("*")
            } else if (y == 0) {
                matrix[i].add("_")
            } else if (x == 0) {
                matrix[i].add("|")
            } else {
                matrix[i].add(espaibuit)
            }
            print("  ${matrix[i][j]}")

        }
        println(" ")
    }
    return matrix
}

fun checkIfResultBelongsToY(y: Int, f_x: Double): Boolean {
    return y == f_x.toInt()  //aquesta funció ens trunca el número per que no pinti el punt entre el 0.5 per exemple
}

fun calculateResultsOf(function: (Double) -> Double): List<Double> {// passa cada iteració de 0 a 10 per la funció ens diu el resultat
    val llistay = arrayListOf<Double>()
    for (x in -MAX_X..MAX_X) {
        val y = function(x.toDouble())
        llistay.add(y)
        println("x: $x, y: $y")
    }
    return llistay
}

fun main() {


    println("------------------------------------------------------------------------")
    println("----------------------REPRESENTACIÓ DE FUNCIÓNS-------------------------")
    println("------------------------------------------------------------------------")
    println("Escriu el número de columnes: ")
    MAX_X = readln().toIntOrNull() ?: 0
    println("Molt bé, ara el nomre de files: ")
    MAX_Y = readln().toIntOrNull() ?: 0

    println("\nTaula de valors: ")
    val resultat = calculateResultsOf { x ->
        ln(x)  //És la funció que hem escollit i per la que passen totes les iteracións de proyectos.entregados.proyectos.calculateResultsOf
    }
    println("Gràfic de la funció: ")
    plotFunction(resultat)
    println("\nC acabó")
}


