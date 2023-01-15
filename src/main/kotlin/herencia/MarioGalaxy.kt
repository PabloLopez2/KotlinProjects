package herencia

class MarioGalaxy(
    val iluminosity: Int,
    val celestialBodies: List<CelestialBody>,
    val type: Type,
    name: String,
    distanceToSun: Int,
    positionInSky: Pair<Int, Int>,
    isVisibleToNakedEye: Boolean) : CelestialBody(name, distanceToSun, positionInSky, isVisibleToNakedEye) {

    enum class Type { Elliptical, Spiral, Dwarf, Irregular }


    override fun printName() {
        println("Galaxy name: ")
        super.printName()
    }

}