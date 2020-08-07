package com.aaronxie.messaging.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.adapter.ConversationListAdapter;
import com.aaronxie.messaging.viewmodel.ConversationListViewModel;

public class ConversationListFragment extends Fragment {

    private Context mContext;
    private ConversationListViewModel mViewModel;
    private ConversationListAdapter mConversationListAdapter;
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
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mConversationListAdapter = new ConversationListAdapter();
        mRecyclerView.setAdapter(mConversationListAdapter);
    }

}
