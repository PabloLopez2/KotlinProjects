package herencia

import Blackhole

fun main() {
    val star = Star(20, 28, "Pandora", 100000000, Pair(10, 10), false, null)
    star.printName()
    //6 Implementa una funció que donada una llista d’astres herencia.CelestialBody, en retorni el més llunyà.
    fun findTheFarthest(celestialBodies: List<CelestialBody>): CelestialBody {
        var farthest: CelestialBody = celestialBodies[0]
        for (i in 1 until celestialBodies.size) {
            if (celestialBodies[i].distanceToSun > farthest.distanceToSun) {
                farthest = celestialBodies[i]
            }
        }
        return farthest
    }

    //a) Comprova que la llista de la funció admet Galaxy(s), Blackhole(s) i Star(s)
    fun findTheFarthest1(celestialBodies: List<CelestialBody>): CelestialBody {
        var farthest1: CelestialBody = celestialBodies[0]
        for (i in 1 until celestialBodies.size) {
            if (celestialBodies[i].distanceToSun > farthest1.distanceToSun) {
                if (celestialBodies[i] is MarioGalaxy || celestialBodies[i] is Blackhole || celestialBodies[i] is Star) {
                    farthest1 = celestialBodies[i]
                }
            }
        }
        return farthest1
    }


}
/*Aquí posaré llistats els exercicis perque quedi més clar com els hem anat fent,
amb els seus enunciats i respostes 1 per 1*/
/*
    /*Ex 1: Escull el tipus de dades més adient per cada variable,
    indica si ha de ser var o val i pensa si sol·licitar la dada al constructor.*/
    class CelestialBody(
    val distanceToSun: Double,
    val positionInSky: String,
    val isVisibleToNakedEye: Boolean) {
}

    class BlackHole( //El constructor és tot el que agrupa els paréntesis de la classe
    val rotationVelocity: Double, //Aixó són paràmetres que es creen en aquesta classe i es defineixen com a val per guardar-nos el resultat
    val mass: Double,
    val isPrimitive: Boolean,
    distanceToSun: Double, //Aixó són arguments que els heredem de la classe CelestialBody, per aixó no les inicialitzem.
    positionInSky: String,
    isVisibleToNakedEye: Boolean) : CelestialBody(distanceToSun, positionInSky, isVisibleToNakedEye) {
}

    class Galaxy(
    var luminosity: Int
    val celestialBodies: List<CelestialBody>
    val type: Type
    distanceToSun: Double,
    positionInSky: String,
    isVisibleToNakedEye: Boolean) : CelestialBody(distanceToSun, positionInSky, isVisibleToNakedEye) {
}

    class Star(
    var luminosity: Double,
    val temperature: Double,
    val spectralClass: String,
    distanceToSun: Double,
    positionInSky: String,
    isVisibleToNakedEye: Boolean) : CelestialBody(distanceToSun, positionInSky, isVisibleToNakedEye)


    //Ex 2: Implementa la classe CelestialBody que té una funció printName() que imprimeix el nom d’aquest cos celeste.
    open fun printName() {
        println("Cuerpo celeste: $name")
    }

   /*Ex 3: Implementa la classe Blackhole que té la funció calculateSchwarzschildRadius() i ha de retornar
   2 G Mc2 [M: massa del forat negre, G: Constant de gravitació universal (6.67 · 10-11),
   c: Velocitat de la llum al buit (3 · 108 )].
   La funció ha de fer el càlcul només en el cas que rotationVelocity sigui zero.*/

     fun calculateSchwarzschildRadius(): Double? {

        val g = 6.67 * 10.0.pow(-11.0)
        val c = 3.0 * 10.0.pow(8.0)

        if (rotationVelocity == 0.0){
            return (2.0 * g * mass) / c.pow(2.0)
        }
        return null
    }

    /*Ex 4: Fes override a la classe Star de la funció printName() i fes que imprimeixi “Star  name: ” i a continuació,
    el valor que imprimeix la funció CelestialBody.printName().*/

    open fun printName() {
        println("Cuerpo celeste: $name")
    }
     override fun printName() {
        println("Star name: ")
        super.printName()
    }



   /*Ex 5: Implementa la classe Galaxy i Star.

     a) La variable Galaxy.type pot tenir quatre valors: Elliptical, Spiral, Dwarf, Irregular.

     enum class Type { Elliptical, Spiral, Dwarf, Irregular }

     b) La variable Galaxy.celestialBodies indica tots els elements celestes que conté aquesta galaxia.

     enum class Type { O, B, A, F, G, K, M, UNDEFINED }

     c) La variable Star.spectralClass s’ha de calcular automàticament a partir de la temperatura superficial de l’estrella.

        private var spectralClass: Type = if (temperature < 2600)
        Type.UNDEFINED
    else if (temperature in 2600..3850)
        Type.M
    else if (temperature <= 5250)
        Type.K
    else if (temperature <= 6000)
        Type.G
    else if (temperature <= 7200)
        Type.F
    else if (temperature <= 10000)
        Type.A
    else if (temperature <= 30000)
        Type.B
    else
        Type.O

    //Ex 6: Implementa una funció que donada una llista d’astres CelestialBody, en retorni el més llunyà.

    fun findTheFarthest(celestialBodies: List<CelestialBody>): CelestialBody {
        var farthest: CelestialBody = celestialBodies[0]
        for (i in 1 until celestialBodies.size) {
            if (celestialBodies[i].distanceToSun > farthest.distanceToSun) {
                farthest = celestialBodies[i]
             }
        }
        return farthest
    }

   //a) Comprova que la llista de la funció admet Galaxy(s), Blackhole(s) i Star(s)

     fun findTheFarthest1(celestialBodies: List<CelestialBody>): CelestialBody {
        var farthest1: CelestialBody = celestialBodies[0]
        for (i in 1 until celestialBodies.size) {
            if (celestialBodies[i].distanceToSun > farthest1.distanceToSun) {
                if (celestialBodies[i] is MarioGalaxy || celestialBodies[i] is BlackHole || celestialBodies[i] is Star) {
                    farthest1 = celestialBodies[i]
                }
            }
        }
        return farthest1
    }

    /*Ex 7: Afegeix una variable anomenada belongsTo a la classe Star de tipus Galaxy?.
    Aquesta variable fa referència a la galàxia a la qual pertany l’estrella.*/

    (Aquí dintre de la classe Star)
    var belongsTo: MarioGalaxy?


    Ex 8: Implementa una funció que, donades una Galaxy i una llista de Star, retorni les estrelles que pertanyen a aquesta galàxia.
    Amb aquesta funció predefinida: fun filterByGalaxy(stars: List<Star?>, galaxy: Galaxy): List<Star>

    fun filterByGalaxy(stars: List<Star?>, galaxy: MarioGalaxy): List<Star> {
        val result = ArrayList<Star>()
        for (star in stars) {
            if (star != null && star.belongsTo == galaxy) {
                result.add(star)
            }
        }
        return result
    }

    AMPLIACIÓ























































  */
      */
