package tech.blur.nstuctf.features.recovery;

import android.content.SharedPreferences;
import android.media.tv.TvContract;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import retrofit2.Retrofit;
import tech.blur.nstuctf.core.PreferencesApi;
import tech.blur.nstuctf.core.Token;
import tech.blur.nstuctf.core.model.RecoveryKey;
import tech.blur.nstuctf.core.model.User;
import tech.blur.nstuctf.core.network.Carry;
import tech.blur.nstuctf.core.network.DefaultCallback;
import tech.blur.nstuctf.core.network.RetrofitProvider;
import tech.blur.nstuctf.features.recovery.api.RecoverApi;

@InjectViewState
public class RecoveryPresenter extends MvpPresenter<RecoveryView> {

    private String passphrase;
    private RecoverApi api;
    private SharedPreferences prefs;

    public RecoveryPresenter() {
        Retrofit retrofit = new RetrofitProvider().getRetrofit();
        api = retrofit.create(RecoverApi.class);
    }

    void onPassphraseChanged(String s){
        passphrase = s;
    }

    void onRecoveryClicked(){
        api.recoverUser(new RecoveryKey(passphrase), PreferencesApi.getUser(prefs).getId(), Token.getToken())
                .enqueue(new DefaultCallback<>(new Carry<User>() {
                    @Override
                    public void onSuccess(User result) {
                        getViewState().onRecoveryComplete();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        getViewState().showMessage("Wrong passphrase");
                    }
                }));
    }

    public void setPrefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }
}
