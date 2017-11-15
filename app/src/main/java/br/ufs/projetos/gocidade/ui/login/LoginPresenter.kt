package br.ufs.projetos.gocidade.ui.login

import br.ufs.projetos.gocidade.repository.AppDataManager
import br.ufs.projetos.gocidade.repository.DataManager
import com.facebook.CallbackManager

/**
 * Created by samila on 13/11/17.
 */
class LoginPresenter : LoginContract.Presenter {

    var mView : LoginContract.View
    val mDataManager : DataManager = AppDataManager ()

    constructor(mView: LoginContract.View) {
        this.mView = mView
    }


    override fun signInWithFacebook(callbackManager: CallbackManager) {
        mDataManager.signInWithFacebook(callbackManager)
    }

    override fun signInWithEmail(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}