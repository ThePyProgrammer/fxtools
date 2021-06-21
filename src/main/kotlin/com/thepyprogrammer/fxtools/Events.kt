package com.thepyprogrammer.fxtools

import javafx.scene.input.MouseEvent

val MouseEvent.point: Point
    get() = Point(screenX, screenY)

