package playground.Base.BaseActivity

import playground.Navigator.Navigator

abstract class BasePresenter<V : BaseView>{

    val navigator = Navigator.getNavigator()
     abstract fun start(view:V)
    abstract fun destroy()

}