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

import com.example.chirag.musica.adapter.AlbumOfArtistAdapter;
import com.example.chirag.musica.adapter.MoreAlbumAdapter;
import com.example.chirag.musica.databinding.ActivityAlbumOfArtistBinding;

public class AlbumOfArtistActivity extends AppCompatActivity {

    private ActivityAlbumOfArtistBinding mBinding;
    private boolean isStart;
    private float ivBackX;
    private float imgY;
    private float toolbaHeight;
    private float imgX;
    private float imgBackY;
    private int imgWidth;
    private int imgHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_album_of_artist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mBinding.actRvAlbumSong.setLayoutManager(layoutManager);
        AlbumOfArtistAdapter albumOfArtistAdapter = new AlbumOfArtistAdapter(this);
        mBinding.actRvAlbumSong.setAdapter(albumOfArtistAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mBinding.actRvMoreAlbums.setLayoutManager(layoutManager1);
        MoreAlbumAdapter moreAlbumAdapter = new MoreAlbumAdapter(this);
        mBinding.actRvMoreAlbums.setAdapter(moreAlbumAdapter);
        ViewCompat.setNestedScrollingEnabled(mBinding.actRvAlbumSong, false);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mBinding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxoffset = appBarLayout.getTotalScrollRange();
                verticalOffset = Math.abs(verticalOffset);
                float percentage = verticalOffset / (float) maxoffset;

                if(isStart) {
                    if (convertDpToPixels(R.dimen._40sdp) < ((int) (imgWidth -
                            (imgWidth * percentage)))) {
                        CollapsingToolbarLayout.LayoutParams params =
                                new CollapsingToolbarLayout.LayoutParams((int) (imgWidth -
                                        (imgWidth * percentage)), (int) (imgHeight -
                                        (imgHeight * percentage)));
                        mBinding.actIvAlbumImage.setLayoutParams(params);
                        mBinding.actIvBack.setColorFilter(getResources().getColor(R.color.white));
                        mBinding.actAlbumName.setTextColor(getResources().getColor(R.color.black));
                        mBinding.actTvArtistName.setTextColor(getResources().getColor(R.color.black));
                    }
                else{
                    CollapsingToolbarLayout.LayoutParams params =
                            new CollapsingToolbarLayout.LayoutParams(convertDpToPixels(R.dimen._40sdp), convertDpToPixels(R.dimen._40sdp));
                    mBinding.actIvAlbumImage.setLayoutParams(params);
                        mBinding.actIvBack.setColorFilter(getResources().getColor(R.color.Red));
                        mBinding.actAlbumName.setTextColor(getResources().getColor(R.color.Red));
                        mBinding.actTvArtistName.setTextColor(getResources().getColor(R.color.Red));
                }

                    if ((imgX - (imgX * percentage)) > (ivBackX + mBinding.actIvBack.getWidth() + 10)) {
                        mBinding.actIvAlbumImage.setX(imgX - (imgX * percentage));
                    } else {
                        mBinding.actIvAlbumImage.setX(ivBackX + mBinding.actIvBack.getWidth() + 10);

                    }


                    mBinding.actIvAlbumImage.setY(imgY + (verticalOffset/2)+((imgHeight/4)*percentage)+convertDpToPixels(R.dimen._4sdp));
                    mBinding.actIvBack.setY(imgBackY+verticalOffset);
                    Log.d("test", "onOffsetChanged: " + verticalOffset);
                    Log.d("test", "onOffsetChanged: " + (mBinding.actIvBack.getWidth()));

                }
            }
        });
    }

    public int convertDpToPixels(int dp) {
        return (int) getResources().getDimension(dp);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mBinding.getRoot().post(new Runnable() {
            @Override
            public void run() {
                isStart=true;
                imgWidth = mBinding.actIvAlbumImage.getMeasuredWidth();
                imgHeight = mBinding.actIvAlbumImage.getMeasuredHeight();
                imgX = mBinding.actIvAlbumImage.getX();
                imgY = mBinding.actIvAlbumImage.getY();
                toolbaHeight = mBinding.toolbar.getHeight();
                ivBackX = mBinding.actIvBack.getX();
                imgBackY = mBinding.actIvBack.getY();
                Log.d("test", "run: " + ivBackX);
            }
        });
    }
}
