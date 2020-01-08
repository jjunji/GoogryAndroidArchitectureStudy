package com.example.studyapplication.data.model.cache

import com.example.studyapplication.data.model.MovieInfo
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CacheMovie : RealmObject() {
    @PrimaryKey
    open var id : Int = 1
    open var movieList : RealmList<MovieInfo> = RealmList()
}