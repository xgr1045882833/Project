package com.aaronxie.messaging.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.adapter.MyFragmentPagerAdapter;
import com.aaronxie.messaging.fragment.MessageFragment;
import com.aaronxie.messaging.fragment.NotificationFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConversationList extends AppCompatActivity {
    private static final String TAG = ConversationList.class.getSimpleName();
    private List<String> mTitles;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new OnMenuItemClickListenerImpl());
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
        initView();
    }

    private void initData() {
        mTitles = new ArrayList<>();
        String[] titles = this.getResources().getStringArray(R.array.tab_array);
        Collections.addAll(mTitles, titles);

        mFragments = new ArrayList<>();
        mFragments.add(new MessageFragment());
        mFragments.add(new NotificationFragment());
    }

    private void initView() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(
                new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
        tabLayout.setupWithViewPager(viewPager);
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
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private class OnMenuItemClickListenerImpl implements Toolbar.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
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
    }

}
