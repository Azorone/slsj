package com.example.cat.tool.time.entiy;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class TaskEntiy {
    @PrimaryKey(autoGenerate = true)
    private int tid;
    String taskName; //任务名
    int taskTimes; // 执行次数
    long taskAccTime; // 积累时间，ms

    @Override
    public String toString() {
        return "TaskEntiy{" +
                "tid=" + tid +
                ", taskName='" + taskName + '\'' +
                ", taskTimes=" + taskTimes +
                ", taskAccTime=" + taskAccTime +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskTimes() {
        return taskTimes;
    }

    public void setTaskTimes(int taskTimes) {
        this.taskTimes = taskTimes;
    }

    public long getTaskAccTime() {
        return taskAccTime;
    }

    public void setTaskAccTime(long taskAccTime) {
        this.taskAccTime = taskAccTime;
    }
}
