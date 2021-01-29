package com.anywhereapps.sdk.api

import com.anywhereapps.sdk.listener.ResponseListener
import com.anywhereapps.sdk.model.Establishment


internal interface ApiHelper {

    fun getEstablishments(
        token: String,
        term: String,
        latitude: Double,
        longitude: Double,
        radius: String,
        listener: ResponseListener<Establishment?>
    )
}