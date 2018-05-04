package sample.android.cbc.ca.listenlivesample.live.model;

public class LiveStream extends StreamMetaData {

    private final String streamFullTitle;

    private final String streamId;

    public LiveStream(String streamId,String streamFullTitle, String streamUrl, String title, String artwork) {
        super(streamUrl, title, artwork);
        this.streamId = streamId;
        this.streamFullTitle = streamFullTitle;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getStreamFullTitle() {
        return streamFullTitle;
    }

}
