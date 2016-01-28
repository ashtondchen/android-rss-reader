package com.ashtonchen.rssreader.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.ashtonchen.rssreader.main.helper.ActionBarColorHelper;
import com.ashtonchen.rssreader.main.view.MainActivity;

/**
 * Created by Ashton Chen on 15-12-17.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected MainActivity mMainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mMainActivity = (MainActivity) mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container,
                savedInstanceState);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        ActionBarColorHelper.colorizeToolbar(mMainActivity.getToolbar(), Color.WHITE);
    }

    protected void setSubtitle(int subtitle) {
        mMainActivity.getSupportActionBar().setSubtitle(getString(subtitle));
    }
}