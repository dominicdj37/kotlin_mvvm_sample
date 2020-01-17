package com.example.mvvmdemo.data.api

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

object HttpStatusCode {
    const val successOne = 200
    const val successTwo = 201
    const val successThree = 204

    const val badRequest = 400
    const val unauthorized = 401
    const val forbidden = 403
    const val notFound = 404
    const val unProcessableEntity = 422

    const val internalServerError = 500
    const val timeout = 504

    const val noInternet = 15001
    const val customErrorCode = 15002
    const val passwordErrorCode = 15003
    const val quizExpired = 15004
}


class ApiError {
    var mCode: Int? = null
    var mMessage: String? = null
    var mNumberOfAttempt: Int? = null
    var mThrowable: Throwable? = null

    constructor(mCode: Int?) {
        this.mCode = mCode
    }

    constructor(mCode: Int?, mNumberOfAttempt: Int) {
        this.mCode = mCode
        this.mNumberOfAttempt = mNumberOfAttempt
    }

    constructor(code: Int?, message: String?) {
        this.mCode = code
        this.mMessage = message
    }

    constructor(throwable: Throwable) {
        this.mThrowable = throwable
        when (throwable) {
            is HttpException -> {
                this.mCode = throwable.code()
                this.mMessage = null
            }

            is UnknownHostException -> {
                this.mCode = HttpStatusCode.noInternet
                this.mMessage = null
            }

            is SocketTimeoutException -> {
                //Time out
                this.mCode = HttpStatusCode.timeout
                this.mMessage = null
            }

            is ConnectException -> {
                this.mCode = HttpStatusCode.noInternet
                this.mMessage = null
            }

            is SSLException -> {
                this.mCode = HttpStatusCode.noInternet
                this.mMessage = null
            }
        }
        this.mMessage = throwable.message
    }
}
