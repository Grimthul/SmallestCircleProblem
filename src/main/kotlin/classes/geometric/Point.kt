package classes.geometric

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class Point(val x: Double, val y: Double) {
    /**
     * Counts Euclidean distance between two points
     * @param[other] the other Point
     * @return distance between the Points in Double
     */
    fun distance(other: Point): Double {
        return sqrt((this.x - other.x).pow(2) + (this.y - other.y).pow(2))
    }

    /**
     * @return True if the Point is inside circle, false if not
     */
    fun isInside(circle: Circle): Boolean {
        return round(this.distance(circle.center) * 10000) / 10000 <= round(circle.radius * 10000) / 10000 // comparison is rounded to 4 decimal places
    }

    override fun toString(): String {
        return "Point: -> x: $x, -> y: $y"
    }
}