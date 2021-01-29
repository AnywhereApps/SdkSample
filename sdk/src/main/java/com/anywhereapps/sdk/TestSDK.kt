package com.anywhereapps.sdk

import com.anywhereapps.sdk.api.ApiHelper
import com.anywhereapps.sdk.api.ApiImpl
import com.anywhereapps.sdk.listener.ResponseListener
import com.anywhereapps.sdk.model.Establishment
import java.lang.NullPointerException

class TestSDK private constructor(
    private val enableLogging: Boolean,
    private val API_KEY: String) {

    data class Builder(var API_KEY: String) {
        var logging: Boolean = false

        fun enableLogging(enableLogging: Boolean) = apply { this.logging = enableLogging }
        fun build() {
            TestSDK.init(logging,API_KEY)
        }
    }
    companion object {
       private var testSDK: TestSDK? = null

        private fun init(enableLogging: Boolean, API_KEY: String) {
            testSDK = TestSDK(enableLogging, API_KEY)
        }

        fun getInstance() : TestSDK{
           return testSDK ?: throw NullPointerException("Test SDK is not initialised. Please initialise it for receiving Data")
        }
    }

     fun getEstablishment(term : String,
                          latitude: Double,
                          longitude: Double,
                          radius: String,
                          listener: ResponseListener<Establishment?>
     ) {
        var apiHelper : ApiHelper = ApiImpl(enableLogging)
        return apiHelper.getEstablishments(API_KEY,term, latitude, longitude, radius,listener)
    }

}
