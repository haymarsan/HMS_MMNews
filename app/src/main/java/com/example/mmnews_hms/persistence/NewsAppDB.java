package com.example.mmnews_hms.persistence;


import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mmnews_hms.data.vos.LoginUserVO;
import com.example.mmnews_hms.persistence.dao.LoginUseDao;

@Database(entities = {LoginUserVO.class}, version = 1)
public abstract class NewsAppDB extends RoomDatabase {

    public static NewsAppDB INSTANCE;
    public abstract LoginUseDao loginUseDao();

   private static final String NEWS_DATABASE = "NewsDatabase.DB";

    public static NewsAppDB getDatabase(Context context) {
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, NewsAppDB.class, NEWS_DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }




 /*   public static NewsAppDB getDatabase(Context context) {
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,NewsAppDB.class, NEWS_DATABASE )
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }*/
}
