package unit02.part3

/**
 * 읽기 전용 목록: List는 만든 후 수정할 수 없습니다.
 * 변경 가능한 목록: MutableList는 만든 후 수정할 수 있습니다. 즉, 요소를 추가하거나 삭제, 업데이트할 수 있습니다.
 */

fun main() {

//    intro()
//    myMutableList()
//    myLoop()

//    val noodles = Noodles()
//    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
////    Vegetables(listOf("Cabbage", "Sprouts", "Onion"))
//    val vegetables2 = Vegetables()
//    println(noodles)
//    println(vegetables)
//    println(vegetables2)

    val ordersList = mutableListOf<Order>()

    val order1 = Order(1)
    order1.addItem(Noodles())
    ordersList.add(order1)

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    ordersList.add(order2)

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    ordersList.add(order3)



    // 빌더패턴 적용시 사용가능한 사례
    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    ordersList.add(order4)

    ordersList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach")))

    for (order in ordersList) {
        order.print()
        println()
    }
}

fun intro() {
    //    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    println("List: $numbers")
    println("Size: ${numbers.size}")

    // Access elements of the list
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size - 1}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    // Use the contains() method
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")


    val colors = listOf("green", "orange", "blue")
    /**
     *         colors.add("purple")
     *         colors[0] = "yellow"
     * 본질적으로 오류는 add() 메서드가 List에 없고 요소의 값을 변경할 수 없음을 나타냅니다.
     */
    println("Reversed list: ${colors.reversed()}")
    println("List: $colors")
    println("Sorted list: ${colors.sorted()}")

    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")
}

fun myMutableList() {
//    val entrees = mutableListOf<String>()
    val entrees: MutableList<String> = mutableListOf()
//  참고: 변경 가능한 목록에 val를 사용할 수 있습니다. entrees 변수에 목록 참조가 포함되어 있고 이 참조는 목록의 내용이 변경되더라도 변경되지 않기 때문입니다.

    println("Add noodles: ${entrees.add("noodles")}")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")
    println(" * * * * * * * * * * * * * * * * * * ")
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")
    println(" * * * * * * * * * * * * * * * * * * ")
    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    println(" * * * * * * * * * * * * * * * * * * ")
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
    println("Entrees: $entrees")
    println(" * * * * * * * * * * * * * * * * * * ")
    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")
    println(" * * * * * * * * * * * * * * * * * * ")
    entrees.clear()
    println("Entrees: $entrees")
    println("Empty? ${entrees.isEmpty()}")
}

fun myLoop() {
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0

    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalGuests")

    val names = listOf("Jessica", "Henry", "Alicia", "Jose")

    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }
    /**
     * 참고: 다음은 특정 단계의 범위(매번 1씩 증분하는 대신)와 함께 사용하는 등 for 루프로 할 수 있는 다른 작업입니다.
     * for (item in list) print(item) // Iterate over items in a list
     * for (item in 'b'..'g') print(item) // Range of characters in an alphabet
     * for (item in 1..5) print(item) // Range of numbers
     * for (item in 5 downTo 1) print(item) // Going backward
     * for (item in 3..6 step 2) print(item) // Prints: 35
     */
}

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

//class Vegetables(val toppings: List<String>) : Item("Vegetables", 5) {
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5){
//    override fun toString(): String {
//        return name
//    }
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name Chef's Choice"
        } else {
            return name + " " + toppings.joinToString()
        }
    }
}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()

//    fun addItem(newItem: Item) {
//        itemList.add(newItem)
//    }
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }

//    fun addAll(newItems: List<Item>) {
//        itemList.addAll(newItems)
//    }
    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    fun print() {
        println("Order #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }


}