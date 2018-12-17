package com.playground.Network

    interface ResponseCallBack<T>
    {

        fun onSuccess(response:T)
        fun onFailure(e:Throwable)
    }





