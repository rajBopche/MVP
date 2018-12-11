package playground.Login

import android.text.TextUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import playground.Login.LoginContract
import playground.Model.LoginResponse
import playground.Network.ApiClient
import playground.Network.ApiService
import retrofit2.create

class LoginPresenter(val mView:LoginContract.LoginView):LoginContract.LoginPresenter
{

    val apiClient = ApiClient.getClient().create(ApiService::class.java)

    override fun doLogin(name: String, passwd: String) {

        if (validation(name, passwd)){
            apiClient.login(name, passwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<LoginResponse> {

                    override fun onComplete() {
                        mView.showSuccessToast()
                    }

                    override fun onSubscribe(d: Disposable) {
                        //
                    }

                    override fun onNext(t: LoginResponse) {
                        //
                    }

                    override fun onError(e: Throwable) {
                        mView.showErrorToast()
                    }
                })

        }else{
            //show some error message
        }
    }

    override fun validation(name: String, passwd: String):Boolean {
        return (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(passwd))
    }
}