package sample.android.cbc.ca.listenlivesample.utils;

import android.os.Bundle;
import android.util.Log;

public class BundleHelper {
    private static final String TAG = "BundleHelper";

    public static String getBundleString(Bundle b, String key, String defaultValue) {
        if (b != null) {
            String value = b.getString(key);

            if (value == null) {
                Log.d(TAG, "Bundle value is null for key: " + key + "...setting default value.");
                value = defaultValue;
            }

            return value;
        }

        return defaultValue;
    }
}
