package com.example.quizapplication.Model;

import android.app.Activity;
import android.content.Context;

import com.example.quizapplication.MainActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StorageService {

    String fileName = "userAnswer.txt";
    //int total;
    //int correctAnswer;

   /* public String storeAnswer (int total,int cA){
        FileOutputStream fileOutputStream = null;
        fileOutputStream = Open;
    }*/

    //File outputstream for writing to "userAnswer.txt"
    public void saveResult(Activity context, Attempt currentAttempt){
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_APPEND);
            fos.write(( currentAttempt+"$").getBytes());}
        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace(); }
        finally {
            try {
                fos.close();}
            catch (IOException e) {
                e.printStackTrace(); } } }

    /*public void loadResults(Activity context){
        FileInputStream fis =null;
        StringBuffer sB = new StringBuffer();
        int read=0;
//Finish this method
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
    }*/

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

    public ArrayList<Attempt> getAllAttempts(Activity activity){
        FileInputStream fileInputStream = null;
        ArrayList<Attempt> list = new ArrayList<>(0);
        StringBuffer stringBuffer = new StringBuffer();
        int read = 0;
        try {

            // shopping - Nov 25, 2021$Reading - Nov 26, 2021$Studing - Nov 30, 2021
            fileInputStream = activity.openFileInput(fileName);
            while ( (read = fileInputStream.read()) != -1){//
                stringBuffer.append((char)read);
                System.out.println("My stringBuffer is: "+ stringBuffer);
            }
            // write a function to conver this string buffer into list of tasks
            list =  fromStringToListOfAttemps(stringBuffer.toString());
            System.out.println("My stringBuffer toString is: "+list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    //shopping - Nov 25, 2021$Reading - Nov 26, 2021$Studing - Nov 30, 2021
    private ArrayList<Attempt> fromStringToListOfAttemps(String stringFromTheFile){

        ArrayList<Attempt> list = new ArrayList<>(0);
        int index = 0;
        for (int i = 0 ; i < stringFromTheFile.toCharArray().length ; i++){
            if (stringFromTheFile.toCharArray()[i] == '$'){
                String fullTask = stringFromTheFile.substring(index,i);
                System.out.println("My fullTask is: "+fullTask);
                list.add(Attempt.fromString(fullTask));
                index = i + 1;
            }
        }

        return list;

    }
}
