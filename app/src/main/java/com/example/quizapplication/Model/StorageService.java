package com.example.quizapplication.Model;

import android.app.Activity;
import android.content.Context;

import com.example.quizapplication.MainActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageService {

    String fileName = "userAnswer.txt";
    //int total;
    //int correctAnswer;

   /* public String storeAnswer (int total,int cA){
        FileOutputStream fileOutputStream = null;
        fileOutputStream = Open;
    }*/

    //File outputstream for writing to "userAnswer.txt"
    public void saveResult(Activity context, Question userAnsweredQuestion){
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            fos.write((userAnsweredQuestion.toString() +"$").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
