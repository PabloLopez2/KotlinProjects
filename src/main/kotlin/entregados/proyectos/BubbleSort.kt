fun sortOfGuillemLukeSkywalkerPablo(array: ArrayList<Int>) {
    for (i in 0 until array.size) {
        for (j in i downTo 1) { /*Aquí posem downTo fins a 1 perquè ens agafi les iteracions de llista fins al primer element,
        si no donaria l'error IndexOutOfBounds*/

            val firstElement = array[j]
            val secondElement = array[j - 1]
            if (firstElement < secondElement) {
                swap(array, j, j - 1)
            }
        }
    }
}

fun swap(array: ArrayList<Int>, i: Int, j: Int) { /*
Aquesta funció ens ajuda a cambiar el first element per el second element
*/
    val aux = array[i]
    array[i] = array[j]
    array[j] = aux
}

fun main() {
    val hola = arrayListOf(2, 1, 8, 7, 11, 2, 3, 4, 7, 0, 6, 3)
    sortOfGuillemLukeSkywalkerPablo(hola)
    print(hola)
}

// :: = reflexion, sirve para llamar funciones en una array