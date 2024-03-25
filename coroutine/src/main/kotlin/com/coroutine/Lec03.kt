package com.coroutine

import kotlinx.coroutines.*
import kotlin.time.measureTime

// 코루틴 제어
//fun main(): Unit = runBlocking {
//    // 시작 시점을 제어
//    val job = launch(start = CoroutineStart.LAZY) {
//        printWithThread("Hello launch")
//    }
//
//    // 코루틴이 바로 동작하는 것이 아니라, 1초후에 동작하도록 함
//    delay(1000)
//    job.start()
//}

//fun main(): Unit = runBlocking {
//    val job1 = launch {
//        delay(1000)
//        printWithThread("JOB 1")
//    }
//    // job1이 끝날때까지 대기한다
//    job1.join()
//
//    val job2 = launch {
//        delay(1000)
//        printWithThread("JOB 2")
//    }
//}

// runBlocking
fun example1() {
    // 블로킹방식으로 동작, 동기
    runBlocking {
        printWithThread("START")
        launch {
            delay(2_000L)
            printWithThread("LAUNCH END")
        }
    }

    printWithThread("END")
}

fun main(): Unit = runBlocking {
    val time = measureTime {
        val job1 = async { apiCall1() }
        val job2 = async { apiCall2() }
        printWithThread(job1.await() + job2.await())
    }

    printWithThread("소요시간: $time ms")
}

suspend fun apiCall1(): Int {
    delay(1000)
    return 1
}

suspend fun apiCall2(): Int {
    delay(1000)
    return 2
}