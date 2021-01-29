package com.anywhereapps.sdk.api

import com.anywhereapps.sdk.model.Establishment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

internal interface ApiService {

    @GET("/v3/businesses/search")
    fun getEstablishments(
        @Header("Authorization") token: String, @Query("term") term: String
        , @Query("latitude") latitude: Double, @Query("longitude") longitude: Double,
        @Query("radius") radius: String
    ): Call<Establishment>

}