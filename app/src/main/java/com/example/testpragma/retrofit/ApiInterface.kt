package com.example.testpragma.retrofit

import com.example.testpragma.model.Cat
import com.example.testpragma.model.Image
import com.example.testpragma.utils.GET_IMAGE
import com.example.testpragma.utils.GET_LIST_CATS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(GET_LIST_CATS)
    fun getListCats(): Call<ArrayList<Cat>>

    @GET("${GET_IMAGE}/{imageId}")
    fun getImage(@Path("imageId") imageId: String?): Call<Image>
}