package tech.blur.nstuctf.core;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import tech.blur.nstuctf.core.model.User;

public class PreferencesApi {

    private final String sharedPreferencesName = "pro.skyhome.skybox.prefs";
    private enum PrefsNames {JWT, USER}

    void setJwt (String jwt, SharedPreferences prefs){
        prefs.edit().putString(PrefsNames.JWT.name(), jwt).apply();
    }

    String getJwt (SharedPreferences prefs){
        return prefs.getString(PrefsNames.JWT.name(), null);
    }

    void setUser (User user, SharedPreferences prefs){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefs.edit().putString(PrefsNames.USER.name(), json).apply();
    }

    User getUser (SharedPreferences prefs){
        Gson gson = new Gson();
        String json = prefs.getString(PrefsNames.USER.name(), null);
        return gson.fromJson(json, User.class);
    }
}
