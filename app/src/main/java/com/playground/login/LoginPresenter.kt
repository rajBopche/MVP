package com.playground.login


import android.content.Context
import android.widget.Toast
import com.playground.base.BaseActivity.BasePresenter
import com.playground.dagger.DaggerAppComponent
import com.playground.model.Pojo.LoginResponse
import com.playground.network.ApiManager
import com.playground.network.ResponseCallBack
import com.playground.utils.App
import com.playground.utils.Utility
import javax.inject.Inject


class LoginPresenter(var mView: LoginContract.LoginView?) :
    BasePresenter<LoginContract.LoginView>(),
    LoginContract.LoginPresenter {

    @Inject
    lateinit var apiManager: ApiManager

    @Inject
    lateinit var mContext: Context

    override fun start(view: LoginContract.LoginView) {

    }

    override fun doLogin(name: String, passwd: String) {
        if (!Utility.validateForEmptyEditText(name, passwd)) {
            DaggerAppComponent.builder().providerAppContext(App()).build().inject(this)
            Toast.makeText(mContext, "The Binds Instance efforts", Toast.LENGTH_SHORT).show()
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