package com.example.cat.tool.time;

import android.content.Context;
import android.content.Entity;
import android.webkit.JavascriptInterface;

import com.example.cat.tool.time.dao.AppDataBase;
import com.example.cat.tool.time.dao.TaskDao;
import com.example.cat.tool.time.entiy.TaskEntiy;
import com.google.gson.Gson;

import java.util.List;

public class WebAppInterface {
    TaskDao taskDao;
            WebAppInterface(Context context){
            taskDao =  AppDataBase.getInstance(context).taskDao();
            }

    @JavascriptInterface
    public String gets(){

        List<TaskEntiy> entiys = taskDao.getAll();
        Gson gson = new Gson();
        return gson.toJson(entiys);
    }
    @JavascriptInterface
    public void add(String json){
            Gson gson = new Gson();
            TaskEntiy entiy = gson.fromJson(json, TaskEntiy.class);

            taskDao.insertAll(entiy);
    }
    @JavascriptInterface
    public void del(String tid){
                int id = Integer.parseInt(tid);
                TaskEntiy entiy = new TaskEntiy();
                entiy.setTid(id);
                taskDao.delete(entiy);

    }
    @JavascriptInterface
    public void update(String json){
                Gson gson = new Gson();
                TaskEntiy taskEntiy = gson.fromJson(json, TaskEntiy.class);

                taskDao.updateTaskEntiy(taskEntiy);
    }
}
