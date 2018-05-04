package sample.android.cbc.ca.listenlivesample.live.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import sample.android.cbc.ca.listenlivesample.data.LiveRoomDatabase;
import sample.android.cbc.ca.listenlivesample.utils.Network;

public class LiveRepository {
    private static final String TAG = "LiveRepository";

    private LiveDao mLiveDao;
    private LiveData<List<Live>> mLiveData;

    public LiveRepository(Application application) {
        LiveRoomDatabase db = LiveRoomDatabase.getDatabase(application);

        mLiveDao = db.liveDao();
        mLiveData = mLiveDao.getAllStreams();
    }

    public LiveData<List<Live>> getAllStreams() {
        return mLiveData;
    }

    public LiveData<List<Live>> getStreamList(int networkID) {
        return mLiveDao.getLiveStreams(networkID);
    }

    public void insertLiveStreams() {
        String url = "http://templisten.primeprojection.com:4000/networks?inline=streams";
        new InsertAsyncTask(mLiveDao).execute(url);
    }

    private static class InsertAsyncTask extends AsyncTask<String, Void, Void> {

        private LiveDao mAsyncTaskDao;

        InsertAsyncTask(LiveDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            String url = params[0];

            try {
                InputStream is = Network.downloadStream(url);
                List<Live> liveData = LiveJSONHandler.parseLiveJsonData(is);

                mAsyncTaskDao.insertLiveStreams(liveData);
            } catch (IOException e) {
                Log.e(TAG, "Error retrieving data...");
            }

            return null;
        }
    }
}
