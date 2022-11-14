import java.lang.IndexOutOfBoundsException

/*Ex 1Copia la següent funció.  Aquesta funció té la particularitat que, de vegades,
 retorna un enter, però d’altres peta i llança una excepció del tipus ArithmeticException. */
fun makeSomeDangerousCalc(): Int {
    val randomNumber = (0..100).random()
    return if (randomNumber > 50) randomNumber
    else throw ArithmeticException()
}

/* a) Fes una altra funció que s’encarregui de cridar aquesta i, en cas d’ejemplo clase.error, retorni -1. */
fun errorA(): Int {
    return try {
        makeSomeDangerousCalc()
    } catch (e: ArithmeticException) {
        -1
    }
}

/* b) Fes una altra funció que cridi aquesta tantes vegades com faci falta fins que el resultat d’aquesta
funció no sigui una Excepció. */
fun errorB(): Int {
    while (true) {
        try {
            return makeSomeDangerousCalc()
        } catch (e: ArithmeticException) {
            println("Resultat Incorrecte")
            continue
        }
    }
}

/*Ex 2 Dissenya una funció que rep una llista d’elements de qualsevol mena i una llista d’índexs. Aquesta ha de
retornar els elements de la primera llista que es troben en les posicions indicades a la llista d’índexs.  */
fun filterByIndex(list: List<Any>, indexs: List<Int?>): List<Any> {
    val resultat = arrayListOf<Any>()
    for (index in indexs) {
        try {
            resultat.add(list[index ?: continue])
        } catch (_: IndexOutOfBoundsException) {

        }
    }
    return resultat
}

/*Ex 3 . Implementa una funció que donada una llista, un índex inicial i un índex final,
retorni la subllista continguda en la primera des del primer índex fins al final. Nota: No es pot fer servir List.sublist()
Si els índexs són incoherents (ini >= end), s’ha de retornar una llista buida.
Si els índexs se surten de la llista, s’ha de retornar només el tros de la llista que és correcte.
Els paràmetres ini i fin han de ser opcionals:
ini = 0
end = {últim índex de la llista}
*/

fun cut(list: List<Any>, ini: Int = 0, end: Int = list.size -1): List<Any> {
    val resultat = arrayListOf<Any>()
    var correctIni = ini
    if (ini < 0){
        correctIni = 0
    }
    try {
        for(i in correctIni .. end){
            resultat.add(list[i])
        }
    }catch (e:ArrayIndexOutOfBoundsException){
        return resultat
    }
    return resultat
}

fun main() {
    print(errorA()) //Ex 1 a)
    println()
    println(errorB()) //Ex 1 b)
    println()
    filterByIndex(listOf(), emptyList())  //Ex 2
    println()
    print(cut(listOf("a", "b", "c", "d"),1, 2)) //Ex 3
}
