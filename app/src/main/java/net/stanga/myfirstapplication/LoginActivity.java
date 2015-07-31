package net.stanga.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class LoginActivity extends Activity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final ImageButton imageButton = (ImageButton) findViewById(R.id.image_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setBackgroundResource(R.mipmap.ic_launcher);
                imageButton.setImageResource(android.R.drawable.arrow_up_float);
            }
        });

        final Button loginButton = (Button) findViewById(R.id.login_button);

        password = (EditText) findViewById(R.id.password);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == 999) {
                    loginButton.performClick();
                }

                return false;
            }
        });

        email = (EditText) findViewById(R.id.email);

    }

    public void onLoginClick(View view) {

        Button loginButton = (Button) view;
        loginButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_lock_power_off, 0);

        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        String userInfo = "Email: " + userEmail + " and password: " + userPassword;
        Toast.makeText(this, userInfo, Toast.LENGTH_LONG).show();


    }

}
