package com.playground.Login


import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.playground.Base.BaseActivity.BasePresenter
import com.playground.Model.Pojo.LoginResponse
import com.playground.Network.ApiClient
import com.playground.Network.ApiService
import com.playground.Utils.Utility


class LoginPresenter(var mView: LoginContract.LoginView?) : BasePresenter<LoginContract.LoginView>(),
    LoginContract.LoginPresenter {

    val apiClient = ApiClient.getClient().create(ApiService::class.java)

    override fun start(view: LoginContract.LoginView) {

    }

    override fun doLogin(name: String, passwd: String) {

        if (!Utility.validateForEmptyEditText(name, passwd)) {

            apiClient.login(name, passwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<LoginResponse> {

                    override fun onComplete() {
                        mView?.showSuccessToast()
                    }

                    override fun onSubscribe(d: Disposable) {
                        //
                    }

                    override fun onNext(t: LoginResponse) {
                        //
                    }

                    override fun onError(e: Throwable) {
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