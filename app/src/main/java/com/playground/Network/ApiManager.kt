package com.playground.Network

import com.playground.Model.Pojo.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiManager {

    val apiClient = ApiClient.getClient().create(ApiService::class.java)


    fun doLogin(name:String,passwd:String,responseListener:ResponseCallBack<LoginResponse>)
    {
        apiClient.login(name, passwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response: LoginResponse -> responseListener.onSuccess(response)},{e:Throwable ->run{ responseListener.onFailure(e)}})
    }
}
