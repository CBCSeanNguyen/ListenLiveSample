package sample.android.cbc.ca.listenlivesample.live.model;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LiveJSONHandler {
    private static final String TAG = "LiveJSONHandler";

    public static List<Live> parseLiveJsonData(InputStream inputStream) {
        Log.d(TAG, "Parsing Live data...");

        final ObjectMapper mapper = new ObjectMapper();
        List<Live> liveList = new ArrayList<>();

        try {
            JsonNode root = mapper.readTree(inputStream);
            JsonNode liveStreams = root.at("/data");

            if (liveStreams.isArray()) {
                for (JsonNode networkStreams : liveStreams) {

                    Log.d(TAG, "stream id: " + networkStreams.at("/id").asText());

                    Network network = new Network(
                            networkStreams.at("/id").asText(),
                            networkStreams.at("/name").asText(),
                            networkStreams.at("/logoUrl").asText());

                    JsonNode streamData = networkStreams.at("/streams");
                    if (streamData.isArray()) {
                        for (JsonNode streams : streamData) {

                            LiveStream liveStream = new LiveStream(
                                    streams.at("/id").asText(),
                                    streams.at("/fullTitle").asText(),
                                    streams.at("/streamUrl").asText(),
                                    streams.at("/title").asText(),
                                    streams.at("/artwork").asText());

                            Live liveData = new Live(liveStream, network);

                            liveList.add(liveData);
                        }
                    }
                }
            }

            return liveList;
        } catch (JsonProcessingException e) {
            Log.e(TAG, "JsonProcessingException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        }

        return null;
    }
}
