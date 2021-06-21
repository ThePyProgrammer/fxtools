package com.thepyprogrammer.fxtools

import javafx.scene.input.MouseEvent

val MouseEvent.screenPoint: Point
    get() = Point(screenX, screenY)

