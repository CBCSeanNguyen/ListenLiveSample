package sample.android.cbc.ca.listenlivesample.live.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Bundle;
import android.support.annotation.NonNull;

import sample.android.cbc.ca.listenlivesample.utils.BundleHelper;

@Entity(tableName = "live_table")
public class Live {

    public static final String KEY_NETWORK_ID = "network_id";
    public static final String KEY_NETWORK_NAME = "network_name";
    public static final String KEY_NETWORK_LOGO = "network_logo";
    public static final String KEY_STREAM_ID = "stream_id";
    public static final String KEY_STREAM_TITLE = "stream_title";
    public static final String KEY_STREAM_FULL_TITLE = "stream_full_title";
    public static final String KEY_STREAM_PROVINCE = "stream_province";
    public static final String KEY_STREAM_URL = "stream_url";

    /*
    Network Information
     */
    @NonNull
    @ColumnInfo(name = "network_id")
    private String mNetworkID;

    @NonNull
    @ColumnInfo(name = "network_name")
    private String mNetworkName;

    @NonNull
    @ColumnInfo(name = "network_logo")
    private String mNetworkLogo;

    /*
    Stream information
     */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "stream_id")
    private String mStreamID;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name = "full_title")
    private String mFullTitle;

    @NonNull
    @ColumnInfo(name = "province")
    private String mProvince;

    @NonNull
    @ColumnInfo(name = "stream_url")
    private String mStreamUrl;

//    public Live(@NonNull Bundle liveArgs) {
//        this.mNetworkID = BundleHelper.getBundleString(liveArgs, KEY_NETWORK_ID, "");
//        this.mNetworkName = BundleHelper.getBundleString(liveArgs, KEY_NETWORK_NAME, "");
//        this.mNetworkLogo = BundleHelper.getBundleString(liveArgs, KEY_NETWORK_LOGO, "");
//
//        this.mStreamID = BundleHelper.getBundleString(liveArgs, KEY_STREAM_ID, "");
//        this.mTitle = BundleHelper.getBundleString(liveArgs, KEY_STREAM_TITLE, "");
//        this.mFullTitle = BundleHelper.getBundleString(liveArgs, KEY_STREAM_FULL_TITLE, "");
//        this.mProvince = BundleHelper.getBundleString(liveArgs, KEY_STREAM_PROVINCE, "");
//        this.mStreamUrl = BundleHelper.getBundleString(liveArgs, KEY_STREAM_URL, "");
//    }

    public Live(@NonNull String networkID, @NonNull String networkName, @NonNull String networkLogo, @NonNull String streamID,
                @NonNull String title, @NonNull String fullTitle, @NonNull String province, @NonNull String streamUrl) {
        this.mNetworkID = networkID;
        this.mNetworkName = networkName;
        this.mNetworkLogo = networkLogo;

        this.mStreamID = streamID;
        this.mTitle = title;
        this.mFullTitle = fullTitle;
        this.mProvince = province;
        this.mStreamUrl = streamUrl;
    }

//    public Live() { }

    public String getNetworkID() {
        return this.mNetworkID;
    }

    public String getNetworkName() {
        return this.mNetworkName;
    }

    public String getNetworkLogo() {
        return this.mNetworkLogo;
    }

    public String getStreamID() {
        return this.mStreamID;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getFullTitle() {
        return this.mFullTitle;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public String getStreamUrl() {
        return this.mStreamUrl;
    }
}
