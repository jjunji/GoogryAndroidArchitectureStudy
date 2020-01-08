package com.example.studyapplication.ui.main.blog

import com.example.studyapplication.data.model.BlogInfo
import com.example.studyapplication.data.model.SearchResult
import com.example.studyapplication.data.repository.NaverSearchRepository
import com.example.studyapplication.network.Conn
import com.example.studyapplication.ui.main.base.BaseSearchPresenter

class BlogPresenter(
    override val view: BlogContract.View,
    private val repository: NaverSearchRepository
) : BaseSearchPresenter(view), BlogContract.Presenter {

    override fun clickSearchButton(query: String) {
        repository.getBlogList(query, object : Conn {
            override fun <T> success(result: T) {
                // SearchResult<BlogInfo>

                val searchData : SearchResult<BlogInfo> = result as SearchResult<BlogInfo>
                searchData.let {
                    view.showList(searchData.arrItem)
                }
            }

            override fun failed(e: Throwable) {
                onRequestFailed(e)
            }
        })
    }
}