import java.util.*

class ArrayIntList {
    private var arr = IntArray(16)
    private var capacity = 16
    var size: Int = 0
        private set

    operator fun contains(element: Int): Boolean {
        for (i in 0 until size) if (arr[i] == element) return true
        return false
    }

    fun containsAll(elements: Collection<Int>): Boolean {
        for (el in elements) {
            if (!contains(el)) return false
        }
        return true
    }

    operator fun get(index: Int): Int {
        if (index < 0) throw ArrayIndexOutOfBoundsException("$index")
        if (index >= size) return 0
        return arr[index]
    }

    fun indexOf(element: Int): Int {
        for (i in 0 until size) if (arr[i] == element) return i
        return -1
    }

    fun isEmpty(): Boolean = size == 0

    fun lastIndexOf(element: Int): Int {
        for (i in (size - 1) downTo 0) if (arr[i] == element) return i
        return -1
    }

    fun add(element: Int) {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity + capacity / 2 + 1)
            capacity = arr.size
        }
        arr[size] = element
        size++
    }

    fun addAll(elements: Collection<Int>) {
        if (capacity < size + elements.size) {
            arr = Arrays.copyOf(arr, maxOf(capacity + capacity / 2 + 1, size + elements.size))
            capacity = arr.size
        }
        var i = size
        for (el in elements) set(i++, el)
    }

    fun clear() {
        size = 0
    }

    operator fun set(index: Int, element: Int) {
        if (capacity <= index) {
            arr = Arrays.copyOf(arr, maxOf(capacity + capacity / 2 + 1, index + 1))
            capacity = arr.size
        }
        arr[index] = element
        if (index <= size) size = index + 1
    }
}
