package com.example.studyapplication.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

class SearchImageResult : RealmObject() {
    @SerializedName("items")
    val arrImageInfo = emptyArray<ImageInfo>()

    data class ImageInfo(
        var thumbnail : String,
        var link : String,
        var title : String
    )
}