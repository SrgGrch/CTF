package tech.blur.nstuctf;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import tech.blur.nstuctf.core.moxy.MvpAndroidxActivity;

public class MainActivity extends MvpAndroidxActivity implements MainActivityView {

    @InjectPresenter
    MainActivityPresenter presenter;


    private Router localRouter;
    private NavigatorHolder localNavigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cicerone<Router> cicerone;
        cicerone = Cicerone.create();
        localNavigatorHolder = cicerone.getNavigatorHolder();
        //localNavigatorHolder.setNavigator(new LocalNavigator(getSupportFragmentManager(), R.id.fragmentHolder));

    }

}
