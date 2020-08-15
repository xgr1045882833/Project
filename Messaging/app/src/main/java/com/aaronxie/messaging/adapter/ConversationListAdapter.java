package com.aaronxie.messaging.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaronxie.messaging.R;
import com.aaronxie.messaging.bean.User;

import java.util.List;

/**
 * create by Aaron Xie
 * on 2020/8/7
 * description:
 */
public class ConversationListAdapter extends RecyclerView.Adapter<ConversationListAdapter.ConversationListViewHolder> {
    private List<User> mUsers;

    public ConversationListAdapter(List<User> users) {
        this.mUsers = users;
    }

    @NonNull
    @Override
    public ConversationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conversation_list_item_view, parent, false);
        return new ConversationListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationListViewHolder holder, int position) {
        holder.mTvName.setText(mUsers.get(position).getName());
        String des = " " + mUsers.get(position).getAge();
        holder.mTvDes.setText(des);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    class ConversationListViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvName;
        private TextView mTvDes;

        private ConversationListViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvDes = itemView.findViewById(R.id.tv_description);
        }
    }
}
