package com.example.acer.androidassignments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "ListItemsActivity";

    ImageButton picButton;
    Switch sw;
    CheckBox cb;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        picButton = findViewById(R.id.pic_button);
        sw = findViewById(R.id.list_switch);
        cb = findViewById(R.id.list_checkbox);

        cb.setOnCheckedChangeListener((x, isChecked) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
            // 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                    .setTitle(R.string.dialog_title)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent resultIntent = new Intent(  );
                            resultIntent.putExtra("Response", "ListItemsActivity passed: My information to share");
                            setResult(Activity.RESULT_OK, resultIntent);
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        });

        sw.setOnCheckedChangeListener((x, isChecked) -> {
            if (isChecked == true) {
                CharSequence text = "Switch is On";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
                toast.show(); //display your message box
            }else if (isChecked == false) {
                CharSequence text = "Switch is Off";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(this , text, duration); //this is the ListActivity
                toast.show(); //display your message box
            }
        });

        picButton.setOnClickListener((x) -> {
            dispatchTakePictureIntent();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            picButton.setImageBitmap(imageBitmap);
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
