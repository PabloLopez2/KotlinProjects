package entregados.proyectos

fun generacionDelMapa (matrix1 :ArrayList<ArrayList<Char>>, matrix2 :ArrayList<ArrayList<Char>>, f: Int, c: Int) {

    // GENERAMOS EL MAPA CON EL NUMERO DE COLUMNAS Y FILAS ESTABLECIDO ANTERIORMENTE
    // ASIGNAMOS TAMBIEN A LA SEGUNDA MATRIZ LA MISMA ESTRUCTURA I RESULTADOS QUE LA MATRIZ 1
    for ( i in 0 .. f +1){
        matrix1.add(arrayListOf())
        matrix2.add(arrayListOf())
        for ( j in 0 .. c +1){ // LOS BORDES
            if (i == 0){
                matrix1[i].add('#')
                matrix2[i].add('#')
            }
            else if (i == f +1){
                matrix1[i].add('#')
                matrix2[i].add('#')
            }
            else if (j == 0){
                matrix1[i].add('#')
                matrix2[i].add('#')
            }
            else if (j == c+1){
                matrix1[i].add('#')
                matrix2[i].add('#')
            }
            else { // LO DEMAS
                val number = 0..2
                val randomNumber = number.random()
                if (randomNumber == 0) { //33.33% viva
                    matrix1[i].add('0')
                    matrix2[i].add('0')
                }else if (randomNumber == 1 || randomNumber == 2) { //66.66% muerta
                    matrix1[i].add('.')
                    matrix2[i].add('.')
                }
            }
            //0 = vivo, . = muerto
        }

    }

}

fun reproduction(matriz1 :ArrayList<ArrayList<Char>>, matriz2 :ArrayList<ArrayList<Char>>, f: Int, c: Int): ArrayList<ArrayList<Char>> {

    for (i in 1..f){
        for (j in 1..c){
            if (vida(matriz1, i, j) && matriz1[i][j] == '.'){
                matriz2[i][j] = '0'
            }
            if(muerte(matriz1, i, j) && matriz1[i][j] == '0'){
                matriz2[i][j] = '0'
            }
            if(!muerte(matriz1, i, j) && matriz1[i][j] == '0'){
                matriz2[i][j] = '.'
            }
        }
    }
    combinarMatrius(matriz2, matriz1, f, c) // PARA QUE LA MATRIZ 1 SEA IGUAL QUE LA 2 UNA VEZ SE HAYA REALIZADO TODO EL PASO DE REPRODUCCION
    return matriz2
}

fun muerte(matriz1 :ArrayList<ArrayList<Char>>, PosI: Int, PosJ: Int): Boolean{

    var contadorCelulesVives = -1 // LO PONEMOS A -1 PQ SINO TAMBIEN SE CONTARIA A EL MISMO A LA HORA DE HACER EL BUCLE

    for (i in PosI - 1..PosI + 1){
        for (j in PosJ - 1..PosJ + 1){
            if (matriz1[i][j] == '0') {
                contadorCelulesVives++
            }
        }
    }

    return contadorCelulesVives == 2 || contadorCelulesVives == 3
}

fun vida(matriz1 :ArrayList<ArrayList<Char>>, PosI: Int, PosJ: Int): Boolean{
    var contadorCelulesVives = 0

    for (i in PosI - 1..PosI + 1){
        for (j in PosJ - 1..PosJ + 1){
            if (matriz1[i][j] == '0') {
                contadorCelulesVives++
            }
        }
    }

    return contadorCelulesVives == 3

}

fun combinarMatrius(matrizValoresOk:ArrayList<ArrayList<Char>>, matrizValoresAModificar :ArrayList<ArrayList<Char>>, f: Int, c: Int){

    for(i in 0..f+1)
        for(j in 0..c+1)
            matrizValoresAModificar[i][j] = matrizValoresOk[i][j]

}

fun main(){
    // VARIABLES GLOBALES MATRICES
    val matrix1 = arrayListOf<ArrayList<Char>>()
    val matrix2 = arrayListOf<ArrayList<Char>>()

    println("Bienvenido al Juego de la vida")

    // PEDIMOS AL USUARIO NUMERO DE FILAS
    print("¿Cuantas FILAS quieres para el juego?: ")
    val f = readln().toIntOrNull() ?: 0

    // PEDIMOS AL USUARIO NUMERO DE COLUMNAS
    print("¿Cuantas COLUMNAS quieres para el juego?: ")
    val c = readln().toIntOrNull() ?: 0

    generacionDelMapa(matrix1, matrix2, f, c) // ESTA FUNCION GENERA LAS 2 MATRICES

    //REPRODUCIR MUNDO 2 EN BONITO
    var contador = 0
    var nextDay:Int

    do {
        //print matrix (O = live // . = death)
        println("--MUNDO-- Day $contador")
        for(i in 0 until matrix2.size){
            for(j in 0 until matrix2[0].size){
                print("| ${matrix2[i][j]} ")
            }
            println("|")
        }


        var contadorvivas = 0
        for(i in 0 until matrix2.size){
            for(j in 0 until matrix2[0].size)
                if(matrix2[i][j] == '0')
                    contadorvivas++}

        println("Hoy dia $contador hay: $contadorvivas celulas vivas")

        var contadormuertas = 0
        for(i in 0 until matrix2.size){
            for(j in 0 until matrix2[0].size)
                if(matrix2[i][j] == '.')
                    contadormuertas++}

        println("Hoy dia $contador hay: $contadormuertas celulas muertas")


        println("Pulsa enter para pasar un frame de tu mundo o escribe 1 para finalizar")
        contador += 1
        reproduction(matrix1, matrix2, f, c)
        nextDay = readLine()!!.toIntOrNull() ?: 0

    } while ( nextDay != 1)
    println("Aqui se acaba el juego de la vida")
}