package com.playground.Login


import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.playground.Base.BaseActivity.BasePresenter
import com.playground.Model.Pojo.LoginResponse
import com.playground.Network.ApiClient
import com.playground.Network.ApiManager
import com.playground.Network.ApiService
import com.playground.Network.ResponseCallBack
import com.playground.Utils.Utility


class LoginPresenter(var mView: LoginContract.LoginView?) : BasePresenter<LoginContract.LoginView>(),
    LoginContract.LoginPresenter {


    val apiManager = ApiManager()

    override fun start(view: LoginContract.LoginView) {

    }

    override fun doLogin(name: String, passwd: String) {

        if (!Utility.validateForEmptyEditText(name, passwd)) {
            apiManager.doLogin(name,passwd,object : ResponseCallBack<LoginResponse>{

                override fun onSuccess(response: LoginResponse) {mView?.showSuccessToast()}

                override fun onFailure(e: Throwable) {mView?.showErrorToast()}
            })
        } else {
            mView?.showErrorToast()
        }
    }

    override fun destroy() {
        mView = null
    }

    override fun moveToNextActivity() {
        //Navigate to appropriate place
    }

}