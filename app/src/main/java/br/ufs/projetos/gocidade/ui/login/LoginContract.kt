package br.ufs.projetos.gocidade.ui.login

import com.facebook.CallbackManager

/**
 * Created by samila on 13/11/17.
 */
interface LoginContract {

    interface View {
       fun showProgressBar (active : Boolean)
    }

    interface Presenter {
        fun signInWithFacebook (callbackManager: CallbackManager)
        fun signInWithEmail(email : String, password : String)
    }
}