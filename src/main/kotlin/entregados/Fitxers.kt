@file:JvmName("FitxersKt")

package entregados

import java.io.File

//Ex 1: Fes una funció que escrigui les taules de multiplicar de l’1 al 10 en un fitxer anomenat “taules.txt”.

fun multiplicarTaules() {

    val nums = listOf(1,2,3,4,5,6,8,9,10)

    val file = File("taules.txt").bufferedWriter()
    file.use {
        for (table in 0 .. 10) {
            val tittle = "Taula del $table\n"
            it.write(tittle)
            for (num in nums) {
                val product = table * num
                val operation = "$table * $num = $product\n"
                it.write(operation)
            }
        }
    }
}

/*2 Fes una funció que llegeixi el fitxer “taules.txt”, que conté les taules de multiplicar de l’1 al 10
i es guarda la informació ben ordenada en un objecte de tipus List<List<String>>.*/

fun llegirTaules(): List<List<String>> {
    val file = File("taules.txt").bufferedReader()
    val lines = file.readLines()
    val tables = arrayListOf<List<String>>()
    var table = arrayListOf<String>()
    for (line in lines) {
        if (line.isEmpty()) {
            tables.add(table)
            table = arrayListOf()
        } else {
            table.add(line)
        }
    }
    if (table.isNotEmpty()) {
        tables.add(table)
    }
    return tables
}

/*Ex 3: Implementa el següent procés
Llegir el text contingut al fitxer “text.inp”.
Inverteix cada frase del text (separades amb un punt i un espai “. “). Per exemple, la frase “hey col·lega com va?. ”
ha de quedar “?av moc agel·loc yeh. ”
Les frases resultants s’han d’escriure en un fitxer anomenat “text.out”*/


fun invertirFrases() {

    val inputFile = File("text.inp")
    inputFile.createNewFile()
    val input = File("text.inp").bufferedReader()
    val outputFile = File("text.out").bufferedWriter()

    input.use { input1 ->
        outputFile.use { output ->
            input1.forEachLine { line ->
                val frases = line.split(". ")
                val frasesInvertidas = frases.map { frase -> frase.reversed() }
                val lineaInvertida = frasesInvertidas.joinToString(" ") + "\n"
                output.write(lineaInvertida)
            }
        }
    }
}




fun main() {

    multiplicarTaules()
    llegirTaules()
    invertirFrases()
}
