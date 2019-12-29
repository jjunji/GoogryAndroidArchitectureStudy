package com.example.studyapplication.ui.main.base

class BasePresenter(val view : BaseContract.View) : BaseContract.Presenter {
    override fun checkValidation(query: String) {
        if(query.isEmpty()) {
            view.toastErrorQueryEmpty()
        }
    }

}