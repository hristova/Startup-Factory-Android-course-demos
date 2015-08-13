package net.stanga.myfirstapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.*;

public class RegisterActivity extends Activity {

    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        buttonRegister = (Button) findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saveUserData();
                saveDataInFile();
            }
        });
    }

    private void saveDataInFile() {
        EditText editName = (EditText) findViewById(R.id.edit_name);
        String name = editName.getText().toString();
        EditText editEmail = (EditText) findViewById(R.id.edit_email);
        String email = editEmail.getText().toString();
        EditText editPassword = (EditText) findViewById(R.id.edit_password);
        String password = editPassword.getText().toString();
        EditText editAge = (EditText) findViewById(R.id.edit_age);
        String ageString = editAge.getText().toString();
        int age;
        try {
            age = Integer.valueOf(ageString);
        } catch (NumberFormatException ex) {
            age = 20;
        }

        UserData user = new UserData();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);

        String fileName = "user";
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveUserData() {

        EditText editName = (EditText) findViewById(R.id.edit_name);
        String name = editName.getText().toString();
        EditText editEmail = (EditText) findViewById(R.id.edit_email);
        String email = editEmail.getText().toString();
        EditText editPassword = (EditText) findViewById(R.id.edit_password);
        String password = editPassword.getText().toString();
        EditText editAge = (EditText) findViewById(R.id.edit_age);
        String ageString = editAge.getText().toString();
        int age;
        try {
            age = Integer.valueOf(ageString);
        } catch (NumberFormatException ex) {
            age = 20;
        }

        SharedPreferences prefs = getSharedPreferences("com.example.test.PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("user_name", name);
        editor.putString("user_email", email);
        editor.putString("user_password", password);
        editor.putInt("user_age", age);
        editor.commit();

        readData();

    }

    private void readData() {

        SharedPreferences preferences = getSharedPreferences("com.example.test.PREFS", MODE_PRIVATE);
        String email = preferences.getString("user_email", "");
        String name = preferences.getString("user_name", "");
        String password = preferences.getString("user_password", "");
        int age = preferences.getInt("user_age", 20);

        String data = email + "\n" + password + "\n" + name + "\n" + age;
        Log.i("Data", data);

    }
}
