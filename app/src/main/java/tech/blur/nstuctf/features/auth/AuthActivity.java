package tech.blur.nstuctf.features.auth;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.Objects;

import tech.blur.nstuctf.R;
import tech.blur.nstuctf.core.DefaultTextWatcher;
import tech.blur.nstuctf.core.moxy.MvpAndroidxActivity;

public class AuthActivity extends MvpAndroidxActivity implements AuthView {

    EditText editLogin;
    EditText editPass;
    Button buttonSignIn;

    @InjectPresenter
    AuthPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_signin);

        editLogin = findViewById(R.id.edit_signin_login);
        editPass = findViewById(R.id.edit_signin_password);
        buttonSignIn = findViewById(R.id.signIn);

        editLogin.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onLoginChanged(s.toString());
            }
        });

        editPass.addTextChangedListener(new DefaultTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onPassChanged(s.toString());
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editLogin.getText().toString().isEmpty() && !editPass.getText().toString().isEmpty()) presenter.onSignInClicked();
                else Toast.makeText(getApplicationContext(), "Enter your account", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void authIsOk() {
        // open main activity
        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage() {
        Toast.makeText(getApplicationContext(), "neOK", Toast.LENGTH_SHORT).show();
    }
}