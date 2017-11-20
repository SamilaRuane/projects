package br.ufs.projetos.gocidade.repository

/**
 * Created by samila on 14/11/17.
 */
interface DataManager : ApiHelper{
    interface DataResult {
        fun onResult (b : Boolean, s : String)
    }
}