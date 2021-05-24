package com.example.mypg.api.exception

import java.lang.RuntimeException

class MyException(var status:Int, var errorMessage: String):Exception() {
    fun myException(errorMessage: String) {
        this.errorMessage = errorMessage
    }
}