package sample.android.cbc.ca.listenlivesample.live.model;

public class StreamMetaData {
    private String mStreamUrl;
    private String mTitle;
    private String mArtwork;

    public StreamMetaData(String streamUrl, String title, String artwork) {
        this.mStreamUrl = streamUrl;
        this.mTitle = title;
        this.mArtwork = artwork;
    }

    public String getArtwork() {
        return mArtwork;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public String getTitle() {
        return mTitle;
    }
}
