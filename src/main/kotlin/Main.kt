fun main() {
    val list = ChunkedIntList()

    list.add(1)
    list.add(2)
    list.add(3)
    assert(list[0] == 1)
    assert(list[1] == 2)
    assert(list[2] == 3)
    assert(list[3] == 0)
    assert(list[4] == 0)
    assert(list.size == 3)
    list[1] = 4
    assert(list[1] == 4)
    list[10] = 5
    assert(list.size == 11)
    assert(list[10] == 5)

    list[123456] = 566
    assert(list[123456] == 566)
    list.clear()
    assert(list[10] == 0)
}
