package com.example.cat.tool.time.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cat.tool.time.entiy.TaskEntiy;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM tasks")
    List<TaskEntiy> getAll();

    @Query("SELECT * FROM tasks WHERE tid IN (:userIds)")
    List<TaskEntiy> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM tasks WHERE " +
            "taskName = :taskName LIMIT 1")
    TaskEntiy findByName( String taskName);

    @Insert
    void insertAll(TaskEntiy... taskEntiys);

    @Delete
    void delete(TaskEntiy user);
    @Update
    void  updateTaskEntiy(TaskEntiy entiy);
}
