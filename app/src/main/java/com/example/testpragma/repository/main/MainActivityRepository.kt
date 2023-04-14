package com.example.testpragma.repository.main

import com.example.testpragma.model.Cat
import com.example.testpragma.model.Image
import com.example.testpragma.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {

    override fun getCats(response: (ArrayList<Cat>) -> Unit, error: (String?) -> Unit) {
        val call = apiInterface.getListCats()
        call.enqueue(object : Callback<ArrayList<Cat>> {
            override fun onResponse(
                call: Call<ArrayList<Cat>>,
                response: Response<ArrayList<Cat>>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<ArrayList<Cat>>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }

    override fun getImageCat(
        imageId: String?,
        response: (Image) -> Unit,
        error: (String?) -> Unit
    ) {
        val call = apiInterface.getImage(imageId)
        call.enqueue(object : Callback<Image> {
            override fun onResponse(
                call: Call<Image>,
                response: Response<Image>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<Image>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }
}