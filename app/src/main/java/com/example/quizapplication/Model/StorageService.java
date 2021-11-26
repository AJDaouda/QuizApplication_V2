package com.example.quizapplication.Model;

import android.app.Activity;
import android.content.Context;

import com.example.quizapplication.MainActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StorageService {

    String fileName = "myDB.txt";
    //int total;
    //int correctAnswer;

   /* public String storeAnswer (int total,int cA){
        FileOutputStream fileOutputStream = null;
        fileOutputStream = Open;
    }*/

    public void saveScore(Activity context, int correctAnswer){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
