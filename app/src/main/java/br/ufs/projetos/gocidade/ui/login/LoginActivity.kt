package br.ufs.projetos.gocidade.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.ufs.projetos.gocidade.R
import br.ufs.projetos.gocidade.ui.main.MainActivity
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View{

    var callbackManager: CallbackManager
    lateinit var mLoginPresenter : LoginContract.Presenter

    init {
        callbackManager = CallbackManager.Factory.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_login)

        mLoginPresenter = LoginPresenter (this)

        mLoginPresenter.signInWithFacebook(callbackManager)

        btn_login.setOnClickListener { startActivity(Intent(this, MainActivity ::class.java)) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun showProgressBar(active: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
