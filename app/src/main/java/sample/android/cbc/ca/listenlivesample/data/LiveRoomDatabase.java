package sample.android.cbc.ca.listenlivesample.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import sample.android.cbc.ca.listenlivesample.live.model.Live;
import sample.android.cbc.ca.listenlivesample.live.model.LiveDao;

/* *****  LIST ENTITIES (DB TABLES) HERE  ***** */
@Database(entities = { Live.class }, version = 1)
public abstract class LiveRoomDatabase extends RoomDatabase {

    private static LiveRoomDatabase sInstance;

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    public static LiveRoomDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (LiveRoomDatabase.class) {
                if (sInstance == null) {
                    //Create DB
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            LiveRoomDatabase.class, "listen_database")
                                .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return sInstance;
    }

    /*
    Define DAOs here
     */
    public abstract LiveDao liveDao();
}
