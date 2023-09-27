class ChunkedIntList {
    private var arr: Array<Array<Array<IntArray?>?>?>? = null
    var size: Int = 0
        private set

    operator fun contains(element: Int): Boolean {
        if (arr == null) return false
        for (i in 0 until 256) {
            if (arr!![i] == null) continue
            for (j in 0 until 256) {
                if (arr!![i]!![j] == null) continue
                for (k in 0 until 256) {
                    if (arr!![i]!![j]!![k] == null) continue
                    for (l in 0 until 256) {
                        if (arr!![i]!![j]!![k]!![l] == element) return true
                    }
                }
            }
        }
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
        return arr?.get(index shr 24)?.get(index shr 16 and 255)?.get(index shr 8 and 255)?.get(index and 255) ?: 0
    }

    fun indexOf(element: Int): Int {
        if (arr == null) return -1
        for (i in 0 until 256) {
            if (arr!![i] == null) continue
            for (j in 0 until 256) {
                if (arr!![i]!![j] == null) continue
                for (k in 0 until 256) {
                    if (arr!![i]!![j]!![k] == null) continue
                    for (l in 0 until 256) {
                        if (arr!![i]!![j]!![k]!![l] == element) return (i shl 24) + (j shl 16) + (k shl 8) + l
                    }
                }
            }
        }
        return -1
    }

    fun isEmpty(): Boolean = size == 0

    fun lastIndexOf(element: Int): Int {
        if (arr == null) return -1
        for (i in 255 downTo 0) {
            if (arr!![i] == null) continue
            for (j in 255 downTo 0) {
                if (arr!![i]!![j] == null) continue
                for (k in 255 downTo 0) {
                    if (arr!![i]!![j]!![k] == null) continue
                    for (l in 255 downTo 0) {
                        if (arr!![i]!![j]!![k]!![l] == element) return (i shl 24) + (j shl 16) + (k shl 8) + l
                    }
                }
            }
        }
        return -1
    }

    fun add(element: Int) {
        val i = size shr 24
        val j = size shr 16 and 255
        val k = size shr 8 and 255
        val l = size and 255
        if (arr == null) arr = Array(256) { null }
        if (arr!![i] == null) arr!![i] = Array(256) { null }
        if (arr!![i]!![j] == null) arr!![i]!![j] = Array(256) { null }
        if (arr!![i]!![j]!![k] == null) arr!![i]!![j]!![k] = IntArray(256)
        arr!![i]!![j]!![k]!![l] = element
        size++
    }

    fun addAll(elements: Collection<Int>) {
        for (el in elements) add(el)
    }

    fun clear() {
        size = 0
        arr = null
    }

    operator fun set(index: Int, element: Int) {
        val i = index shr 24
        val j = index shr 16 and 255
        val k = index shr 8 and 255
        val l = index and 255
        if (arr == null) arr = Array(256) { null }
        if (arr!![i] == null) arr!![i] = Array(256) { null }
        if (arr!![i]!![j] == null) arr!![i]!![j] = Array(256) { null }
        if (arr!![i]!![j]!![k] == null) arr!![i]!![j]!![k] = IntArray(256)
        arr!![i]!![j]!![k]!![l] = element
        if (index >= size) size = index + 1
    }
}
