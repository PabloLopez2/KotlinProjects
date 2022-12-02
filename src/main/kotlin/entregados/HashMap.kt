//Ex 1
fun main() {
    do {
        print("Escribe la palabra que quiere analizar: ")
        val palabra = readln().lowercase()

        val emptyMap = hashMapOf<Char, Int?>()

        for (c in palabra) {
            if (c.code >= 'a'.code && c.code <= 'z'.code) {
                emptyMap[c] = (emptyMap[c] ?: 0) + 1
            }
        }
        println(emptyMap)
    } while (palabra != "#")

    val hash = hashMapOf<Int, String>()
    var contador = 0

//Ex 2

    while (true) {

        println("Pulsa 1 para añadir, 2 para buscar usuario, 3 para eliminar, 4 para ver lista de usuarios")
        val opcion = readln().toInt()

        if (opcion == 1) {
            println("Introduce el nombre de usuario a añadir")
            val usuario = readln()
            hash[contador] = usuario
            println(hash)
            contador += 1
        }

        if (opcion == 2) {
            println("Introduce el expediente del usuario")
            val expediente = readln().toInt()
            if (expediente in hash)
                println(hash[expediente])
        }

        if (opcion == 3) {
            println("Introduce el usuario a eliminar")
            val eliminado = readln().toInt()
            hash.entries.removeIf {
                eliminado in hash
            }
        }

        if (opcion == 4) {
            println(hash)
        }

        if (opcion == 5) {
            println("Cerrando el programa")
            break
        }
    }

//Ex 2 (Altre manera de fer-ho)
    val myhashmap =
        hashMapOf<Int, String>( //Declarem el mapa amb tots els alumnes i tots els números d'expedients.
            1 to "Guillem",
            2 to "Pablo",
            3 to "lluc",
            4 to "Erik",
            5 to "Aty",
            6 to "Toni"
        )
    print("Bona tarda i venvingut al meu programa. \n Aquí hi ha un llistat d'alumnes assignats a un número d'expedient: ")
    do { //la clausula do while ens executa una sentència mentres elecció no sigui igual a 9
        print("\n \n Veure tots els usuaris i els seu número d'expedients? - 1 \n Introduïr un nou usuari? - 2 \n Saber el nom del alumne ficant el número d'expedient? - 3 \n Eliminar Un alumne del sistema? - 4 \n Tancar el programa sense dir adéu? - 9 \n ")

        val eleccio = readln().toIntOrNull() ?: 0  //aquesta variable serveix per escollir quina funció volem que faci el nostre programa.

        when (eleccio) {
            1 -> {  //Si elecció és 1, imprimim el hashmap tal qual.
                print(myhashmap)
            }
            2 -> { //Si elecció és 2, li diem a l'usuari que posi un nom i ens assigna un número d'expedient a aquell nom.
                print("Posa el nom del alumne que vulguis introduïr:\n")

                myhashmap[myhashmap.size + 1] = readln()

                print(myhashmap[myhashmap.size])

                print(" Ha estat introduïda amb el número d'expedient: ")

                print(myhashmap.size)
            }
            3 -> { //Li demanem a l'usuari que introdueixi un número d'expedient i imprimim el contingut d'aquest número dintre del hashmap.

                println("Introdueix un número d'expedient: \n")

                val numexp = readln().toIntOrNull()
                print("El número d'expedient $numexp correspon al alumne: ")
                print(myhashmap[numexp])

            }
            4 -> {  //Li demanem a l'usuari que introdueixi un número d'expedient i eliminem el contingut en aquella posició dintre del hashmap.
                println("Escriu el número d'expedient del alumne que vols eliminar: ")
                val numelim = readln().toIntOrNull()
                myhashmap.remove(numelim)
                println("Alumne eliminat.")
            }
        }

    } while (eleccio != 9)

    println("\n Goodbye")   // Diem avêu!
}




