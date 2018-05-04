package sample.android.cbc.ca.listenlivesample.live.model;


import android.arch.persistence.room.ColumnInfo;

public class Network {
    @ColumnInfo(name = "_id")
    private final String mId;
    private final String networkName;
    private final String networkLogo;


    public Network(String id, String networkName, String networkLogo) {
        this.mId = id;
        this.networkName = networkName;
        this.networkLogo = networkLogo;
    }

    public String getId(){return mId;}

    public String getNetworkLogo() {
        return networkName;
    }

    public String getNetworkName() {
        return networkLogo;
    }
}
