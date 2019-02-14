package tech.blur.nstuctf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import tech.blur.nstuctf.core.LocalNavigator;

public class MainActivity extends AppCompatActivity {

    private Router localRouter;
    private NavigatorHolder localNavigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cicerone<Router> cicerone;
        cicerone = Cicerone.create();
        localNavigatorHolder = cicerone.getNavigatorHolder();
        localNavigatorHolder.setNavigator(new LocalNavigator(getSupportFragmentManager(), R.id.fragmentHolder));



    }

}
