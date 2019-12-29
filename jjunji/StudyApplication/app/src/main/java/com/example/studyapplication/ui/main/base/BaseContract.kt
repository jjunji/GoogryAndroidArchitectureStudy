package com.example.studyapplication.ui.main.base

interface BaseContract {
    interface View {
        fun toastErrorQueryEmpty()
    }

    interface Presenter {
        fun checkValidation(query : String)
    }
}