package com.group.libraryapp.calculator

class Calculator(
    private var _number: Int
) {

    val number: Int
        get() = this._number

    fun add(operand: Int) {
        this._number += operand
    }

    fun minus(operand: Int) {
        this._number -= operand
    }

    fun multiply(operand: Int) {
        this._number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없어요")
        }
        this._number /= operand
    }

}