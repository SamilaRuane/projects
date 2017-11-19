package br.ufs.projetos.gocidade.repository

import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import rx.Observable

/**
 * Created by samila on 14/11/17.
 */
class AppApiHelper : ApiHelper {


    val mAuth = FirebaseAuth.getInstance()

    override fun signInWithFacebook(callbackManager: CallbackManager) : Observable<Boolean>{
        var success = false

        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

            override fun onError(error: FacebookException?) {

                Log.i ("GCityLog", "Error" )
            }

            override fun onCancel() {
                Log.i ("GCityLog", "Cancelled" )
            }

            override fun onSuccess(result: LoginResult?) {
                Log.i ("GCityLog", "Success ${result.toString()}" )
                success = true
            }
        })

        return Observable.just(success)

    }

    override fun signInWithEmailAndPassword(email: String, password: String) : Observable<Boolean> {
        var success : Boolean = false
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->   success = task.isSuccessful
        }
        return Observable.just(success)
    }

    override fun signUpWithEmailAndPassword(email: String, password: String) : Observable<Boolean> {
        var success : Boolean = false
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->   success = task.isSuccessful }
        return Observable.just(success)
    }


    override fun isSigned(): Boolean {
         return mAuth.currentUser != null
    }
}