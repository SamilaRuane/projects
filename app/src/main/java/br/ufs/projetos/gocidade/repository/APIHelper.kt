package br.ufs.projetos.gocidade.repository

import com.facebook.CallbackManager
import rx.Observable

/**
 * Created by samila on 14/11/17.
 */
interface ApiHelper {

    fun signInWithFacebook (callbackManager: CallbackManager) : Observable<Boolean>
    fun signInWithEmailAndPassword (email : String, password:String) : Observable<Boolean>
    fun signUpWithEmailAndPassword (email : String, password:String) : Observable<Boolean>
    fun isSigned () : Boolean
}