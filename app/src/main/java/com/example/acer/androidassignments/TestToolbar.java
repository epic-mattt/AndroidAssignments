package com.example.acer.androidassignments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class TestToolbar extends AppCompatActivity {

    static private final String ACTIVITY_NAME = "TOOL_BAR";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "(meta) Something that I have writen", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        int i_id = mi.getItemId();
        switch (i_id) {
            case R.id.action_one:
                Log.d(ACTIVITY_NAME, "Action one selected");
                Snackbar.make(CoordinatorL, "(meta) Something that I have writen", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.action_two:
                Log.d(ACTIVITY_NAME, "Action two selected");
                break;
            case R.id.action_three:
                Log.d(ACTIVITY_NAME, "Action three selected");
                break;
            case R.id.toolbar_about:
                Log.d(ACTIVITY_NAME, "About action selected");
                CharSequence text = (CharSequence)  "Version 1.0 by Matthew Buchanan";
                Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
                toast.show();
                break;
        }
        return true;
    }

}
