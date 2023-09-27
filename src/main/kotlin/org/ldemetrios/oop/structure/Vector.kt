package org.ldemetrios.oop.structure

data class Point(val x: Double, val y: Double, val name: String)

data class Vector(val arr: List<Double>) {
    constructor() : this(listOf(0.0, 0.0, 0.0))

    constructor(x: Double, y: Double, z: Double) : this(listOf(x, y, z))

    operator fun plus(another: Vector): Vector {
        val sum: MutableList<Double> = mutableListOf()
        for (i in 0 until this.arr.size) {
            sum.add(this.arr[i] + another.arr[i])
        }
        return Vector(sum)
    }

    operator fun minus(another: Vector): Vector {
        val sum: MutableList<Double> = mutableListOf()
        for (i in 0 until this.arr.size) {
            sum.add(this.arr[i] - another.arr[i])
        }
        return Vector(sum)
    }

    fun scalar(vec2: Vector): Double {
        var res = .0
        for (i in 0 until this.arr.size) {
            res += this.arr[i] * vec2.arr[i]
        }
        return res
    }

    companion object {

    }
}


fun plus(vec1: List<Double>, vec2: List<Double>): List<Double> {
    val sum: MutableList<Double> = mutableListOf()
    for (i in 0 until vec1.size) {
        sum.add(vec1[i])
    }
    for (i in 0 until vec2.size) {
        sum.add(vec2[i])
    }
    return sum
}
