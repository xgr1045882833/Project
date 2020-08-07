package com.aaronxie.messaging.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaronxie.messaging.R;

/**
 * create by Aaron Xie
 * on 2020/8/7
 * description:
 */
public class ConversationListAdapter extends RecyclerView.Adapter<ConversationListAdapter.ConversationListViewHolder> {

    @NonNull
    @Override
    public ConversationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conversation_list_item_view, parent, false);
        return new ConversationListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ConversationListViewHolder extends RecyclerView.ViewHolder {

        private ConversationListViewHolder(View itemView) {
            super(itemView);
        }
    }
}
