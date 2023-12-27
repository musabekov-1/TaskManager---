package com.example.taskmanager.data.local

import android.content.Context

class Pref(context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    fun  getName():String?{
        return pref.getString(PRPOFILE_NAME,null)
    }
    fun  saveName(name:String){
        pref.edit().putString(PRPOFILE_NAME,name).apply()
    }
    fun  getImg():String?{
        return pref.getString(PROF_IMG,null)
    }
    fun  saveImg(img:String){
        pref.edit().putString(PROF_IMG,img).apply()
    }
    fun isBoardingShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onBoarDingShowed() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object {
        const val PROF_IMG="prof.img"
        const val PRPOFILE_NAME="prof.name"
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
    }
}