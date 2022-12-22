package entregados

fun main() {

    //Ex 1 Aquest programa dona una resposta segon quin numero agafis en l'ambit de nota academica
    print("\nEx 1")
    print("\nIntrodueix la nota acadèmica: ")
    val nota = readln().toIntOrNull() ?: 0

    if (nota < 0.0 || nota > 10)
        println("La nota és incorrecta ")
    if (nota < 5)
        println("Has suspes xd tienes que espabilar ")
    else if (nota == 5)
        println("No has suspes de milagro")
    else if (nota <= 6)
        println("Has tret un bé, guay ")
    else if (nota < 9)
        println("Has tret un Notable, genial")
    else if (nota < 10)
        println("Has tret un excelent, molt bé")
    else if (nota == 10)
        println("Enhorabuena makina, matricula de honor")

//Ex 2 Fes un programa que calcula el màxim entre 3 nombres donats
    print("\nEx 2")
    print("\nEscribe 3 numeros y te diré el más grande ")
    print("\nEscriu el valor d'A: ")
    val a = readln().toDouble()
    print("\nEscriu el valor de B: ")
    val b = readln().toDouble()
    print("\nEscriu el valor de C: ")
    val c = readln().toDouble()

    if (a > b && a > c)
        print("El numero $a és el més gran ")
    else if (b > c)
        print("El numero $b és el mes gran")
    else
        print("El numero $c és el més gran")


//Ex 3 Fes un programa que indica amb <, > i = l’ordre lexicografic de dues paraules.
    print("\nEx 3: ")
    println("Digues dos paraules ")
    println("Primera paraula: ")
    val aa = readln()
    println("Segona paraula: ")
    val bb = readln()

    val aminuscula = aa.lowercase()
    val bminuscula = aa.lowercase()

    if (aminuscula < bminuscula) {
        print("$aa < $bb")
    } else if (aminuscula == bminuscula) {
        print("$aa = $bb")
    } else {
        print("$bb < $aa")
    }

//Ex 4 Fes un programa que llegeix un nombre decimal x i escriu ⌊x⌋ (la part entera inferior), ⌈x⌉
// (la part entera superior) i l’arrodoniment.
    print("\nEx 4")
    print("\nEscribe un numero decimal y te lo redondeare: ")
    val x = readln().toDouble()
    val xInt = x.toInt()

    val up = xInt + 1

    val round = if (x - xInt >= 0.5) {
        up
    } else {
        xInt
    }
    print("\nup: $up, down:  $xInt, round: $round")

//EX loops
//Ex 5 Fes un programa que llegeix un nombre n i escriu tots els nombres entre 0 i n.
    print("\nEx 5")
    var num = 0
    print("\nEscriu un numero qualsevol i t'escriuré tots els números que hi van entre 0 i el que has escrit: ")
    val nn = readln().toInt()

    while (nn != num) {
        num += 1
        println("$num")
    }

//Ex 5 a) Fes que llegeixi un altre nombre enter, m,  i escrigui els nombres entre m i n
    print("\nEx 5")
    print("\nAra escriure els nombres que van del primer nombre que escriguis al segon")
    print("\nIntrodueix el primer nombre: ")
    var nnn: Int = readln().toInt()
    println()
    print("Introdueix el segon nombre: ")
    var mm: Int = readln().toInt()
    println()
    if (mm == nnn) {
        print("Els nombres son iguals!")
    } else {
        if (mm < nnn) {
            while (mm < nnn) {
                print("$mm ")
                mm++
            }
        } else {
            while (nnn < mm) {
                print("$nnn ")
                nnn++
            }
        }
    }


//Ex 6 Fes un programa que llegeix un nombre n i escriu la taula de multiplicar de n

    print("\nEx 6")
    var numero2 = 0
    var resultado: Int
    print("\nEscribe un numero y hare su tabla de multiplicar hasta el 10 ")
    val numero1: Int = readln().toInt()
    while (numero2 < 10) {
        numero2++
        resultado = numero1 * numero2
        println("$numero1 x $numero2 = $resultado")
    }

// Ex 7 Numeros parells
    print("\nEx 7")
    print("\nEscribe un numero par y te dire los que siguen detras: ")


    val numero = readLine()?.toInt() ?: 0

    for (i in 0..numero)
        if (i % 2 == 0) {
            println("$i")
        }

//Ex 8 Juego de numeros random
    print("\nEx 8")

    var modoDeJuego: Int
    var n = -1
    //Escoger modo de juego
    do {
        println("\nElije el modo de juego pulsando la tecla 1 -> Facil // 2 -> Medio // 3-> Dificil: ")
        modoDeJuego = readln().toInt()

        when (modoDeJuego) {
            1 -> {
                println("¡Has elegido el nivel Facil!")
                n = (1..100).random()
            }

            2 -> {
                println("¡Has elegido el nivel Medio!")
                n = (1..1_000).random()
            }

            3 -> {
                println("¡Has elegido el nivel Dificil!")
                n = (1..100_000).random()
            }

            else -> {
                println("Modo de juego no valido")
            }
        }
    } while (modoDeJuego < 1 || modoDeJuego > 3)

    var numeroJugador = -1

    do {
        println("Ultimo numero marcado por el jugador: $numeroJugador")
        numeroJugador = readln().toInt()

        if (numeroJugador > n) {
            println("¡El numero que buscas es MENOR!")
        } else if (numeroJugador < n) {
            println("¡El numero que buscas es MAYOR!")
        }
    } while (numeroJugador != n)
    println("¡Has acertado el numero!, este era el $n")


//Ex 9 Contar nombre de digitos
    print("\nEx 9")

    print("\nIntroduce un numero y te dire cuantos digitos tiene: ")

    var nu = readln().toInt()
    var s = 0

    // Cas llegir nombre zero
    if (nu == 0)
        s = 1

    while (nu != 0) {
        nu /= 10
        s += 1
    }
    print("En total hay $s digitos")


    //Ex 10 Xifratge de Cesar
    print("\nEx 10")
    print("\nEscribe una frase y te haré el cifrado de cesar: ")
    val text = readln()
    val xifratge = 3

    for (lletra in text) {
        val lletraXifrada = 'a' + (lletra + xifratge - 'a') % 26
        print(lletraXifrada)
    }

    //Ex 11 Cifra palabras que escribas, hay diferentes maneras de hacer el programa

    print("\nEx 11")
    print("\nPon una palabra que quieres cifrar: ")
    val bannedWords = listOf("hola", "gato", "enti")
    val palabraUsuario = readln()
    val frase = palabraUsuario.split(" ")
    var resultatFrase = " "

    for (paraula in frase) {
        resultatFrase += if (!(paraula.toIntOrNull() != null || paraula in bannedWords)) {
            " xxx "
        } else {
            "$paraula "
        }
    }

    print("\nla palabra cifrada es: ")
    print(resultatFrase)


    //Ex 11.2
    print("\nEx 11.2")
    print("\nPon una palabra que quieres cifrar: ")
    val bannedWord = listOf("hola", "gato", "enti")
    val palabUsuario = readln()
    val fras = palabUsuario.split(" ")
    var resultatFras = " "

    for (paraula in fras){
        resultatFras += if (paraula.toIntOrNull() == null || paraula in bannedWord){
            " xxx "
        } else{
            "$paraula "
        }
    }

    print("\nla palabra cifrada es: ")
    print(resultatFras)


    //Ex 11.5 (altra manera de fer-ho)

    print("\nEx 11.5")
    print("\nPon una palabra que quieres cifrar, recuerda que aqui solo se cifran numeros: ")
    val palabrUsuario: CharArray = readln().toCharArray()

    palabrUsuario.toString()

    for (i in palabrUsuario.indices) {
        if (palabrUsuario[i] == '1' || palabrUsuario[i] == '2' || palabrUsuario[i] == '3' || palabrUsuario[i] == '4' || palabrUsuario[i] == '5' || palabrUsuario[i] == '6' || palabrUsuario[i] == '7' || palabrUsuario[i] == '8' || palabrUsuario[i] == '9' || palabrUsuario[i] == '0')
            palabrUsuario[i] = 'x'

    }

    print("La palabra ahora ya cifrada es: ")
    println(palabrUsuario)



    //Ex 12 Aqui podras dir en quina coordenada et trobes amb les lletres determinades
    print("\nEx 12")
    var xx = 0
    var y = 0
    print("\nMou utilitzant les lletres n, s, e, o")
    print("\nIntrodueix la proxima posicio (0,0): ")
    val moviments = readln()

    for (moviment in moviments){
        when (moviment) {
            'n' -> { y++ }
            's' -> { y-- }
            'e' -> { xx-- }
            'o' -> { xx-- }
            else -> { print("Valor incorrecte") }
        }
    }
    print("\n($xx, $y)")

}