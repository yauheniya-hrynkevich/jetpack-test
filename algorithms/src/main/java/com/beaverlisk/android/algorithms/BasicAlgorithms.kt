package com.beaverlisk.android.algorithms

fun main() {

    val intListToSearchIn = (1..450).toList()
    val charListToSearchIn = "abcdefghijklmnopqrstuvwxyz".toList()

    BinarySearch<Int>().searchPosition(intListToSearchIn, 96)
    BinarySearch<Char>().searchPosition(charListToSearchIn, 'z')
}