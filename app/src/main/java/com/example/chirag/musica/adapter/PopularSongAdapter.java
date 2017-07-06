package com.example.chirag.musica.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.chirag.musica.R;
import com.example.chirag.musica.databinding.ListPopularSongBinding;

/**
 * Created by chirag on 30-Jun-17.
 */

public class PopularSongAdapter extends RecyclerView.Adapter<PopularSongAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ListPopularSongBinding mBinding;

    public PopularSongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PopularSongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_popular_song,parent,false);
        return new ViewHolder(mBinding,parent);
    }

    @Override
    public void onBindViewHolder(PopularSongAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListPopularSongBinding mBinding;
        public ViewHolder(ListPopularSongBinding mBinding, ViewGroup parent) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }
    }
}
