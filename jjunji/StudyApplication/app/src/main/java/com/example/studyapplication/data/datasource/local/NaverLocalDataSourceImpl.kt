package com.example.studyapplication.data.datasource.local

import com.example.studyapplication.data.model.SearchMovieResult
import io.realm.Realm

class NaverLocalDataSourceImpl : NaverLocalDataSource {
    override fun insertCacheData(items: Array<SearchMovieResult.MovieInfo>) {
        val realm : Realm = Realm.getDefaultInstance()

        realm.executeTransaction()
    }

}