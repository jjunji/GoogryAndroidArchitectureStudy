package com.example.studyapplication.data.datasource.local

import com.example.studyapplication.data.model.SearchMovieResult

interface NaverLocalDataSource {
    fun insertCacheData(items: Array<SearchMovieResult.MovieInfo>)
}