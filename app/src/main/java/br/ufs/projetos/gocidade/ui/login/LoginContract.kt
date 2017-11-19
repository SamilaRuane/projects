package br.ufs.projetos.gocidade.ui.login

import com.facebook.CallbackManager
import java.util.*

/**
 * Created by samila on 13/11/17.
 */
interface LoginContract {

    interface View {
       fun showProgressBar (active : Boolean)
        fun onSuccess ()
        fun onError ()
        fun redirectTo(destinationClass : String)
    }

    interface Presenter {
        fun signInWithFacebook (callbackManager: CallbackManager)
        fun signInWithEmail(email : String, password : String)
        fun signUpWithEmail(email : String, password : String)
        fun isSigned ()

    }
}