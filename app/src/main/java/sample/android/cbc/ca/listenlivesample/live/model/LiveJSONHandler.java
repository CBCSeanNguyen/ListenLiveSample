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
                    String networkID;
                    String networkName;
                    String networkLogoUrl;
                    String streamID;
                    String streamTitle;
                    String streamFullTitle;
                    String streamProvince;
                    String streamUrl;

                    networkID = networkStreams.at("/id").asText();
                    networkName = networkStreams.at("/name").asText();
                    networkLogoUrl = networkStreams.at("/logoUrl").asText();

                    JsonNode streamData = networkStreams.at("/streams");
                    if (streamData.isArray()) {
                        for (JsonNode streams : streamData) {
                            streamID = streams.at("/id").asText();
                            streamTitle = streams.at("/title").asText();
                            streamFullTitle = streams.at("/fullTitle").asText();
                            streamProvince = streams.at("/province").asText();
                            streamUrl = streams.at("/streamUrl").asText();

                            Live liveData = new Live(networkID, networkName, networkLogoUrl,
                                    streamID, streamTitle, streamFullTitle, streamProvince, streamUrl);

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
