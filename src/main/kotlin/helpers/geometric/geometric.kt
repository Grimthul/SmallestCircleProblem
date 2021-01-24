package helpers.geometric

import classes.geometric.Circle
import classes.geometric.Point

/**
 * @return Circle defined by point A,B,C
 */
fun enclosingCircle(A: Point, B: Point, C: Point): Circle {
    val center = calcCenter(A, B, C)
    return Circle(center, center.distance(A))
}

/**
 * @return Circle that encloses points A and B
 */
fun enclosingCircle(A: Point, B: Point): Circle {
    val centerX = (A.x + B.x) / 2
    val centerY = (A.y + B.y) / 2
    val center = Point(centerX, centerY) // midpoint of A and B
    return Circle(center, A.distance(B) / 2) // radius is half the distance of A and B
}

/**
 * Solves trivial cases of enclosing circle
 */
fun enclosingCircleTrivial(points: List<Point>): Circle {
    return when (points.size) {
        0 -> Circle(Point(0.0,0.0), 0.0)
        1 -> Circle(points[0], 0.0)
        2 -> enclosingCircle(points[0], points[1])
        else -> enclosingCircle(points[0], points[1], points[2])
    }
}

/**
 * Center is where orthogonal bisectors of lines (A,B) and (B,C) intersect.
 * The orthogonal bisector of line (A,B) passes through (ax,ay) with direction (ux,uy).
 * The orthogonal bisector of line (B, C) passes through (bx, by) with direction (vx, vy).
 * @return Center (Point) of circle defined by three Points A, B and C
 */
private fun calcCenter(A: Point, B: Point, C: Point): Point {
    val ax = (A.x + B.x) / 2 // half X between Point A and B
    val ay = (A.y + B.y) / 2 // half Y between Point A and B
    val ux = A.y - B.y // X direction of orthogonal bisector of line (A,B)
    val uy = B.x - A.x // Y direction of orthogonal bisector of line (A,B)
    val bx = (B.x + C.x) / 2 // half X between Point B and C
    val by = (B.y + C.y) / 2 // half Y between Point B and C
    val vx = B.y - C.y // X direction of orthogonal bisector of line (B, C)
    val vy = C.x - B.x // Y direction of orthogonal bisector of line (B, C)
    val dx = ax - bx
    val dy = ay - by
    val vu = vx * uy - vy * ux
    val g = (dx * uy - dy * ux) / vu
    return Point(bx + g * vx, by + g * vy)
}
