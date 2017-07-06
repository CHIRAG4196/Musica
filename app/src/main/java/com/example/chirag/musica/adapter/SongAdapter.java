package com.example.chirag.musica.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.musica.R;
import com.example.chirag.musica.databinding.ListSongBinding;

/**
 * Created by chirag on 27-Jun-17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private Context context;
    private ListSongBinding mBinding;
    private LayoutInflater inflater;

    public SongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_song, parent, false);
        return new ViewHolder(mBinding,parent);
    }

    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListSongBinding mBinding;
        public ViewHolder(ListSongBinding mBinding, View itemView) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }
    }
}
