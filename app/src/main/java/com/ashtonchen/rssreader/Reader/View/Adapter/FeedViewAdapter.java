package com.ashtonchen.rssreader.reader.view.adapter;

import com.ashtonchen.rssreader.base.RSSRecyclerViewAdapter;
import com.ashtonchen.rssreader.reader.model.Feed;
import com.ashtonchen.rssreader.reader.model.Feeds;

import java.util.List;

/**
 * Created by Ashton Chen on 16-01-26.
 */
public class FeedViewAdapter extends RSSRecyclerViewAdapter {

    @Override
    protected List<Feed> getData() {
        return Feeds.getFeeds();
    }
}
