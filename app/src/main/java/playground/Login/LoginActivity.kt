package playground.Login


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.user.playground.R



class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    val mPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onLoginBtnClick(v: View) {
         showLoader()
        mPresenter.doLogin("poonam@gmail.com","sms123")
    }

    override fun showLoader() {
        //loader shown
    }

    override fun onLoginResult(result: Boolean?, code: Int) {
        hideLoader()
        //Spread Data()
    }

    override fun hideLoader() {
        //loader hidden
    }

    override fun showErrorToast() {
        Toast.makeText(this, "Oops Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessToast() {
        Toast.makeText(this, "welcome ", Toast.LENGTH_SHORT).show()
    }
}