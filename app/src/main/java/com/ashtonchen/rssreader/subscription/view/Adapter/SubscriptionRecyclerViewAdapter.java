package com.ashtonchen.rssreader.subscription.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashtonchen.rssreader.R;
import com.ashtonchen.rssreader.base.BaseRecyclerViewAdapter;
import com.ashtonchen.rssreader.subscription.listener.onSubscriptionListInteractionListener;
import com.ashtonchen.rssreader.subscription.model.Channel;
import com.ashtonchen.rssreader.subscription.view.widget.SubscriptionViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Channel} and makes a call to the
 * specified {@link onSubscriptionListInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SubscriptionRecyclerViewAdapter extends BaseRecyclerViewAdapter<Channel, SubscriptionViewHolder> {

    public SubscriptionRecyclerViewAdapter(List<Channel> list) {
        super(list);
    }

    @Override
    public SubscriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_cell, parent, false);
        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubscriptionViewHolder holder, int position) {
        Log.d(this.getClass().getSimpleName(), "adapter subscription: " + position);

        Context context = holder.mThumbnail.getContext();
        if (!mList.get(position).getThumbnailURL().isEmpty()) {
            Picasso.with(context).load(mList.get(position).getThumbnailURL()).into(holder.mThumbnail);
        }

        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mDescription.setText(mList.get(position).getDescription());

        holder.itemView.setOnClickListener(mOnClickListener);
        holder.itemView.setOnLongClickListener(mOnLongClickListener);
    }
}
