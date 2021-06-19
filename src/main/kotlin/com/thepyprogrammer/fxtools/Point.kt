package com.thepyprogrammer.fxtools

import javafx.beans.property.DoubleProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Point2D


data class Point(
    var xProperty: DoubleProperty = SimpleDoubleProperty(0.0),
    var yProperty: DoubleProperty = SimpleDoubleProperty(0.0)
) : Cloneable, Comparable<Any?> {

    private var x: Double
        get() = xProperty.get()
        set(other) = xProperty.set(other)

    private var y: Double
        get() = yProperty.get()
        set(other) = yProperty.set(other)

    constructor(x: Double, y: Double): this() {
        set(x, y)
    }

    constructor(point: Point2D) : this(point.x, point.y)

    operator fun set(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    fun set(point: Point2D) {
        this.x = point.x
        this.y = point.y
    }

    override fun toString(): String {
        return "($xProperty, $yProperty)"
    }

    fun copy(): Point {
        return Point(x, y)
    }

    public override fun clone(): Point {
        return copy()
    }

    fun bindX(xProperty: DoubleProperty) {
        this.xProperty.bind(xProperty)
    }

    fun bindXBidirectional(xProperty: DoubleProperty) {
        this.xProperty.bindBidirectional(xProperty)
    }

    fun bindY(yProperty: DoubleProperty) {
        this.yProperty.bind(yProperty)
    }

    fun bindYBidirectional(yProperty: DoubleProperty) {
        this.yProperty.bindBidirectional(yProperty)
    }

    fun bind(p: Point) {
        bindX(p.xProperty)
        bindY(p.yProperty)
    }

    fun bindBidirectional(p: Point) {
        bindXBidirectional(p.xProperty)
        bindYBidirectional(p.yProperty)
    }

    fun toPoint2d(): Point2D {
        return Point2D(x, y)
    }

    override operator fun compareTo(other: Any?): Int {
        return if (other is Point2D) compareTo(other) else if (other is Point) compareTo(other) else 0
    }

    operator fun compareTo(p: Point): Int {
        return if (x != p.x) (x - p.x).toInt() else (y - p.y).toInt()
    }

    operator fun compareTo(p: Point2D): Int {
        return if (x != p.x) (x - p.x).toInt() else (x - p.y).toInt()
    }

    fun fromOrigin(p: Point): Point {
        return Point(x - p.x, y - p.y)
    }

    val hypotenuse: Double
        get() = Math.sqrt(x * x + y * y)

    fun hypotenuseFrom(p: Point): Double {
        return fromOrigin(p).hypotenuse
    }
}