package com.example.chirag.musica.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.musica.R;
import com.example.chirag.musica.databinding.ListAlbumBinding;

/**
 * Created by chirag on 29-Jun-17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ListAlbumBinding mBinding;

    public AlbumAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_album, parent, false);
        return new AlbumAdapter.ViewHolder(mBinding,parent);
    }

    @Override
    public void onBindViewHolder(AlbumAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListAlbumBinding mBinding;

        public ViewHolder(ListAlbumBinding mBinding, View itemView) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;

        }
    }
}
