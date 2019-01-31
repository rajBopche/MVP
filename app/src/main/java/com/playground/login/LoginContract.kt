package com.playground.login

import android.view.View
import com.playground.base.BaseActivity.BaseView

interface LoginContract {

    interface LoginView : BaseView {

        fun onLoginBtnClick(v: View)
        fun onLoginResult(result: Boolean?, code: Int)
        fun showLoader()
        fun hideLoader()
        fun moveToNextScreen()

    }

    interface LoginPresenter {
        fun doLogin(name: String, passwd: String)
        fun moveToNextActivity()

    }
}