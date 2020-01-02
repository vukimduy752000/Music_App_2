package com.example.SongPackage.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;

import java.util.List;
import java.util.zip.Inflater;

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private List<Song> mSongs;
    private Context mContext;

    public SongRecyclerViewAdapter(List<Song> songs, Context context) {
        mSongs = songs;
        mContext = context;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_song_view,null);
        return new SongViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolderholder, int position) {

        songViewHolderholder.songNameTextView.setText(mSongs.get(position).getName());
        songViewHolderholder.songImageView.setImageResource(mSongs.get(position).getImageFileName());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}