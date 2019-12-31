package com.example.studyapplication.data.repository

import com.example.studyapplication.data.datasource.local.NaverLocalDataSource
import com.example.studyapplication.data.datasource.remote.NaverRemoteDataSource
import com.example.studyapplication.data.model.SearchMovieResult
import com.example.studyapplication.network.Conn

class NaverSearchRepositoryImpl(private val remoteDataSource: NaverRemoteDataSource, private val localDataSource: NaverLocalDataSource) : NaverSearchRepository {

    override fun getMovieList(query: String, conn: Conn) {
        remoteDataSource.getMovieList(query, conn)
    }

    override fun getBlogList(query: String, conn: Conn) {
        remoteDataSource.getBlogList(query, conn)
    }

    override fun getImageList(query: String, conn: Conn) {
        remoteDataSource.getImageList(query, conn)
    }

    override fun getKinList(title: String, conn: Conn) {
        remoteDataSource.getKinList(title, conn)
    }

    override fun setCacheMovieList(items: Array<SearchMovieResult.MovieInfo>) {
        localDataSource.insertCacheData(items)
    }

    override fun setCacheBlogList() {

    }

    override fun setCacheImageList() {

    }

    override fun setCacheKinList() {
    }

}