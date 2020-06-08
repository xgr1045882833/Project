package com.aaronxie.messaging.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.fragment.ConversationListFragment;

public class ConversationList extends AppCompatActivity {
    private static final String TAG = ConversationList.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new ConversationListFragment())
                .commit();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String msg = "";
        switch (itemId) {
            case R.id.action_edit:
                msg += "Click edit";
                Log.i(TAG, "==========msg:" + msg);
                break;
            case R.id.action_more:
                msg += "Click more";
                Log.i(TAG, "==========msg:" + msg);
                View view = findViewById(R.id.action_more);
                showPopuMenu(view);
                break;
            default:
                msg += "Click nothing";
                Log.i(TAG, "==========msg:" + msg);
                break;

        }
        return true;
    }

    private void showPopuMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(ConversationList.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_more, popupMenu.getMenu());
        popupMenu.show();
    }
}
