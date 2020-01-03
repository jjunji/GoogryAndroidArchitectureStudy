package com.example.studyapplication.ui.main.kin

import com.example.studyapplication.data.model.SearchKinResult
import com.example.studyapplication.data.repository.NaverSearchRepository
import com.example.studyapplication.network.Conn

class KinPresenter(val view  : KinContract.View, private val repository: NaverSearchRepository) : KinContract.Presenter {
    override fun clickSearchButton(query: String) {
        repository.getKinList(query, object : Conn {
            override fun <T> success(result: T) {
                val searchData : SearchKinResult? = result as SearchKinResult
                searchData?.let { view.showList(searchData.arrKinInfo) }
            }

            override fun failed(errorMessage: String) {
                view.toastErrorConnFailed(errorMessage)
            }
        })
    }

}