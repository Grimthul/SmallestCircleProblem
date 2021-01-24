import classes.geometric.Circle
import classes.geometric.Point
import helpers.geometric.enclosingCircleTrivial
import java.lang.IllegalArgumentException

fun main() {
    println("Tests are in test.kotlin.GeometricTest folder")
    println("Example usage:")
    val points = listOf(Point(1.0, 1.0),
        Point(1.0, 2.0),
        Point(1.0, 3.0),
        Point(1.0, 4.0),
        Point(1.0, 5.0),
        Point(1.0, 6.0),
        )
    println("Points: $points")
    val smallestCircle = getSmallestEnclosingCircle(points)
    println("Smallest circle: $smallestCircle")
}

/**
 * @return Circle that encloses all given points
 */
fun getSmallestEnclosingCircle(points: List<Point>): Circle {
    if (points.size <= 3) throw IllegalArgumentException("Not enough points")
    return welzlAlgorithm(points.shuffled(), listOf()) // shuffle on start for better performance than picking random element in each recursion
}

/**
 * Implementation of Welzl's algorithm that counts smallest enclosing circle
 */
private fun welzlAlgorithm(points: List<Point>, boundary: List<Point>): Circle {
    if (points.isEmpty() || boundary.size == 3) return enclosingCircleTrivial(boundary)
    val p = points.last()
    val d = welzlAlgorithm(points.dropLast(1), boundary)
    if (p.isInside(d)) return d
    return welzlAlgorithm(points.dropLast(1), boundary + p)
}
