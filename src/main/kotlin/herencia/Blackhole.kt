import herencia.CelestialBody
import kotlin.math.pow

open class Blackhole(
    val rotationVelocity: Double,
    val mass: Double,
    val isPrimitive: Boolean,
    name: String,
    distanceToSun: Int,
    positionInSky: Pair<Int, Int>, ): CelestialBody(name, distanceToSun, positionInSky, false) {

    override fun printName(){
        println("BlackHole name: ")
        super.printName()
    }

    fun calculateSchwarzschildRadius(): Double? {

        val g = 6.67 * 10.0.pow(-11.0)
        val c = 3.0 * 10.0.pow(8.0)

        if (rotationVelocity == 0.0){
            return (2.0 * g * mass) / c.pow(2.0)
        }
        return null
    }
}