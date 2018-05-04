package sample.android.cbc.ca.listenlivesample.live.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sample.android.cbc.ca.listenlivesample.R;
import sample.android.cbc.ca.listenlivesample.live.model.Live;

public class LiveListAdapter extends RecyclerView.Adapter<LiveListAdapter.LiveViewHolder> {

    class LiveViewHolder extends RecyclerView.ViewHolder {
        private final TextView liveItemTitle;

        private LiveViewHolder(View itemView) {
            super(itemView);

            liveItemTitle = itemView.findViewById(R.id.tv_live_title);
        }
    }

    private final LayoutInflater mInflater;
    private List<Live> mLiveList;

    public LiveListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public LiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_live, parent, false);

        return new LiveViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LiveViewHolder holder, int position) {
        if (mLiveList != null) {
            Live current = mLiveList.get(position);

            holder.liveItemTitle.setText(current.getLiveStream().getStreamFullTitle());
        }
        else {
            holder.liveItemTitle.setText("No Data Yet...");
        }
    }

    public void setLiveList(List<Live> liveData) {
        mLiveList = liveData;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mLiveList != null) {
            return mLiveList.size();
        }
        else {
            return 0;
        }
    }
}
