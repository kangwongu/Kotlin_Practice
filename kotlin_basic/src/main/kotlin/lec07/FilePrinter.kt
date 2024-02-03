package lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    // IOException 발생 가능성이 있어서 빨간줄이 떠야하지만, 뜨지 않는다 -> 코틀린은 모든 예외를 전부 언체크드예외로 처리
    // -> 코틀린에는 'throws' 키워드가 없다
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    // try-with-resources, 코틀린에는 해당 구문이 없다
    fun readFile(path: String) {
        // try-with-resources의 대체
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}