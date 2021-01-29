package com.anywhereapps.sdk.listener


interface ResponseListener<T> {
    fun onSuccess(response: T)
    fun onError(t : Throwable)
}