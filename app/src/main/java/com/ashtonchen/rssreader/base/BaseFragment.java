package com.ashtonchen.rssreader.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    protected MainActivity mContext;
    protected float mScale;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity) getActivity();
        mScale = mContext.getResources().getDisplayMetrics().density;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mScale = 0f;
        mContext = null;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        ActionBarColorHelper.colorizeToolbar(mContext.getToolBar(), Color.WHITE);
    }

    protected final void setSubtitle(int subtitle) {
        mContext.getSupportActionBar().setSubtitle(getString(subtitle));
    }
}
