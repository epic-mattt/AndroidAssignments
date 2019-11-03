package com.example.acer.androidassignments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(Context context) {
            super(context, 0);
        }

        public int getCount() {
            return chat_strings.size();
        }

        public String getItem(int index) {
            return chat_strings.get(index);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // get the layoutInflater for the Activity that we are in.
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            LinearLayout result;
            // inflate the correct layout into a View.
            if (position % 2 == 0) {
                result = (LinearLayout) inflater.inflate(R.layout.chat_row_incoming, null);
            }else {
                result = (LinearLayout) inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            // find the sub-View which I need to mutate. (or multiple)
            TextView message = result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;
        }
    }

    protected static final String ACTIVITY_NAME = "CHAT_WINDOW";
    private ChatAdapter chatAdapter;
    private ListView chat_listView;
    private Button chat_send_button;
    private EditText chat_editText;
    private ArrayList<String> chat_strings;
    private SQLiteDatabase database;

    public void send_button_clickListener(View view) {
        String message = chat_editText.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ChatDatabaseHelper.COLUMN2, message);
        database.insert(ChatDatabaseHelper.TABLE_NAME, null, values);

        chat_strings.add(message);
        chatAdapter.notifyDataSetChanged();
        chat_editText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        chat_strings = new ArrayList<>();
        chat_listView = findViewById(R.id.chat_listView);
        chat_editText = findViewById(R.id.chat_editText);
        chat_send_button = findViewById(R.id.chat_send_button);
        chatAdapter = new ChatAdapter(this);
        chat_listView.setAdapter(chatAdapter);

        ChatDatabaseHelper chatdh = new ChatDatabaseHelper(this);
        database = chatdh.getReadableDatabase();
        String[] columns = {"message"};
        Cursor cursor = database.query("Messages", columns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast() ) {
            String message = cursor.getString(cursor.getColumnIndex(ChatDatabaseHelper.COLUMN2));
            Log.i(ACTIVITY_NAME, "SQL_MESSAGE" + message);
            cursor.moveToNext();
            chat_strings.add(message);
        }
        int columnCount = cursor.getColumnCount();
        Log.i(ACTIVITY_NAME, "Cursors's column count = " + columnCount);
        for (int i = 0; i < columnCount; i++) {
            Log.i(ACTIVITY_NAME, "Column id = " + i + " , Column name = " + cursor.getColumnName(i));
        }
        cursor.close();

    }

    protected void onDestroy() {
        super.onDestroy();
        database.close();
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
