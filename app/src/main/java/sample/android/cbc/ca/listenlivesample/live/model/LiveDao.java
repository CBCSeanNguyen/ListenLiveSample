package sample.android.cbc.ca.listenlivesample.live.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LiveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLiveStreams(List<Live> liveData);

    @Query("DELETE FROM live_table")
    void deleteAll();

    @Query("DELETE FROM live_table WHERE streamId = :id")
    void deleteItem(int id);

    @Query("SELECT * FROM live_table WHERE _id = :network_id ORDER BY stream_id ASC")
    LiveData<List<Live>> getLiveStreams(int network_id);

    @Query("SELECT * FROM live_table ORDER BY streamId ASC")
    LiveData<List<Live>> getAllStreams();
}
