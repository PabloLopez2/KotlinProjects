package herencia

open class CelestialBody(
    private val name: String,
    var distanceToSun: Int,
    var positionInSky: Pair<Int, Int>,
    val isVisibleToNakedEye: Boolean
) {

    open fun printName() {
        println("Cuerpo celeste: $name")
    }
}