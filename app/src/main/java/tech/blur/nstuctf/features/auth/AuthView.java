package tech.blur.nstuctf.features.auth;

import com.arellomobile.mvp.MvpView;

public interface AuthView extends MvpView {

    void authIsOk();
    void showMessage(String s);

}
