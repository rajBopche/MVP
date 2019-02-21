package com.playground.network

import com.playground.model.Pojo.LoginResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class ApiManager {

    val apiClient = ApiClient.getClient().create(ApiService::class.java)

    fun <T> observeApi(response:Observable<T>, responseListener: ResponseCallBack<LoginResponse>)
    {
        response.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }


    fun doLogin(name: String, passwd: String, responseListener: ResponseCallBack<LoginResponse>) {
        observeApi(apiClient.login(name,passwd),responseListener)
    }
}
