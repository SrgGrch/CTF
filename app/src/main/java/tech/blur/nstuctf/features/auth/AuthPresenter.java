package tech.blur.nstuctf.features.auth;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import retrofit2.Retrofit;
import tech.blur.nstuctf.core.PreferencesApi;
import tech.blur.nstuctf.core.model.User;
import tech.blur.nstuctf.core.model.UserAuth;
import tech.blur.nstuctf.core.network.Carry;
import tech.blur.nstuctf.core.network.DefaultCallback;
import tech.blur.nstuctf.core.network.RetrofitProvider;
import tech.blur.nstuctf.features.auth.api.AuthApi;

@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView> {

    private String login;
    private String pass;
    private SharedPreferences prefs;
    AuthApi api;

    AuthPresenter(){
        Retrofit retrofit = new RetrofitProvider().getRetrofit();
        api = retrofit.create(AuthApi.class);
    }


    public void setPrefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    void onLoginChanged(String s){
        login = s;
    }

    void onPassChanged(String s){
        pass = s;
    }

    void onSignInClicked(){
        if (!pass.isEmpty() && !login.isEmpty()) {
            api.CheckUser(new UserAuth(login, pass)).enqueue(new DefaultCallback<>(new Carry<User>() {
                @Override
                public void onSuccess(User result) {
                    PreferencesApi.setUser(result, prefs);
                    if (result.getTrusted() == 0) getViewState().openRecovery();
                    else getViewState().openMainActivity();
                }

                @Override
                public void onFailure(Throwable throwable) {
                    getViewState().showMessage("Auth failed");
                }
            }));
        }
    }

}
