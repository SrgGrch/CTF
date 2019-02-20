package tech.blur.nstuctf.features.recovery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import tech.blur.nstuctf.R;
import tech.blur.nstuctf.core.DefaultTextWatcher;
import tech.blur.nstuctf.core.PreferencesApi;
import tech.blur.nstuctf.core.moxy.MvpAndroidxActivity;
import tech.blur.nstuctf.features.main.MainActivity;

public class RecoveryActivity extends MvpAndroidxActivity implements RecoveryView {


    @InjectPresenter
    RecoveryPresenter presenter;


    public static void start(Context context) {
        final Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.setPrefs(getSharedPreferences(
                PreferencesApi.sharedPreferencesName,
                Context.MODE_PRIVATE
        ));

        final EditText recoveryPassphrase = findViewById(R.id.recovery_passphrase);
        Button recover = findViewById(R.id.recover_button);

        recoveryPassphrase.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onPassphraseChanged(s.toString());
            }
        });

        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!recoveryPassphrase.getText().toString().isEmpty())
                    presenter.onRecoveryClicked();
                else
                    Toast.makeText(getApplicationContext(), "Enter your account", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRecoveryComplete() {
        MainActivity.start(this);
    }
}
