package com.firebase.uidemo.historic;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.EpisodeDTO;

public class EpisodeHolder extends RecyclerView.ViewHolder {
    private final TextView mNameField;
    private final TextView mSeasonField;
    private final TextView mRuntimeField;
    private final TextView mTimestampField;

    public EpisodeHolder(@NonNull View itemView) {
        super(itemView);
        mNameField = itemView.findViewById(R.id.episode_name_text);
        mSeasonField = itemView.findViewById(R.id.episode_season_text);
        mRuntimeField = itemView.findViewById(R.id.episode_runtime_text);
        mTimestampField = itemView.findViewById(R.id.episode_timestamp_text);
    }


    public void bind(@NonNull EpisodeDTO episode) {
        setName(episode.getName());
        setSeason(episode.getSeason());
        setRuntime(episode.getRuntime());
        setTimestamp(episode.getTimestamp());
    }

    private void setName(@Nullable String name) {
        mNameField.setText(name);
    }

    private void setSeason(@Nullable String season) {
        mSeasonField.setText(season);
    }

    private void setRuntime(@Nullable String runtime) {
        mRuntimeField.setText(runtime);
    }

    public void setTimestamp(@Nullable String timestamp) {
        mTimestampField.setText(timestamp);
    }
}
