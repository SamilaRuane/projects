package br.ufs.projetos.gocidade.repository

import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

/**
 * Created by samila on 14/11/17.
 */
class AppApiHelper : ApiHelper {



    override fun signInWithFacebook(callbackManager: CallbackManager) {
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

            override fun onError(error: FacebookException?) {

                Log.i ("GCityLog", "Error" )
            }

            override fun onCancel() {
                Log.i ("GCityLog", "Cancelled" )
            }

            override fun onSuccess(result: LoginResult?) {
                Log.i ("GCityLog", "Success ${result.toString()}" )
            }
        })

    }
}