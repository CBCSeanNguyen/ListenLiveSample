package sample.android.cbc.ca.listenlivesample.live.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import sample.android.cbc.ca.listenlivesample.R;
import sample.android.cbc.ca.listenlivesample.live.controller.LiveListAdapter;
import sample.android.cbc.ca.listenlivesample.live.controller.LiveViewModel;
import sample.android.cbc.ca.listenlivesample.live.model.Live;

public class LiveFragment extends Fragment {
    private static final String TAG = "LiveFragment";

    private LiveViewModel mLiveViewModel;
    private ProgressBar mLoadingBar;

    private RecyclerView mLiveRecyclerView;
    private LiveListAdapter mLiveAdapter;
    private LinearLayoutManager mLiveLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;

        rootView = inflater.inflate(R.layout.fragment_live, container, false);

        mLiveViewModel = ViewModelProviders.of(this).get(LiveViewModel.class);
        mLiveViewModel.getAllStreams().observe(this, new Observer<List<Live>>() {
            @Override
            public void onChanged(@Nullable List<Live> lives) {
                Log.d(TAG, "DATA CHANGED!!!");
                mLiveAdapter.setLiveList(lives);

                mLoadingBar.setVisibility(View.GONE);
                mLiveRecyclerView.setVisibility(View.VISIBLE);
            }
        });
        mLiveViewModel.insertLiveStreams();

        mLoadingBar = (ProgressBar) rootView.findViewById(R.id.pb_live_load);
        mLoadingBar.setVisibility(View.VISIBLE);


        mLiveAdapter = new LiveListAdapter(getActivity());
        mLiveLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLiveRecyclerView = rootView.findViewById(R.id.rv_live);
        mLiveRecyclerView.setAdapter(mLiveAdapter);
        mLiveRecyclerView.setLayoutManager(mLiveLinearLayoutManager);
        mLiveRecyclerView.setVisibility(View.GONE);

        return rootView;
    }
}
