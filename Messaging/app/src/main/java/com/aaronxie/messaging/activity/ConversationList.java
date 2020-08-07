package com.aaronxie.messaging.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.fragment.ConversationListFragment;
import com.aaronxie.messaging.fragment.ConversationListTabFragment;
import com.aaronxie.messaging.utils.SPUtil;

public class ConversationList extends AppCompatActivity
        implements ConversationListTabFragment.OnFragmentInteractionListener {
    private static final String TAG = ConversationList.class.getSimpleName();
    private FragmentManager mFragmentManager;
    private boolean mIsTabMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new OnMenuItemClickListenerImpl());
        mIsTabMode = (boolean) SPUtil.get(this, SPUtil.IS_TAB_MODE, true);
        Log.i(TAG, "=========onCreate isChecked:" + SPUtil.get(
                this, SPUtil.IS_TAB_MODE, true));
        mFragmentManager = getSupportFragmentManager();
        if (mIsTabMode) {
            startFragment(new ConversationListTabFragment(), "TabFragment");
        } else {
            startFragment(new ConversationListFragment(), "ListFragment");
        }
    }

    private void startFragment(Fragment fragment, String tag) {
        if (fragment == null) {
            return;
        }
        Fragment oldFragment = mFragmentManager.findFragmentByTag(tag);
        if (oldFragment!=null&&oldFragment.getClass().equals(fragment.getClass())) {
            return;
        }
        mFragmentManager
                .beginTransaction()
                .replace(R.id.conversation_list_fragment_container, fragment, tag)
                .commitAllowingStateLoss();
    }


    private void showPopuMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(ConversationList.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_more, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.action_settings:
                        Log.i(TAG, "==========msg:settings");
                        Intent intent = new Intent(
                                ConversationList.this, SettingsActivity.class);
                        //startActivity(intent);
                        startActivityForResult(intent, 1);
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mIsTabMode = (boolean) SPUtil.get(this, SPUtil.IS_TAB_MODE, true);
        Log.i(TAG, "=========onActivityResult isChecked:" + SPUtil.get(
                this, SPUtil.IS_TAB_MODE, true));
        if (mIsTabMode) {
            startFragment(new ConversationListTabFragment(), "TabFragment");
        } else {
            startFragment(new ConversationListFragment(), "ListFragment");
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private class OnMenuItemClickListenerImpl implements Toolbar.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            int itemId = item.getItemId();
            String msg = "";
            switch (itemId) {
                case R.id.action_add:
                    startActivity(new Intent(ConversationList.this, ConversationActivity.class));
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
    }

}
