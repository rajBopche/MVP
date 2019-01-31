package com.playground.base.BaseActivity

import com.playground.navigator.Navigator

abstract class BasePresenter<V : BaseView>{



    val navigator = Navigator.getNavigator()
     abstract fun start(view:V)
    abstract fun destroy()

}