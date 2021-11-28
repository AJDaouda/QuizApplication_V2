package com.example.quizapplication.Model;

import android.app.Application;

public class MyApp extends Application {
    //Creating model class objects
    private static QuestionManager qManager =new QuestionManager();
    private static StorageService storageManager = new StorageService();

    //Creating getters
    public QuestionManager getQManager() {return qManager;}
    public StorageService getStorageManager() {return storageManager;}
}
