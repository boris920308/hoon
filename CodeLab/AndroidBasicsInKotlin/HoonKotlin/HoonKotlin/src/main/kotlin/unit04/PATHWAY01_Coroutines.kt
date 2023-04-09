package main.kotlin.unit04

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.*

fun main() {
    coroutine_03()
}

fun coroutine_03() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
//    repeat(3) {
//        Thread {
//            println("${Thread.currentThread()} has started")
//            for (i in states) {
//                println("${Thread.currentThread()} - $i")
//                Thread.sleep(50)
//            }
//        }.start()
//    }

    repeat(3) {
        GlobalScope.launch {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                delay(5000)
            }
        }
    }
}

val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }
suspend fun getValue(): Double {
    println("entering getValue() at ${time()}")
    delay(3000)
    println("leaving getValue() at ${time()}")
    return Math.random()
}
fun coroutine_02() {
    runBlocking {
        val num1 = async { getValue() }
        val num2 = async { getValue() }
        println("result of num1 + num2 is ${num1.await() + num2.await()}")
    }
}
fun coroutine_01() {
    /**
     * Job
     * 취소 가능한 작업 단위(예: launch() 함수로 만든 작업 단위)입니다.
     *
     * CoroutineScope
     * launch() 및 async()와 같은 새 코루틴을 만드는 데 사용되는 함수는 CoroutineScope를 확장합니다.
     *
     * Dispatcher
     * 코루틴이 사용할 스레드를 결정합니다. Main 디스패처는 항상 기본 스레드에서 코루틴을 실행하지만 Default나 IO, Unconfined와 같은 디스패처는 다른 스레드를 사용합니다.
     */
    repeat(3) {
        GlobalScope.launch {
            println("Hi from ${Thread.currentThread()}")
        }
    }
}

fun thread_03() {
    var count = 0
    for (i in 1..50) {
        Thread {
            count += 1
            println("Thread: $i count: $count")
        }.start()
    }
}
fun thread_02() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        Thread {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                Thread.sleep(50)
            }
        }.start()
    }
}
fun thread_01() {
    val thread = Thread {
        println("${Thread.currentThread()} has run")
    }

    thread.start()
}


