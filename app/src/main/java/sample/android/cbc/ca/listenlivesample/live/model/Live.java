package sample.android.cbc.ca.listenlivesample.live.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "live_table")
public class Live {

    /*
    Network Information
     */
    @Embedded
    @NonNull
    private Network mNetworkInfo;

    @Embedded
    @NonNull
    private LiveStream mLiveStream;

    /*
    LiveStream information
     */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "stream_id")
    public String id;


    public Live(@NonNull LiveStream liveStream, @NonNull Network networkInfo) {
        this.mLiveStream = liveStream;
        this.mNetworkInfo = networkInfo;
        this.id = mLiveStream.getStreamId();
    }


    @NonNull
    public Network getNetworkInfo() {
        return mNetworkInfo;
    }

    @NonNull
    public LiveStream getLiveStream() {
        return mLiveStream;
    }
}
