package br.ufs.projetos.gocidade.repository

import com.facebook.CallbackManager
import rx.Observable

/**
 * Created by samila on 14/11/17.
 */
class AppDataManager : DataManager {

    val mApiHelper = AppApiHelper ()

    override fun signInWithFacebook(callbackManager: CallbackManager) : Observable <Boolean> {
        return mApiHelper.signInWithFacebook(callbackManager)
    }

    override fun signInWithEmailAndPassword(email: String, password: String) : Observable<Boolean> {
        return mApiHelper.signInWithEmailAndPassword(email, password)
    }

    override fun signUpWithEmailAndPassword(email: String, password: String) : Observable <Boolean> {
        return mApiHelper.signUpWithEmailAndPassword(email, password)
    }

    override fun isSigned(): Boolean {
        return mApiHelper.isSigned()
    }
}