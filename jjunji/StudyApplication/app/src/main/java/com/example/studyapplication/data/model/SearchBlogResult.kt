package com.example.studyapplication.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

class SearchBlogResult : RealmObject() {
    @SerializedName("items")
    val arrBlogInfo = emptyArray<BlogInfo>()

    data class BlogInfo(
        var link : String,
        var title : String,
        var description : String,
        var bloggername : String,
        var bloggerlink : String
    )
}