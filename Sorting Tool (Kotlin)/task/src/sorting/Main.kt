package sorting

fun main(args: Array<String>) {
    args.forEach { if (!it.matches("long|word|line|natural|byCount|-sortingType|-dataType".toRegex())) println("\"$it\" isn not a valid parameter. It will be skipped.")}
    when  {
        "long" in args && "byCount" in args -> sortNumberCount()
        "word" in args && "byCount" in args -> sortWordCount()
        "line" in args && "byCount" in args -> sortLineCount()
        "long" in args && "byCount" !in args -> sortNumberNature()
        "word" in args && "byCount" !in args -> sortWordNature()
        "line" in args && "byCount" !in args -> sortLineNature()
        "-sortingType" in args && ("natural" !in args || "byCount" !in args) -> println("No sorting type defined!")
        "-dataType" in args && ("long" !in args || "word" !in args || "line" !in args ) -> println("No data type defined!")
    }
}

fun sortNumberCount() {
    val list = mutableListOf<Int>()
    while (true) {
        val read = readlnOrNull() ?: break
        read.split(" +".toRegex()).forEach { if (it.matches("-?\\d+".toRegex())) list.add(it.toInt()) else println("\"$it\" is not a long. It will be skipped.") }
    }
    var map = mutableMapOf<Int, Int>()
    for(i in list.sorted()) {
        map[i] = list.sorted().count { i == it }
    }
    map = map.toList().sortedBy { (_, value) -> value  }.toMap() as MutableMap<Int, Int>
    println("Total numbers: ${list.size}.")
    map.map { println("${it.key}: ${it.value} time(s), ${it.value * 100 / list.size}%") }
}

fun sortWordCount() {
    val list = mutableListOf<String>()
    while (true) {
        val read = readlnOrNull() ?: break
        list.addAll(read.split(" +".toRegex()))
    }
    var map = mutableMapOf<String, Int>()
    for(i in list.sorted()) {
        map[i] = list.sorted().count { i == it }
    }
    map = map.toList().sortedBy { (_, value) -> value  }.toMap() as MutableMap<String, Int>
    println("Total words: ${list.size}.")
    map.map { println("${it.key}: ${it.value} time(s), ${it.value * 100 / list.size}%") }
}

fun sortLineCount() {
    val list = mutableListOf<String>()
    while (true)  list.add(readlnOrNull() ?: break)
    var map = mutableMapOf<String, Int>()
    for(i in list.sorted()) {
        map[i] = list.sorted().count { i == it }
    }
    map = map.toList().sortedBy { (_, value) -> value  }.toMap() as MutableMap<String, Int>
    println("Total lines: ${list.size}.")
    map.map { println("${it.key}: ${it.value} time(s), ${it.value * 100 / list.size}%") }
}

fun sortNumberNature () {
    val list = mutableListOf<Int>()
    while (true) {
        val read = readlnOrNull() ?: break
        read.split(" +".toRegex()).forEach { if (it.matches("-?\\d+".toRegex())) list.add(it.toInt()) else println("\"$it\" is not a long. It will be skipped.") }
    }
    val sortInt = list.sorted().joinToString(" ")
    println("Total numbers: ${list.size}.\n" +
            "Sorted data: $sortInt")
}

fun sortWordNature () {
    val list = mutableListOf<String>()
    while (true) {
        val read = readlnOrNull() ?: break
        list.addAll(read.split(" +".toRegex()))
    }
    val sortInt = list.sorted().joinToString(" ")
    println("Total words: ${list.size}.\n" +
            "Sorted data: $sortInt")
}

fun sortLineNature () {
    val list = mutableListOf<String>()
    while (true)  list.add(readlnOrNull() ?: break)
    println("Total lines: ${list.size}.\n" +
            "Sorted data:")
    list.sorted().map { println(it) }
}