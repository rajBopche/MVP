package com.playground.Login


import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.user.playground.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import com.playground.Base.BaseActivity.BaseActivity
import com.playground.Model.Database.AppDatabase
import com.playground.Model.Database.Gender
import com.playground.Model.Database.GenderDao


class LoginActivity : BaseActivity(), LoginContract.LoginView {

    private val mPresenter = LoginPresenter(this)
    private lateinit var userName: EditText
    private lateinit var userPasswd: EditText
    private lateinit var btnLogin: Button



    override fun onLoginBtnClick(v: View) {
        showLoader()
        mPresenter.doLogin(userName.text.toString(), userPasswd.text.toString())
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

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        userName = edt_user_name
        userPasswd = edt_user_password
        btnLogin = btn_login
    }

    override fun showErrorToast() {
        Toast.makeText(this, getString(R.string.error_toast), Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessToast() {
        Toast.makeText(this, getString(R.string.success_toast), Toast.LENGTH_SHORT).show()
    }

    override fun moveToNextScreen() {
        mPresenter.moveToNextActivity()
    }

}