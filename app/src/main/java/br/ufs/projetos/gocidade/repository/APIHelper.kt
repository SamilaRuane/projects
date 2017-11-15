package br.ufs.projetos.gocidade.repository

import com.facebook.CallbackManager

/**
 * Created by samila on 14/11/17.
 */
interface ApiHelper {

    fun signInWithFacebook (callbackManager: CallbackManager)
}