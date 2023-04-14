package com.example.testpragma.model

import com.google.gson.annotations.SerializedName

class Cat {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("origin")
    val origin: String? = null

    @SerializedName("intelligence")
    val intelligence: Int = 0

    @SerializedName("reference_image_id")
    var imageId: String? = null

}