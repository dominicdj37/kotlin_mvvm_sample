package com.example.mvvmdemo.data.api

class ApiResponse() {
    var error: ApiError? = null
    var data: Any? = null

    constructor(error: ApiError) : this() {
        this.error = error
    }

    constructor(data: Any) : this() {
        this.data = data
    }

    fun isSuccess(): Boolean {
        return this.error == null && this.data != null
    }
}