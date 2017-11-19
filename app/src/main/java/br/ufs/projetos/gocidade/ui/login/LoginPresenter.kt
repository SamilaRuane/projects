package br.ufs.projetos.gocidade.ui.login

import android.util.Log
import br.ufs.projetos.gocidade.repository.AppDataManager
import br.ufs.projetos.gocidade.repository.DataManager
import com.facebook.CallbackManager
import rx.Subscriber

/**
 * Created by samila on 13/11/17.
 */
class LoginPresenter : LoginContract.Presenter {

    var mView : LoginContract.View
    val mDataManager : DataManager = AppDataManager ()
    val TAG =  "GCity"

    constructor(mView: LoginContract.View) {
        this.mView = mView
    }

    override fun signUpWithEmail(email: String, password: String) {
        val subscriber = object : Subscriber <Boolean> (){
            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }

            override fun onCompleted() {
                Log.i(TAG, "onCompleted")
            }

            override fun onNext(t: Boolean?) {
                if (t != null){
                    if (t){
                       mView.onSuccess()
                    }else{
                        mView.onError()
                    }
                }
            }
        }

        mDataManager.signUpWithEmailAndPassword(email, password).subscribe(subscriber)
    }


    override fun signInWithFacebook(callbackManager: CallbackManager) {

        val subscriber = object : Subscriber <Boolean> (){
            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }

            override fun onCompleted() {
                Log.i(TAG, "onCompleted")
            }

            override fun onNext(t: Boolean?) {
                if (t != null){
                    if (t){
                        mView.onSuccess()
                        mView.redirectTo("MainActivity")
                    }else{
                        mView.onError()
                    }
                }
            }
        }
        mDataManager.signInWithFacebook(callbackManager).subscribe(subscriber)
    }

    override fun signInWithEmail(email: String, password: String) {
        val subscriber = object : Subscriber <Boolean> (){
            override fun onError(e: Throwable?) {
                e?.printStackTrace()
            }

            override fun onCompleted() {
                Log.i(TAG, "onCompleted")
            }

            override fun onNext(t: Boolean?) {
                Log.i(TAG, "onCompleted $t")
                if (t != null){
                    if (t){
                        mView.onSuccess()
                    }else{
                        mView.onError()
                    }
                }
            }
        }

        mDataManager.signInWithEmailAndPassword(email, password).subscribe(subscriber)
    }

    override fun isSigned() {
        if (mDataManager.isSigned()){
            mView.redirectTo("MainActivity")
        }
    }
}