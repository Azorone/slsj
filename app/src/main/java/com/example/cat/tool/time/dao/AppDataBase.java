package com.example.cat.tool.time.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cat.tool.time.entiy.TaskEntiy;

@Database(entities ={TaskEntiy.class},version=1, exportSchema = false)
public abstract class AppDataBase  extends RoomDatabase {
    private static AppDataBase Instance;
    public static AppDataBase getInstance(Context context) {

        if (Instance == null){
            synchronized (AppDataBase.class){
                if (Instance == null){
                    Instance = Room.databaseBuilder(context, AppDataBase.class,"CatTool")
                            .enableMultiInstanceInvalidation().build();
                }
            }
        }
        return Instance;
    }

    public abstract TaskDao taskDao();
}
