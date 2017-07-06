package com.example.chirag.musica;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chirag.musica.adapter.PopularSongAdapter;
import com.example.chirag.musica.databinding.ActivityPopularSongBinding;

public class PopularSongActivity extends AppCompatActivity {

    private ActivityPopularSongBinding mBinding;
    private float imgX;
    private boolean isStart;
    private float imgY;
    private float imgHeight, imgWidth;
    private int toolbaHeight;
    private float ivBackX;
    private float imgBackY;
    private float tvPlayAlpha;
    private float tvFollowerAlpha;
    private float tvFollowAlpha;
    private float tvArtistNameY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_popular_song);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mBinding.actRvPopularSong.setLayoutManager(layoutManager);
        PopularSongAdapter popularSongAdapter = new PopularSongAdapter(this);
        mBinding.actRvPopularSong.setAdapter(popularSongAdapter);
        ViewCompat.setNestedScrollingEnabled(mBinding.actRvPopularSong, false);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mBinding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxoffset = appBarLayout.getTotalScrollRange();
                verticalOffset = Math.abs(verticalOffset);
                float percentage = verticalOffset / (float) maxoffset;
                if (isStart) {

                    if(convertDpToPixels(R.dimen._40sdp)<((int)(imgWidth-
                            (imgWidth*percentage) ))) {
                        mBinding.actTvFollowers.setAlpha(tvFollowerAlpha);
                        mBinding.actTvFollow.setAlpha(tvFollowAlpha);
                        mBinding.actTvPlays.setAlpha(tvPlayAlpha);
                        CollapsingToolbarLayout.LayoutParams params =
                                new CollapsingToolbarLayout.LayoutParams((int) (imgWidth -
                                        (imgWidth * percentage)), (int) (imgHeight -
                                        (imgHeight * percentage)));
                        mBinding.actIvSongImage.setLayoutParams(params);
                        mBinding.actTvArtistName.setY(tvArtistNameY);
                        mBinding.actTvArtistName.setTextColor(getResources().getColor(R.color.black));
                    //    mBinding.toolbar.setBackgroundColor(getResources().getColor(R.color.Red));
                        mBinding.actIvBack.setColorFilter(getResources().getColor(R.color.gray));
                    }
                    else{
                        mBinding.actTvFollowers.setAlpha(tvFollowerAlpha-(tvFollowerAlpha*percentage));
                        mBinding.actTvPlays.setAlpha(tvPlayAlpha-(tvPlayAlpha*percentage));
                        mBinding.actTvFollow.setAlpha(tvFollowAlpha-(tvFollowAlpha*percentage));
                        mBinding.actTvArtistName.setY(tvArtistNameY+(verticalOffset/6));
                        CollapsingToolbarLayout.LayoutParams params =
                                new CollapsingToolbarLayout.LayoutParams(convertDpToPixels(R.dimen._40sdp), convertDpToPixels(R.dimen._40sdp));
                        mBinding.actIvSongImage.setLayoutParams(params);
                        mBinding.actTvArtistName.setTextColor(getResources().getColor(R.color.Red));
                        mBinding.actIvBack.setColorFilter(getResources().getColor(R.color.Red));

                    }
                   if((imgX - (imgX * percentage))>(ivBackX+mBinding.actIvBack.getWidth()+10)) {
                       mBinding.actIvSongImage.setX(imgX - (imgX * percentage));
                   }
                       else {
                       mBinding.actIvSongImage.setX(ivBackX + mBinding.actIvBack.getWidth() + 10);
                   }
                    mBinding.actIvSongImage.setY(imgY+(verticalOffset) );

                    mBinding.actIvBack.setY(imgBackY+verticalOffset);

                    Log.d("test", "height: " + convertDpToPixels(R.dimen._30sdp));


                }
            }
        });
    }

    public  int convertDpToPixels(int dp) {
        return (int) getResources().getDimension(dp);
      }
    @Override
    protected void onResume() {
        super.onResume();

        mBinding.getRoot().post(new Runnable() {
            @Override
            public void run() {
                tvArtistNameY = mBinding.actTvArtistName.getY();
                tvFollowerAlpha = mBinding.actTvFollowers.getAlpha();
                tvPlayAlpha = mBinding.actTvPlays.getAlpha();
                tvFollowAlpha = mBinding.actTvFollow.getAlpha();
                imgX = mBinding.actIvSongImage.getX();
                imgY = mBinding.actIvSongImage.getY();
                toolbaHeight=mBinding.toolbar.getHeight();
                ivBackX=mBinding.actIvBack.getX();
                imgWidth = mBinding.actIvSongImage.getMeasuredWidth();
                imgHeight = mBinding.actIvSongImage.getMeasuredHeight();
                imgBackY = mBinding.actIvBack.getY();
                Log.d("test", "X: " + mBinding.actIvSongImage.getX());
                Log.d("test", "Y: " + mBinding.actIvSongImage.getY());
                isStart = true;
            }
        });


    }


}
