package com.example.quizapplication.Model;

import android.app.Activity;
import android.content.Context;

import com.example.quizapplication.MainActivity;

import java.io.FileInputStream;
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
            fos.write((userAnsweredQuestion.toString() +"$").getBytes());}
        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace(); }
        finally {
            try {
                fos.close();}
            catch (IOException e) {
                e.printStackTrace(); } } }

    public void getResults(Activity context){
        FileInputStream fis =null;
        StringBuffer sB = new StringBuffer();
        int read=0;

        try {
            fis = context.openFileInput(fileName);
        while((read= fis.read())!=-1){
            sB.append((char)read);
        }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetAllResults(Activity context){
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write("".getBytes());}
        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace(); }
        finally {
            try {
                fos.close();}
            catch (IOException e) {
                e.printStackTrace(); } } }
}
