package com.thepyprogrammer.fxtools

import javafx.geometry.Rectangle2D

fun Rectangle2D.contains(screenPoint: Point) = contains(screenPoint.toPoint2d())

