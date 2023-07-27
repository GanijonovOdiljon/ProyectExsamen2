package com.example.proyek2.model

import android.content.Context
import android.content.SharedPreferences
import android.icu.lang.UProperty.AGE
import com.example.proyek2.util.Constants.EMAIL
import com.example.proyek2.util.Constants.PASS
import com.example.proyek2.util.Constants.PREFS_NAME
import javax.security.auth.callback.PasswordCallback

class SharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveData(email: String, pass: String, Age: String) {
        val edit = sharedPreferences.edit()
        edit.putString(EMAIL, email)
        edit.putString(PASS, pass)
        edit.putString(PREFS_NAME,Age)
        edit.apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clear() {
        val edit = sharedPreferences.edit()
        edit.clear()
        edit.apply()
    }
}