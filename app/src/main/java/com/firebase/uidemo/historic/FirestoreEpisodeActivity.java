package com.firebase.uidemo.historic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.uidemo.R;
import com.firebase.uidemo.api.EpisodeDTO;
import com.firebase.uidemo.databinding.ActivityEpisodeBinding;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FirestoreEpisodeActivity extends AppCompatActivity {

    private static final CollectionReference sEpisodeCollection =
            FirebaseFirestore.getInstance().collection("episodes");

    private static final Query sEpisodeQuery =
            sEpisodeCollection.orderBy("timestamp", Query.Direction.DESCENDING).limit(50);

    static {
        FirebaseFirestore.setLoggingEnabled(true);
    }

    private ActivityEpisodeBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityEpisodeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);

        mBinding.episodesList.setHasFixedSize(true);
        mBinding.episodesList.setLayoutManager(manager);

    }

    @Override
    public void onStart() {
        super.onStart();
//        if (isSignedIn()) {
        attachRecyclerViewAdapter();
//        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void attachRecyclerViewAdapter() {
        final RecyclerView.Adapter adapter = newAdapter();

        mBinding.episodesList.setAdapter(adapter);
    }

    @NonNull
    private RecyclerView.Adapter newAdapter() {
        FirestoreRecyclerOptions<EpisodeDTO> options =
                new FirestoreRecyclerOptions.Builder<EpisodeDTO>()
                        .setQuery(sEpisodeQuery, EpisodeDTO.class)
                        .setLifecycleOwner(this)
                        .build();

        return new FirestoreRecyclerAdapter<EpisodeDTO, EpisodeHolder>(options) {
            @NonNull
            @Override
            public EpisodeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new EpisodeHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.episode, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull EpisodeHolder holder, int position, @NonNull EpisodeDTO model) {
                holder.bind(model);
            }

            @Override
            public void onDataChanged() {
                if (getItemCount() == 0) {
                    mBinding.emptyEpisodeTextView.setVisibility(View.VISIBLE);
                } else {
                    mBinding.emptyEpisodeTextView.setVisibility(View.GONE);
                }
            }
        };
    }
}
