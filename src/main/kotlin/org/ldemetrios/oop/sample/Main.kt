package org.ldemetrios.oop.sample

import org.ldemetrios.oop.structure.Vector
import java.util.Collections

fun main() {
    val v = Vector(listOf(2.0, 3.0, 9.0))
    val v2 = Vector(5.0, 6.0, 6.0)
    val v3 = Vector(listOf(0.0, 0.0, 0.0))
    println(v + v2 - v3)
}
