package com.playground.login


import com.playground.base.BaseActivity.BasePresenter
import com.playground.dagger.DaggerComponent
import com.playground.dagger.NetworkModule
import com.playground.model.Pojo.LoginResponse
import com.playground.network.ApiManager
import com.playground.network.ResponseCallBack
import com.playground.utils.Utility
import javax.inject.Inject


class LoginPresenter(var mView: LoginContract.LoginView?) :
    BasePresenter<LoginContract.LoginView>(),
    LoginContract.LoginPresenter {

    @Inject
    lateinit var apiManager:ApiManager

    fun initDagger(){
        DaggerComponent.builder().networkModule(NetworkModule()).build().inject(this)
    }


    override fun start(view: LoginContract.LoginView) {

    }

    override fun doLogin(name: String, passwd: String) {
        initDagger()
        if (!Utility.validateForEmptyEditText(name, passwd)) {
            apiManager.doLogin(name, passwd, object : ResponseCallBack<LoginResponse> {

                override fun onSuccess(response: LoginResponse) {
                    mView?.showSuccessToast()
                }

                override fun onFailure(e: Throwable) {
                    mView?.showErrorToast()
                }
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