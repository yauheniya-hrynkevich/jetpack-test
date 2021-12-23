package com.beaverlisk.android.algorithms

class BinarySearch<T : Comparable<T>> {

    /**
     * Time complexity is O(log n).
     * The best-case time complexity would be O(1) when the central index would directly match the desired value.
     */
    fun searchPosition(source: List<T>, item: T): Int? {
        if (source.isEmpty()) return null
        var iterationCount = 1
        var lowest = 0
        var highest: Int = source.size - 1
        while (lowest <= highest) {
            println("Iteration count: $iterationCount")
            val mid = (lowest + highest) / 2
            val guess = source[mid]
            if (guess == item) {
                println("Item found, position: $mid")
                return mid
            }
            if (guess > item) {
                highest = mid - 1
            } else {
                lowest = mid + 1
            }
            iterationCount += 1
        }
        return null
    }

}