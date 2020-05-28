package com.aaronxie.messaging.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.fragment.ConversationListFragment;

public class ConversationList extends AppCompatActivity {

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener =
            new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String msg = "";
                    switch (item.getItemId()) {
                        case R.id.action_edit:
                            msg += "Click edit";
                            break;
                        case R.id.action_share:
                            msg += "Click share";
                            break;
                        case R.id.action_settings:
                            msg += "Click setting";
                            break;
                    }
                    if (!msg.equals("")) {
                        Toast.makeText(ConversationList.this, msg, Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new ConversationListFragment())
                .commit();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        toolbar.setNavigationContentDescription("编辑");
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("谢国荣");
        toolbar.setSubtitle("18819215282");
        setSupportActionBar(toolbar);
        //toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
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
                break;
            case R.id.action_share:
                msg += "Click share";
                break;
            case R.id.action_settings:
                msg += "Click setting";
                break;
        }
        if (!msg.equals("")) {
            Toast.makeText(ConversationList.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
