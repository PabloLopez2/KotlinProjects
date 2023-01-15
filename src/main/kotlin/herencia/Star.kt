package herencia

class Star(
    val luminosity: Int,
    private val temperature: Int,
    name: String,
    distanceToSun: Int,
    positionInSky: Pair<Int, Int>,
    isVisibleToNakedEye: Boolean,
    var belongsTo: MarioGalaxy?) : CelestialBody(name, distanceToSun, positionInSky, isVisibleToNakedEye) {

    enum class Type { O, B, A, F, G, K, M, UNDEFINED }

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

    /* Ex: 8 Implementa una funció que, donades una Galaxy i una llista de Star, retorni les estrelles que pertanyen a aquesta galàxia.
        fun filterByGalaxy(stars: List<Star?>, galaxy: Galaxy): List<Star> */

    fun filterByGalaxy(stars: List<Star?>, galaxy: MarioGalaxy): List<Star> {
        val result = ArrayList<Star>()
        for (star in stars) {
            if (star != null && star.belongsTo == galaxy) {
                result.add(star)
            }
        }
        return result
    }


    override fun printName() {
        println("Star name: ")
        super.printName()
    }
}