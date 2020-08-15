package com.aaronxie.messaging.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.adapter.ConversationListAdapter;
import com.aaronxie.messaging.bean.User;
import com.aaronxie.messaging.viewmodel.ConversationListViewModel;

import java.util.List;

public class ConversationListFragment extends Fragment {
    private static final String TAG = ConversationListFragment.class.getSimpleName();
    private Context mContext;
    private ConversationListViewModel mViewModel;
    private ConversationListAdapter mConversationListAdapter;
    private List<User> mUsers;
    private RecyclerView mRecyclerView;

    public static ConversationListFragment newInstance() {
        return new ConversationListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null) {
            mContext = context;
        } else {
            throw new NullPointerException("context is null");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conversation_list, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view_conversation_list);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ConversationListViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mUsers = users;
                Log.i(TAG, "==========users.size():" + users.size());
                setAdapter();
            }
        });
        mViewModel.setUserLiveData();
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    private void setAdapter() {
        mConversationListAdapter = new ConversationListAdapter(mUsers);
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mConversationListAdapter);
        }
    }

}
