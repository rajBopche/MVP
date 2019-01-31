package com.playground.network

    interface ResponseCallBack<T>
    {

        fun onSuccess(response:T)
        fun onFailure(e:Throwable)
    }





