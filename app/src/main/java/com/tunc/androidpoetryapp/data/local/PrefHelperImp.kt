package com.tunc.androidpoetryapp.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PrefHelperImp @Inject constructor(context: Context) : PrefHelper {
    private val AUTHORIZATON_PREF_HELPER = "authorizationPref"


    var mPrefs: SharedPreferences = context.getSharedPreferences("Pref", Context.MODE_PRIVATE)


    override fun saveAuthorizationToken(authorizationToken: String) {
        mPrefs.edit().putString(AUTHORIZATON_PREF_HELPER, "Bearer $authorizationToken").apply()
    }

    override fun getAuthorizationToken(): String? {
        return mPrefs.getString(AUTHORIZATON_PREF_HELPER, "")
    }

}