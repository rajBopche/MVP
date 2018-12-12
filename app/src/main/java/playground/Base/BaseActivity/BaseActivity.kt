package playground.Base.BaseActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity(),BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView(getLayout())
        initView()
    }

    protected abstract fun getLayout():Int
    protected abstract fun initView()

    override fun setView(layoutId:Int) { setContentView(layoutId) }

    abstract override  fun showErrorToast()

    abstract override fun showSuccessToast()

}
