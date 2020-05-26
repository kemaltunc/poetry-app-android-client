package com.tunc.androidpoetryapp.data.local

interface PrefHelper {
    fun saveAuthorizationToken(authorizationToken: String)
    fun getAuthorizationToken(): String?
}