package com.example.acer.androidassignments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;

import SharedPreferences;

public class LoginActivity extends Activity {

    String preferences_file = "androidassignments_preferences_file";
    protected static final String ACTIVITY_NAME = "LoginActivity";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        editText = (EditText) findViewById(R.id.username_edittext);
        Button button = findViewById(R.id.login_button);
        SharedPreferences sharedPref = getSharedPreferences("email", Context.MODE_PRIVATE);
        Button myButton = (Button)findViewById(R.id.login_button);
        String email = sharedPref.getString("defaultEmail", "email@default.com;");
        editText.setText(email);

        button.setOnClickListener((x) -> {
            SharedPreferences pref = getSharedPreferences("email",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("email", editText.getText().toString());
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
}
