package tech.blur.nstuctf.core

import android.content.SharedPreferences
import com.google.gson.Gson
import org.json.JSONObject
import tech.blur.nstuctf.core.model.User

class PreferencesApiOld {

    companion object {
        const val sharedPreferencesName = "pro.skyhome.skybox.prefs"
        private enum class PrefNames {JWT, USER}

        fun setJwt(jwt: String, prefs: SharedPreferences) {
            prefs.edit().putString(PrefNames.JWT.name, jwt).apply()
        }

        fun getJwt(prefs: SharedPreferences): String? {
            return prefs.getString(PrefNames.JWT.name, null)
        }

        fun setUser(prefs: SharedPreferences, user: User) {
            val gson = Gson()
            val json = gson.toJson(user)
            prefs.edit().putString(PrefNames.USER.name, json).apply() //to json
        }

        fun getUser(prefs:SharedPreferences): User {
            val gson = Gson()
            val json = prefs.getString(PrefNames.USER.name, null)
            val jsonRoot = JSONObject(prefs.getString(PrefNames.USER.name, null))

            return gson.fromJson(jsonRoot.toString(), User::class.java)
        }
    }
}