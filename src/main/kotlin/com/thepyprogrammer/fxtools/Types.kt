package com.thepyprogrammer.fxtools


fun Boolean.toInt() = if(this) 1 else 0

fun Boolean.given(block: () -> Unit): Boolean {
    if (this) block()
    return this
}
