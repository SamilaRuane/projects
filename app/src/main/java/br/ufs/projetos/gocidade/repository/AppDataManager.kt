package br.ufs.projetos.gocidade.repository

import com.facebook.CallbackManager

/**
 * Created by samila on 14/11/17.
 */
class AppDataManager : DataManager {

    val mApiHelper = AppApiHelper ()

    override fun signInWithFacebook(callbackManager: CallbackManager) {
        mApiHelper.signInWithFacebook(callbackManager)
    }
}