package tech.blur.nstuctf.features.auth;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.blur.nstuctf.App;
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
    AuthApi api;

    AuthPresenter(){
        Retrofit retrofit = new RetrofitProvider().getRetrofit();
        api = retrofit.create(AuthApi.class);
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
                    getViewState().authIsOk();
                }

                @Override
                public void onFailure(Throwable throwable) {
                    getViewState().showMessage();
                }
            }));
        }
    }

}
