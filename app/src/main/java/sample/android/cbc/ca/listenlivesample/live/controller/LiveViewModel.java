package sample.android.cbc.ca.listenlivesample.live.controller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import sample.android.cbc.ca.listenlivesample.live.model.Live;
import sample.android.cbc.ca.listenlivesample.live.model.LiveRepository;

public class LiveViewModel extends AndroidViewModel {

    private LiveRepository mRepository;
    private LiveData<List<Live>> mAllStreams;

    public LiveViewModel(Application application) {
        super(application);

        mRepository = new LiveRepository(application);
        mAllStreams = mRepository.getAllStreams();
    }

    public LiveData<List<Live>> getAllStreams() {
        return mAllStreams;
    }

    public void insert() {
        mRepository.insert();
    }
}
