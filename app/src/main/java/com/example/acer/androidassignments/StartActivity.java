package com.example.acer.androidassignments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "StartActivity";
    protected Button b_listItems, b_chat, b_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        b_listItems = findViewById(R.id.start_listItems_button);
        b_chat = findViewById(R.id.start_chat_button);

        b_listItems.setOnClickListener((x) -> {
            Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
            startActivityForResult(intent, 10);
        });
    }

    public void chat_button_clickListener(View view) {
        Log.i(ACTIVITY_NAME, "User clicked Start Chat");
        Intent intent = new Intent(StartActivity.this, ChatWindow.class);
        startActivity(intent);
    }

    public void toolbar_button_clickListener(View view) {
        Intent intent = new Intent(StartActivity.this, TestToolbar.class);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult()");
        }
        if (responseCode == Activity.RESULT_OK) {
            Log.i(ACTIVITY_NAME, "Activity.RESULT_OK");
            String messagePassed = data.getStringExtra("Response");
            CharSequence text = (CharSequence) messagePassed;
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(this , text, duration);
            toast.show(); //display your message box

        }
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
