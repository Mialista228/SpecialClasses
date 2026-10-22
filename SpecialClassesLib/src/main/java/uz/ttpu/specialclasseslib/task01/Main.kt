package uz.ttpu.specialclasseslib.task01

enum class OrderStatus {
    NEW, PAID, SHIPPED, DELIVERED, CANCELLED
}

fun main() {
    println("Statuses: ${OrderStatus.entries.joinToString()}")
    print("Current status of your order: ")
    val text = readln().trim().uppercase()
    val status = OrderStatus.entries.firstOrNull {
        it.name.equals(text, ignoreCase = true)
    }

    if (status == null) {
        println("Unknown status")
        return
    }
    println("You entered ${status.name}: step ${status.ordinal + 1} of ${OrderStatus.entries.size}")
    val next = OrderStatus.entries.getOrNull(status.ordinal + 1)
    println(if (next == null) "This is the last step." else "Next step: $next")
}
