package com.aaronxie.messaging.ListenerImpl;

import android.widget.CompoundButton;

import com.aaronxie.messaging.utils.SPUtil;

/**
 * create by Aaron Xie
 * on 2020/7/16
 * description:
 */
public class SwitchOnCheckedChangeListenerImpl implements CompoundButton.OnCheckedChangeListener {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SPUtil.put(buttonView.getContext(), SPUtil.IS_TAB_MODE, isChecked);
    }
}
