package com.playground.login


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.user.playground.R
import com.playground.base.BaseActivity.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity(), LoginContract.LoginView {

    var mPresenter: LoginPresenter = LoginPresenter(this)

    private lateinit var userName: EditText
    private lateinit var userPasswd: EditText
    private lateinit var btnLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        initView()
    }

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