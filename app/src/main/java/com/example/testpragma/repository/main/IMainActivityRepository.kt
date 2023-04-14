package com.example.testpragma.repository.main

import com.example.testpragma.model.Cat
import com.example.testpragma.model.Image

interface IMainActivityRepository {
    fun getCats(
        response: (ArrayList<Cat>) -> Unit,
        error: (String?) -> Unit
    )

    fun getImageCat(
        imageId: String?,
        response: (Image) -> Unit,
        error: (String?) -> Unit
    )
}