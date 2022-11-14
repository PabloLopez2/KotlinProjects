

// Components: Pablo López, LLuc Galceran, Guillem Agulló
//*Ex 1 Implementa una funció que calculi el valor absolut d’un nombre. La funció ha de tenir la següent capçalera:

fun absolute(n: Int): Int {
    return if (n >= 0)
        n
    else
        -n //(tambien n * -1)
}

/*Ex 2 Implementa una funció, sense paràmetres ni return, que demana (pel terminal) el
    nom a l’usuari i escriu una salutació que conté el seu nom.*/
fun welcome(){
    val nom = readln()
    println("Hola $nom")
}

/*Ex 3 Implementa una funció que llegeix de l’entrada un nombre enter.
  Si es llegeix un caràcter incorrecte, s'ha de tornar a demanar.*/
fun readInt(): Int {
    var enter = readln().toIntOrNull()
    while (enter == null){
        print("Pon un entero: ")
        enter = readln().toIntOrNull()

    }
    return enter
}

//Ex 4 Implementa una funció que multiplica dos nombres sense fer ús de l’operador
fun multiply(a: Double, b: Int): Double{
var multi = 0.0
  for (i in 1 .. b)  {
      multi += a
  }
  print(multi)
  return multi
}
/* per mutiplicar doubles sense operadors
fun multiplica (a: Double, b: Double): Double{
    return a / (1 / b)
 */


//Ex 5 Mina nombres primers. Apartat A: Fes una funció que, donat un n, diu si és primer o no (casita)

fun isPrime(n: Int): Boolean{
    print("\nPon un nombre y te dire si es primero o no: ")
    val n = readln().toIntOrNull() ?: 0
    var isNotPrim = true

    for (i in 2 until n) {
        if (n % i == 0) {
            println("$n no es un nombre primer")
            isNotPrim = false
        }
    }
    if (!isNotPrim) {
        println("$n es un nombre primer")
    }
return isNotPrim
}

/* Ex 6 Implementa una funció que factoritza iterativament un nombre. La funció rep l’enter a factoritzar
per paràmetre i retorna una llista amb tots els seus divisors ordenats de petit a gran. */

fun factorize(n: Int): List<Int> {

    val result = arrayListOf<Int>()
    var number = n //esto para renombrar la n de la funcion


    for (x in 2 until n - 1) {
        while (number % x == 0) {    //Si la x divideix number
            result.add(x)
            number /= x
        }
        if (number == 1)
            break
    }
    return result
}

/*Ex 7 Implementa una funció que rep per paràmetre un nombre n i retorna true només si n és un nombre perfecte.
Un nombre perfecte és aquell que és igual a la suma de tots els seus divisors positius.*/

fun isPerfect(n: Int): Boolean {
    val divisors = arrayListOf<Int>()

    for (x in 1 until n / 2) {
        if (n % x == 0)
            divisors.add(x)
    }
    var suma = 0
    for (div in divisors) {
        suma += div
    }
    return n == suma
}


fun main() {

    println("Calcularé el valor absolut d'un nombre: ")
    absolute(-4)
    /*També es pot fer: val k = absolute(-4)
                            println(k)*/

    println("Escriu el teu nom: ")
    welcome()

    println("Escriu un nombre enter: ")
    readInt()

    println("Escriu un decimall i un enter i els multiplicare: ")
    multiply(readln().toDouble(), readln().toInt())

    println("Escriu un numero i et dire si es primer o no: ")
    isPrime(readln().toInt())

    println("Hola: ")
    factorize(26)

    println("Hola ")
    isPerfect(28)



}