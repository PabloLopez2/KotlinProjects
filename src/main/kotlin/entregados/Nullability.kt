package entregados
/* Ex 1 Donades les següents variables. (NO PODEM UTILITZAR n==null)
a) Indica’n el tipus i si pot ser o no nul·la
                                Sol·lució:
var n: Int? = null              Si
var s = "21"                    No (string)
val i = 203                     No (int)
var j: Int? = 408               Si
val l1 = listOf(1, null, 2)     Si (list<Int?>)
val l2 = listOf(1, 5, 2)        No (list<Int>)

b) Escriu el resultat de les següents instruccions, si aquestes compilen.
En cas contrari, proposa una correcció per tal que s’executin.
                Sol·lució:
n?.plus(i)      ignora la funció plus i tota la funció val null
n ?: 0          Da 0
(n ?: 0) + 3    Da 3
n + i           null + 203 = Peta
i + j           (n?:0) + i = 203
s + n           Da "21null"  s + (n?:"")
l1[2] + 3       No compila, (l1[2]?:0) +3
l2[2] + 3       Da 5 (pq es el segon element de la llista (2))      */

// Ex 2 Escriu una funció que donats dos Int?, en retorni la suma. Els paràmetres nuls valen 0.

fun nullSafetySum(a: Int?, b: Int?): Int {
    return (a ?: 0) + (b ?: 0) //Si es null agafem un 0, si no, agafem a o b
}

/* Ex 3 Escriu una funció que rep per paràmetre una llista que pot ser nul·la i pot contenir enters nuls.
Aquesta funció ha de retornar la mitjana aritmètica sense tenir en compte els valors nuls.
Si la llista és nul·la, el resultat ha de ser zero.     */

/*Exemple:
val s = "hola"
val m = s.toIntOrNull() //Retorna un null si no poso un int
val n = s.toInt()       //Peta si no hi poso un int     */

fun nullSafetyAverage(list: List<Int?>?): Double {
    /* if (list == null) //Aquest es excepció, es comparació evident i precisa
         return 0.0      */
    list ?: return 0.0

    var suma = 0.0
    var count = 0

    for (element in list) { //elem : Int ?
        suma += element ?: 0
        element ?: continue //passa a la següent iteració del bucle
        ++count
    }
    return suma / count
}

/* Ex 4 Escriu una funció que rep per paràmetre una llista que pot ser nul·la i pot contenir enters nuls.
Si la llista o qualsevol dels elements és nul, el resultat ha de ser nul, altrament ha de retornar
la mitjana aritmètica dels seus valors.     */
fun nullControlAverage(list: List<Int?>?): Double? {
    list ?: return 0.0
    var suma = 0.0

    for (elem in list) {
        suma += elem ?: return null
    }
    return suma / list.size
}

/* Ex 5 Escriu una funció que rep una llista que pot contenir enters nuls i imprimeix per pantalla només
els nombres senars. */
fun printOnlyOdds(list: List<Int?>) {

    for (element in list) {
        if ((element?.rem(2) ?: 0) != 0) {  //rem = remainder %
            print("$element ")
        }
    }
}

// Ex 6 Escriu una funció que substitueix els valors nuls per valors aleatoris d’una matriu (llista de llistes)
fun replaceNulls(matrix: List<List<Int?>>): List<List<Int>> {
    val matrix2 = arrayListOf<ArrayList<Int>>()
    for (i in 0 until matrix.size) {

        matrix2.add(arrayListOf())

        for (j in 0 until matrix[0].size) {

            matrix2[i].add(matrix[i][j] ?: (0..99).random())
        }
    }
    return matrix2
}

fun main() {
    println(nullSafetySum(2, null)) //Ex 2
    val r = nullSafetyAverage(listOf(1, 2, 3, 4, null, 5)) //Ex 3
    println(r)
    nullControlAverage(listOf(1, 2, 3, 4, null, 6, 7)) //Ex 4
    printOnlyOdds(listOf(1, 2, null, 3, 4, 5)) //Ex 5
    val m = listOf(   //Ex 6
        arrayListOf(1, null, 3),
        arrayListOf(null, null, 3),
        arrayListOf(1, 2, null)
    )
    println(replaceNulls(m))
}

