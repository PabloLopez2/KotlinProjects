package entregados

fun main() {
//Ex 1 Aquest programa conta les vocals que te la frase que escriguis
    print("Escribe una palabra y te dire cuantas vocales tiene: ")
    val palabra = readLine()
    var a = 0
    var e = 0
    var i = 0
    var o = 0
    var u = 0
    if (palabra is String) {
        for (character in palabra.toString()) {
            var charac = character.toString()
            charac = charac.lowercase()
            if (charac == "a") {
                a++
            }
            if (charac == "e") {
                e++
            }
            if (charac == "i") {
                i++
            }
            if (charac == "o") {
                o++
            }
            if (charac == "u") {
                u++
            }
        }
        println("Hay $a As")
        println("Hay $e As")
        println("Hay $i As")
        println("Hay $o As")
        println("Hay $u As")
    }
    // Ex2 Escriu el numero mes gran i mes petit i els separa del hash

    val stop = "#"
    val elemento = arrayListOf("180.5", "5.6", "1.5", "6.8", "22.1", "2.3", "12.8", "1000.3", stop, "7.3", "3.4")

    var numero = 0
    var max = elemento[0]
    var min = elemento[0]

    while (elemento[numero] != stop) {

        if (elemento[numero + 1] == stop) {
            break
        } else {
            if (max.toDouble() < elemento[numero + 1].toDouble()) {
                max = elemento[numero + 1]
            }
            if (min.toDouble() > elemento[numero + 1].toDouble()) {
                min = elemento[numero + 1]
            }
        }

        numero++
    }

    println("El precio maximo es: $max")
    println("El precio minimo es: $min")

    var precioInverso = elemento.size - 1
    println("Lista de precios al reves: ")
    while (precioInverso >= 0) {
        print("${elemento[precioInverso]}, ")
        precioInverso--
    }

    //Ex 3 Llista elements per comes

    val elements = listOf("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne")

    println("\nThe periodic table contains the following elements:")

    for (elem in elements) {
        print("$elem, ")
    }


    //Ex 4 Digues si es un palindrom


    var palabr = readLine().toString().lowercase().filter { !it.isWhitespace() }
    val orig = palabr
    palabr = palabr.reversed()
    print(palabr)
    if (palabr == orig) {
        println("$palabr es un palindrom")
    } else {
        println("$palabr no es un palindrom")
    }


    // Ex5 Programa que retorna la millor i pitjor nota que has tret en les seguents assignatures

    val asignatures = listOf("Matematiques", "Fisica", "Quimica", "Historia", "Llengua")

    val notes = arrayListOf("0.0", "0.0", "0.0", "0.0", "0.0")
    var num = 0
    println("\nA continuacion escribiras las notas de las siguientes asignaturas: ")

    while (num < notes.size) {
        print("\nEscribe la nota de ${asignatures[num]} con decimal: ")
        notes[num] = readln()

        num++
    }

    var millorNota = notes[0]
    var pitjorNota = notes[0]

    var indexMillorNota = 0
    var indexPitjorNota = 0

    num = 0
    while (num < notes.size) {
        println("A ${asignatures[num]} has tret un ${notes[num]}")
        if (num < notes.size - 1) {
            if (millorNota.toDouble() < notes[num + 1].toDouble()) {
                millorNota = notes[num + 1]
                indexMillorNota = num + 1
            }
            if (pitjorNota.toDouble() > notes[num + 1].toDouble()) {
                pitjorNota = notes[num + 1]
                indexPitjorNota = num + 1
            }
        }
        num++
    }

    println("La mejor nota de la asignatura es: ${asignatures[indexMillorNota]}, con un ${notes[indexMillorNota]}")
    println("La peor nota de la asignatura es: ${asignatures[indexPitjorNota]}, con un ${notes[indexPitjorNota]}")


    //Ex 6 Succesio de Fibonacci


    val n = 20
    var t1 = 0
    var t2 = 1

    print("\nFirst $n terms: ")

    for (it in 1..n) {
        print("$t1 + ")

        val sum = t1 + t2
        t1 = t2
        t2 = sum
    }

}










