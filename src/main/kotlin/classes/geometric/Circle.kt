package classes.geometric

class Circle(val center: Point, val radius: Double) {
    override fun toString(): String {
        return "Circle: center: $center, radius: $radius"
    }
}