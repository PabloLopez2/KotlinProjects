package entregados

import kotlin.math.sqrt


fun main() {

    //Ex 1 (apartat a) Escriu una llista de les dues llistes sense repetir els elements
    println("\nAra presentare una llista d'una llista de llistes sense repetir les lletres: ")
    val list1 = arrayListOf("a", "b", "c", "d", "e")
    val list2 = arrayListOf("c", "e", "f")
    val listaUnio = arrayListOf<String>()

    listaUnio.addAll(list1)
    for (element in list2) {
        if (element !in listaUnio) {
            listaUnio.add(element)
        }
    }
    print("$listaUnio")

    //(apartat b) intersecció
    println("Aquí es printa l'intersecció: ")
    val interseccio = arrayListOf<String>()
    for (e1 in list1) {
        for (e2 in list2) {
            if (e1 == e2) {
                interseccio.add(e1)
            }
        }
    }
    print(interseccio)


    //Ex 2 Aquest programa diu si un numero es primer o no, (el vaig fer jo)
    println("Escriu un numero i et dire si es un nombre primero o no: ")
    val numero = readln().toInt()
    var condition = false
    for (item in 2..numero / 2) {
        if (numero % item == 0) {
            condition = true
            break
        }
    }
    if (!condition)
        println("$numero es un nombre primer.")
    else
        println("$numero no es un nombre primer.")


    //Ex 2 (apartat a) Fes un programa que donat un nombre n diu si és primer o no (correccio clase)
    print("\nPon un nombre y te dire si es primero o no (ejemplo clase1): ")
    val numer = readln().toIntOrNull() ?: 0
    var isNotPrim = true

    for (i in 2 until numer) {
        if (numer % i == 0) {
            println("$numer no es un nombre primer")
            isNotPrim = false
        }
    }
    if (!isNotPrim) {
        println("$numer es un nombre primer")
    }


    //Ex 2 (apartat a) Fes un programa que donat un n diu si és primer o no (correccioclase2)
    print("\nPon un nombre y te dire si es primero o no (ejemplo clase2): ")
    val n = readln().toDoubleOrNull() ?: 0.0
    var isNotPrime = false

    for (i in 2..sqrt(n).toInt()) {
        if (n.toInt() % i == 0) {
            println("$n no es un nombre primer")
            isNotPrime = true
            break
        }
    }
    if (!isNotPrime) {
        println("$n es un nombre primer")
    }

    // (apartat b) Fes un programa que donat un enter k, imprimeixi tots els nombres primers entre 1 i k
    print("\nEscribe un numero y te dire todos los numero primeros hasta el que hayas escrito: ")
    val k = readln().toIntOrNull() ?: 0
    for (candidat in 1..k) {
        var isNotPrime1 = false

        for (i in 2 until candidat) {
            if (candidat % i == 0) {
                isNotPrime1 = true
            }
        }
        if (!isNotPrime1) {
            println("$candidat")
        }
    }


    /*Ex 3 Escriu un programa que demani a l'usuari un número sencer i mostri per
    pantalla un triangle rectangle com el de més avall, d'alçada el número introduït.*/

    print("\nEscriu un numero i programare un triangle rectangle: ")
    val altura = Integer.valueOf(readLine())
    var anchura = 1
    for (i in 1..altura) {
        for (j in 1..anchura) {
            print("*")
        }
        print("\n")
        anchura++
    }


    /*Ex 4 (apartat a) Donada una llista de llistes (una matriu), sense usar funcions de Kotlin, fes un programa que
      La imprimeixi per pantalla*/
    println("\nImprimire una llista de llistes")
    val matrix = listOf(
        listOf("a", "b", "c"), listOf("d", "e", "f"), listOf("g", "h", "i")
    )

    val numeroFiles = matrix.size - 1
    val numeroColumnes = matrix[0].size - 1

    for (i in 0..numeroFiles) {
        for (j in 0..numeroColumnes) {
            //println("i : $i")
            //println("j : $j")
            print(" | ${matrix[i][j]}")//columna a columna
            //println("---")
        }//al acabar d'imprimir una fila
        println(" | ")

    }

    //(apartat b) La imprimeixi del reves

    println("\nImprimire una llista de llistes")
    val matrix1 = listOf(
        listOf("a", "b", "c"),
        listOf("d", "e", "f"),
        listOf("g", "h", "i")
    )

    for (i in matrix1.indices) {
        val ri = matrix1.size - 1 - i
        for (j in 0 until matrix1[0].size) {
            val rj = matrix1[0].size - 1 - j
            print(" | ${matrix1[ri][rj]}")
        }
        println(" | ")
    }

    /* Ex 5 Fes un programa que imprimeixi la seqüència de Collatz d’un nombre n donat.
    El programa fa operacions successives fins que arriba a 1. Les operacions que fa, començant pel nombre donat són:*/


    print("Escribe un numero y te hare la secuencia de Collatz: ")
    val n1 = readln().toIntOrNull() ?: 0
    var numero1 = n1

    while (numero1 != 1) {
        if (numero1 % 2 == 0) {
            numero1 /= 2
            println(numero1)
        } else if (numero1 % 2 == 1) {
            numero1 = (3 * numero1) + 1
            println(numero1)
        }
    }


    /*Ex 6 Fes un programa que llegeix diversos números. Per cada número n imprimirà un quadrat de dimensions
     n x n ple de n’s.*/

    print("Escriu un numero i imprimire un quadrat de dimensions del nombre que has posat: ")

    while (true) {
        val nn = readln().toIntOrNull() ?: break

        for (j in 1..nn) {
            for (i in 1..nn) {
                print("$nn")
            }
            println()
        }
    }

    /* Ex 7 Fes un programa que llegeix dos nombres f i c que representen les files i columnes d’una matriu.
    Seguidament,el programa llegirà els valors de la matriu i, un cop tingui totes les dades, ha d’imprimir aquesta
    matriu multiplicada per 2.*/

    print("Introduce el numero de filas: ")
    val nFilas = readln().toInt()

    print("Introduce el numero de columnas: ")
    val nColumna = readln().toInt()

    val matrix3 = arrayListOf<ArrayList<Int>>()

    for (i in 0 until nFilas - 1) {
        matrix3.add(arrayListOf())
        for (j in 0 until nColumna - 1) {
            print("Introdueix el numero: ")
            val numberToAdd = readln().toInt()
            matrix3[i].add((numberToAdd * 2))
        }
    }
    for (fila in matrix3) {
        println(fila)
    }


    /*ex 8 Fes un programa que llegeix dos nombres f i c que representen les files i columnes d’una matriu.
     Seguidament, el programa llegirà els valors de la matriu i, un cop tingui totes les dades.
     Fes que el programa compti els valors de la matriu que hi ha  apartado a   (en total)*/

    println("Inserta el numero de columnas: ")
    val columnas = readln().toIntOrNull() ?: 0
    println("Inserta el numero de filas: ")
    val files = readln().toIntOrNull() ?: 0
    val matrix0 = arrayListOf<ArrayList<Int>>()
    var contador = 0

    for (j in 0 until files) {
        matrix0.add(arrayListOf())
        for (i in 0 until columnas) {
            print("Introduce el contenido: ")
            val element = readln().toIntOrNull() ?: 0
            matrix0[j].add(element)
            contador += element
        }
    }
    println(contador)

    //apartado b (en cada fila)

    println("Ejercicio 8: ")
    val matrixm = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

    val files1 = matrixm.size - 1
    val columnes1 = matrix0[0].size - 1

    for (i1 in 0..files1) {
        var sumafiles = 0

        for (j1 in 0..columnes1) {
            sumafiles += matrixm[i1][j1]
        }
        println("La fila $i1 suma $sumafiles")
    }


    //apartado c    (en cada columna)
    print("Introdueix el primer nombre: ")
    val f = readln().toIntOrNull() ?: 0
    print("Introdueix el segon nombre: ")
    val c = readln().toIntOrNull() ?: 0
    val matrix2 = arrayListOf<ArrayList<Int>>()

    for (i2 in 0 until f) {
        matrix2.add(arrayListOf())
        for (j2 in 0 until c) {
            print("Introdueiz el contingut: ")
            val element1 = readln().toIntOrNull() ?: 0
            matrix2[i2].add(element1)
        }

    }

    for (fila in matrix2)
        print(fila)
    var sumacolumn: Int

    for (i2 in 0 until f) {
        sumacolumn = 0
        for (j2 in 0 until c) {
            sumacolumn += matrix2[j2][i2]
            println("{${i2 + 1}} - $sumacolumn")
        }
    }

    //Apartado d    (En les dos diagonals, només taulers quadrats)
    var z: Int

    var total = 0
    print("Filas: ")
    val y: Int = Integer.valueOf(readLine())
    println()
    print("Columnas: ")
    val x: Int = Integer.valueOf(readLine())
    println()
    val arr = arrayListOf<ArrayList<Int>>()

    for (i3 in 0 until y - 1) {
        arr.add(arrayListOf())
        for (j3 in 1..x) {
            z = Integer.valueOf(readLine())
            arr[i3].add(z)
        }
    }

    val midaMatriu = arr.size

    for (i3 in 0 until midaMatriu) {
        total += arr[i3][i3]
        total += arr[i3][midaMatriu - 1 - i3]
    }
    if (midaMatriu % 2 !== 0) {
        total -= arr[(midaMatriu - 1) / 2][(midaMatriu - 1) / 2]
        println("Quitando la interseccion " + arr[(midaMatriu - 1) / 2][(midaMatriu - 1) / 2].toString())
    }
    println(total)

    /*Ex 9 La lletra del DNI és un dígit de control per verificar que l’identificador és vàlid. La lletra es calcula
   a partir del valor numèric del DNI. Escriu un programa que llegeix múltiples DNIs i verifica si cada un dels DNI (NIF)
   introduïts és correcte a partir de l’algoritme que proporciona el Ministerio del Interior: */

    val a1 = true
    while (a1) {

        print("Introdueix el DNI a verificar (sense la lletra): ")
        var numero01 = readln().toIntOrNull() ?: 0
        val numero2 = numero01
        if (numero01.toString().length == 8) {
            //
        } else {
            println("Valor incorrecte, torna a intentar.")
        }
        numero01 %= 23
        val letras = listOf(
            "T",
            "R",
            "W",
            "A",
            "G",
            "M",
            "Y",
            "F",
            "P",
            "D",
            "X",
            "B",
            "N",
            "J",
            "Z",
            "S",
            "Q",
            "V",
            "H",
            "L",
            "C",
            "K",
            "E"
        )
        println("\nEl teu DNI es $numero2${letras[numero01]}")
        return
    }
}