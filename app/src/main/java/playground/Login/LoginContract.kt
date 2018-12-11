package playground.Login

import android.view.View

interface LoginContract {

    interface LoginView {

        fun onLoginBtnClick(v: View)
        fun onLoginResult(result: Boolean?, code: Int)
        fun showLoader()
        fun hideLoader()
        fun showErrorToast()
        fun showSuccessToast()
    }

    interface LoginPresenter
    {
        fun doLogin(name:String,passwd:String)
        fun validation(name:String,passwd:String):Boolean
    }
}