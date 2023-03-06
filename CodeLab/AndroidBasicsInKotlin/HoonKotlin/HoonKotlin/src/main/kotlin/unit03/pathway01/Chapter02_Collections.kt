package unit03.pathway01

fun main() {
//    learn00()
//    learn01()
//    learn02_lamda()
//    learn03_higherOrderFun()
    learn04_more()
}

fun learn00() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")

    val setOfNumbers = numbers.toSet()
    println("set:    ${setOfNumbers}")

    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")
}

fun learn01() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )

    peopleAges.put("Barbara", 42)
    // put 약식 표기법[~]
    peopleAges["Joe"] = 51
    peopleAges["Fred"] = 31
    println(peopleAges)
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }

    /**
     * peopleAges.map은 peopleAges의 각 항목에 변환을 적용하고 변환된 항목으로 이루어진 새 컬렉션을 만듭니다.
     * 중괄호 {} 안에 있는 부분은 각 항목에 적용할 변환을 정의합니다.
     * 변환은 키-값 쌍을 가져와서 문자열로 변환합니다. 예를 들어 <Fred, 31>을 Fred is 31로 변환합니다.
     * joinToString(", ")은 변환된 컬렉션의 각 항목을 문자열에 추가하고 ,로 구분하며 마지막 항목에는 기호를 추가하지 않습니다.
     * 이 모든 과정이 이전 Codelab에서 함수 호출 및 속성 액세스에서 실행한 것처럼 점 연산자(.)로 결합됩니다.
     */
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)
}

fun learn02_lamda() {
//    val triple: (Int) -> Int = { a: Int -> a * 3 }
    val triple: (Int) -> Int = { it * 3 }
    println(triple(5))
}

fun learn03_higherOrderFun() {
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())

    /**
     * 이 경우에는 첫 번째 문자열의 길이와 두 번째 문자열 길이의 차이(Int)를 반환합니다. 정렬에 필요한 값과 일치시킵니다.
     * str1이 str2보다 짧으면 0보다 작은 값을 반환합니다. str1과 str2의 길이가 같은 경우 0을 반환합니다. str1이 str2보다 긴 경우 0보다 큰 값을 반환합니다.
     * sortedWith() 함수는 두 Strings 사이의 일련의 비교를 한꺼번에 처리하여 이름 길이를 기준으로 오름차순으로 목록을 출력합니다.
     */
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
}

fun learn04_more() {
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")

    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println(filteredWords)

}