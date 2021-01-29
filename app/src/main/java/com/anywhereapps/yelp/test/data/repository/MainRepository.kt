package com.anywhereapps.yelp.test.data.repository

import com.anywhereapps.sdk.TestSDK
import com.anywhereapps.sdk.listener.ResponseListener
import com.anywhereapps.sdk.model.Establishment

class MainRepository {

    fun getEstablishment(
        term: String,
        latitude: Double,
        longitude: Double,
        radius: String,
        listener: ResponseListener<Establishment?>
    ) = TestSDK.getInstance().getEstablishment(term, latitude, longitude, radius,listener)
}
