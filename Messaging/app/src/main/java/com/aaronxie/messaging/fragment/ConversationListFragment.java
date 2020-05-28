package com.aaronxie.messaging.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.viewmodel.ConversationListViewModel;

public class ConversationListFragment extends Fragment {

    private ConversationListViewModel mViewModel;

    public static ConversationListFragment newInstance() {
        return new ConversationListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conversation_list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ConversationListViewModel.class);
        // TODO: Use the ViewModel
    }

}
