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

    val myhashmap =
        hashMapOf<Int, String>(      //Declarem el mapa amb tots els alumnes i tots els números d'expedients.
            1 to "Guillem",
            2 to "Pablo",
            3 to "lluc",
            4 to "Erik",
            5 to "Aty",
            6 to "Toni"
        )
    print("Bona tarda i venvingut al meu programa ronyós: \n Aquí hi ha un llistat d'alumnes assignats a un número d'expedient: ")
    do { //la clausula do while ens executa una sentència mentres elecció no sigui igual a 9
        print("\n \n Veure tots els usuaris i els seu número d'expedients? - 1 \n Introduïr un nou usuari? - 2 \n Saber el nom del alumne ficant el número d'expedient? - 3 \n Eliminar Un alumne del sistema? - 4 \n Tancar el programa sense dir adéu? - 9 \n ")

        val eleccio = readln().toIntOrNull()
            ?: 0                //aquesta variable serveix per escollir quina funció volem que faci el nostre programa.
        if (eleccio == 1) {                                         //Si elecció és 1, imprimim el hashmap tal qual.

            print(myhashmap)

        } else if (eleccio == 2) {                                   //Si elecció és 2, li diem a l'usuari que posi un nom i ens assigna un número d'expedient a aquell nom.

            print("Posa el nom del alumne que vulguis introduïr:\n")

            myhashmap[myhashmap.size + 1] = readln()

            print(myhashmap[myhashmap.size])

            print(" Ha estat introduïda amb el número d'expedient: ")

            print(myhashmap.size)

        } else if (eleccio == 3) {                                   //Li demanem a l'usuari que introdueixi un número d'expedient i imprimim el contingut d'aquest número dintre del hashmap.

            println("Introdueix un número d'expedient: \n")

            val numexp = readln().toIntOrNull()
            print("El número d'expedient $numexp correspon al alumne: ")
            print(myhashmap[numexp])

        } else if (eleccio == 4) {                                   //Li demanem a l'usuari que introdueixi un número d'expedient i eliminem el contingut en aquella posició dintre del hashmap.
            println("Escriu el número d'expedient del alumne que vols eliminar: ")
            val numelim = readln().toIntOrNull()
            myhashmap.remove(numelim)
            println("Alumne eliminat.")
        }

    } while (eleccio != 9)

    println("\n Adéu eh! borde...")                               // Diem avêu!


}