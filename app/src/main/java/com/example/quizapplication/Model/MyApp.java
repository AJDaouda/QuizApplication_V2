package com.example.quizapplication.Model;

import android.app.Application;

public class MyApp extends Application {
    private QuestionManager qManager =new QuestionManager();

    public QuestionManager getqManager() {return qManager;}
}
