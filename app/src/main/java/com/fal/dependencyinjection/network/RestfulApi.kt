package com.fal.dependencyinjection.network

import com.fal.dependencyinjection.model.DataProductItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("products.json")
    fun getProducts() : Call<List<DataProductItem>>

}