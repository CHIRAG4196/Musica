package com.example.chirag.musica.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.musica.R;
import com.example.chirag.musica.databinding.ListMoreAlbumBinding;

/**
 * Created by chirag on 30-Jun-17.
 */

public class MoreAlbumAdapter extends RecyclerView.Adapter<MoreAlbumAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ListMoreAlbumBinding mBinding;

    public MoreAlbumAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MoreAlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_more_album,parent,false);
        return new ViewHolder(mBinding,parent);
    }

    @Override
    public void onBindViewHolder(MoreAlbumAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListMoreAlbumBinding mBinding;
        public ViewHolder(ListMoreAlbumBinding mBinding, View itemView) {

            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

    }
}
