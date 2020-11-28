package com.aaronxie.messaging.activity;

import android.app.AlertDialog;
import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.VideoView;

import com.aaronxie.messaging.R;

import java.util.concurrent.locks.ReentrantLock;

public class ConversationActivity extends AppCompatActivity {

    private FrameLayout mADContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        mADContainer = findViewById(R.id.ad_container);
        ThreadLocal threadLocal;
        Looper.prepare();
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        LruCache<String, String> imgUrl = new LruCache<>(188);
        ReentrantLock reentrantLock = new ReentrantLock();
        MediaCodec mediaCodec;
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        VideoView videoView = new VideoView(this);


    }
}
