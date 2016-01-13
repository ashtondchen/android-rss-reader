package com.ashtonchen.rssreader.Reader.View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashtonchen.rssreader.BaseRecyclerViewAdapter;
import com.ashtonchen.rssreader.R;
import com.ashtonchen.rssreader.Reader.Interface.OnListFragmentInteractionListener;
import com.ashtonchen.rssreader.Reader.Model.Channel;
import com.ashtonchen.rssreader.Reader.Model.Feeds;
import com.ashtonchen.rssreader.Reader.View.Widget.FeedViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by ashtonchen on 15-12-09.
 */
public class FeedViewAdapter
        extends BaseRecyclerViewAdapter<FeedViewHolder> {

    //private Channel mData;
    private OnListFragmentInteractionListener mCallback;

    public FeedViewAdapter(Context context, OnListFragmentInteractionListener callback) {
        mCallback = callback;
    }

    public void setData(Channel data) {
        notifyDataSetChanged();
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_cell, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder viewHolder, int position) {
        Log.d("FeedViewAdapter", "position = " + position);
        FeedViewHolder holder = viewHolder;
        holder.mData = Feeds.get(position);

        Context context = holder.mThumbnail.getContext();
        Log.d(this.getClass().getName(), "Thumbnail URL = " + holder.mData.getThumbnailURL());
        Log.d(this.getClass().getName(), "Web Thumbnail URL = " + holder.mData.getWebThumbnailURL());

        if (!holder.mData.getThumbnailURL().isEmpty()) {
            Picasso.with(context).load(holder.mData.getThumbnailURL()).into(holder.mThumbnail);
        } else if (!holder.mData.getWebThumbnailURL().isEmpty()) {
            Picasso.with(context).load(holder.mData.getWebThumbnailURL()).into(holder.mThumbnail);
        }

        holder.mTitle.setText(Feeds.get(position).getTitle());

        Log.d("FeedViewAdapter", "description = " + Feeds.get(position).getDescription());
        holder.mDescription.setText(Feeds.get(position).getDescription());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback.onItemClick(v, String.valueOf(index));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("FeedViewAdapter", "data size = " + Feeds.size());
        return Feeds.size();
    }
}