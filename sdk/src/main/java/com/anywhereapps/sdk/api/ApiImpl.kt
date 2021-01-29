package com.anywhereapps.sdk.api

import com.anywhereapps.sdk.listener.ResponseListener
import com.anywhereapps.sdk.model.Establishment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ApiImpl(logging : Boolean) : ApiHelper {

    var apiService = RetrofitBuilder.getService(logging)

    override fun getEstablishments(
        token: String,
        term: String,
        latitude: Double,
        longitude: Double,
        radius: String,
        listener : ResponseListener<Establishment?>
    ) {

       var call =  apiService.getEstablishments("Bearer $token", term, latitude, longitude, radius)
        call.enqueue(object : Callback<Establishment> {
            override fun onResponse(call: Call<Establishment>, response: Response<Establishment>) {
                listener.onSuccess(response.body())
            }
            override fun onFailure(call: Call<Establishment>, t: Throwable) {
                listener.onError(t)
            }
        })
    }
}