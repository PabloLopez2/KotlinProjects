package entregados
import kotlin.math.*

fun main() {
    //Ex 1 (nom d'usuari, artista i hobby)
    print("\nEscriu un nom d'usuari: ")
    val usuari = readLine()
    println("\nEscriu un nom d'un artista: ")
    val artista = readLine()
    print("Escriu un hobby teu: ")
    val hobby = readLine()

    println("L'usuari: $usuari, ha escollit l'artista: $artista, i li agrada: $hobby")


    //Ex 2 (multiplicació d'enters)
    print("\nEscriu dos nombres per multiplicar-los")
    print("\nPrimer numero: ")
    val x = readLine()?.toIntOrNull()?:0
    print("\nSegon numero: ")
    val y = readLine()?.toIntOrNull()?:0

    val z = x * y
    println("La Multiplicació de $x y $y dona com a resultat $z ")


    //Ex 3 (calcular la mitjana de 3 nombres)
    print("\nEscriu tres nombres per calcular la mitjana d'aquests")
    print("\nPrimer numero: ")
    val a = readLine()?.toIntOrNull()?:0
    print("\nSegon numero: ")
    val b = readLine()?.toIntOrNull()?:0
    print("\nTercer numero: ")
    val c = readLine()?.toIntOrNull()?:0
    val d = (a+b+c)/3.0
    println("\nEl resultat de la mitjana dels nombres $a, $b i $c es: $d")


    //Ex 4 (Hores, minuts i segons)
    val segons = 6001
    val h = (segons/60) / 60
    val m = segons / 60 - h * 60
    val s = segons - m * 60 - h * 60 * 60

    println("\nAmb 6001 segons obtenim:")
    println("Hores: $h")
    println("Minuts: $m")
    println("Segons: $s")


    //Ex 4 a) (indica dies, mesos i anys) (aquets ho vaig intentar pero es una mica diferent)
    val  segonss = 3939300300
    println("\nAmb $segonss segons, obtenim aquest total de dades:")
    val aa = ((((segonss / 60) / 60) / 24) / 30) / 12
    val me = (((segonss / 60) / 60) / 24) / 30
    val dd = ((segonss / 60) / 60) / 24
    val hh = (segonss / 60) / 60
    val mm = segonss / 60 - h * 60
    val ss = segonss - mm * 60 -hh * 60 - dd * 60 * 60 * 24 - me * 60 * 60 * 24 * 30 - aa * 60 * 60 * 24 * 30 * 12

    println("anys: $aa")
    println("mesos: $me")
    println("dies: $dd")
    println("hores: $hh")
    println("minuts: $mm")
    print("segons: $ss")




    //Ex 5
//resposta: double, double, int, double, string, long, int, string (perquè va entre comes)

    /*Ex 6 Fes un programa que llegeix dos nombres a i b de l’entrada. El programa escriu el resultat
    de la divisió exacta, la divisió entera i el residu de la divisió (ves amb compte amb el cas de la divisó per zero).*/
    println("Ara dividiràs uns nombres")
    print("\nIntrodueix a: ")
    val aao = readln().toIntOrNull()?:0

    print("\nIntrodueix b: ")
    val bbo = readln().toIntOrNull()?:0

    if (b==0)
        print("No es pot dividir entre 0")
    else {

        val ddd = aao / bbo
        val rrr = aao % bbo
        val  exacta = a.toDouble() / bbo.toDouble()

        print("Divisió entera, $ddd, Residu $rrr")
        println("Exacta $exacta")

    }

    //Ex 7 (ecuacion de segundo grado la de +-raiz de b -4 x a x c

    println("Escriu el valor de A de l'equació: ")
    val valueA = readln().toDouble()

    println("Escriu el valor de B de l'equació: ")
    val valueB = readln().toDouble()

    println("Escriu el valor de C de l'equació: ")
    val valueC = readln().toDouble()

    val resultPositive = ((-valueB) + (sqrt(valueB.pow(2) - 4 * valueA * valueC))) / (2 * valueA)
    val resultNegative =  ((-valueB) - (sqrt(valueB.pow(2) -4 * valueB * valueC))) / (2 * valueA)

    print("x1 = $resultPositive, x2 = $resultNegative")


//Residus
    val total = 64674748399


    val hores = total / 3600
    val residu = total % 3600
    val minuts = residu / 60
    val segonsss = residu % 60
    print("h: $hores, min: $minuts, s: $segonsss")

    //Ex 8
    print("\nPon el el precio que quieras: ")
    val precio = readln().toInt()
    val precioIVA = precio * 1.21
    println("El precio que has escrito es: $precio con el 21% de IVA el total es:  $precioIVA")


}

