package tech.blur.nstuctf.features.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import tech.blur.nstuctf.R;
import tech.blur.nstuctf.core.moxy.MvpAndroidxActivity;

public class MainActivity extends MvpAndroidxActivity implements MainActivityView {

    @InjectPresenter
    MainActivityPresenter presenter;

    public static void start(Context context){
        final Intent intent = new Intent(context, MainActivity.class);

        //intent.putExtra("isAuth", isAuthAc);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void onBackPressed() {

    }

}
