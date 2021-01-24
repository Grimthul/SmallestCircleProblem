import classes.geometric.Circle
import classes.geometric.Point
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertTrue

class GeometricTest {
    /**
     * Tests smallest enclosing circle on list of random size of random points of random X and Y
     */
    @Test
    fun shouldAllBeTrue() {
        val numOfTests = 100000
        val maxVal = 1000.0
        val maxNumOfPoints = 100
        for (i in 0 until numOfTests) {
            val max = Random.nextInt(4, maxNumOfPoints)
            val points = (0..max).map { Point(Random.nextDouble(maxVal),Random.nextDouble(maxVal)) }
            val enclosingCircle = getSmallestEnclosingCircle(points)
//                println("Iteration: $i")
//                println(points)
//                println(enclosingCircle)
            assertTrue(isValidCircle(enclosingCircle, points))
        }
    }

    /**
     * For testing purposes
     * @return True if every point in list belongs to the circle, else false
     */
    private fun isValidCircle(circle: Circle, points: List<Point>): Boolean {
        for (p in points) {
            if (!p.isInside(circle)) {
                println("Failed on: $p")
                return false
            }
        }
        return true
    }

}