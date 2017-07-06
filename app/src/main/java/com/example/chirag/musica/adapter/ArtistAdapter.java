package com.example.chirag.musica.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.musica.R;
import com.example.chirag.musica.databinding.ListArtistBinding;

/**
 * Created by chirag on 29-Jun-17.
 */

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    private Context context;
    private ListArtistBinding mBinding;
    private LayoutInflater inflater;
    public ArtistAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_artist, parent, false);
        return new ViewHolder(mBinding,parent);
    }

    @Override
    public void onBindViewHolder(ArtistAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListArtistBinding mBinding;
        public ViewHolder(ListArtistBinding mBinding, View itemView) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

    }
}
