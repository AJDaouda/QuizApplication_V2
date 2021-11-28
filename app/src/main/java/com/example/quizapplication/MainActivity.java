package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.storage.StorageManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quizapplication.Model.MyApp;
import com.example.quizapplication.Model.Question;
import com.example.quizapplication.Model.QuestionManager;
import com.example.quizapplication.Model.StorageService;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //
    FragmentManager fm = getSupportFragmentManager();
    AlertDialog.Builder builder;

    //Layout Widgets declaration
    Button btn_true, btn_false;
    ProgressBar myProgress;

    //External class objects declaration
    //QuestionManager qM = ((MyApp) getApplication()).getManager();
    QuestionManager qM = new QuestionManager();
    StorageService storageM;
    Question answeredQuest;

    //Instance variables declaration
    int numOfAttempts=0;
    int index=0;
    int correctAnswers = 0;
    String userAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storageM = ((MyApp) getApplication()).getStorageManager();

        btn_true = (Button) findViewById(R.id.btn_T);
        btn_false = (Button) findViewById(R.id.btn_F);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);
        myProgress.setMax(qM.getQuestionBank().size());
        //int maxValue=myProgress.getMax();
        //int progressValue=myProgress.getProgress();

        builder = new AlertDialog.Builder(this);

        if(savedInstanceState!= null){
            index = savedInstanceState.getInt("current");

            //updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
            //System.out.println("my list is: " + qM.getQuestionBank().toString());

            updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
            System.out.println("my list is: " + qM.getQuestionBank().toString());
            //index++;
            }
        else{
            updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
            System.out.println("Something went wrong");
        }
    }


    public void updateFragment(int qId, int colorId) {
        //FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.main_frame_id);
        QuestionFragment qfragment = QuestionFragment.newInstance(qId, colorId);
        fm.beginTransaction().replace(R.id.main_frame_id,qfragment).commit();
        /*if (!(qfragment == null)){
            // add it
            fm.beginTransaction().replace(R.id.main_frame_id,qfragment).commit();
            }
        else {
            // remove it
            fm.beginTransaction().add(R.id.main_frame_id,qfragment).commit(); }*/
            }


// Required actions when "true" of "false" button is clicked
    public void btnClicked(View view) {
        userAns=((Button) view).getText().toString().toLowerCase(Locale.ROOT);
        if (index==(qM.getQuestionBank().size()-1)){
            numOfAttempts++;
            showAlertBox();
            System.out.println("The correct answer is: "+numOfAttempts);}
        else{
            if (Boolean.valueOf(userAns) != qM.getQuestionBank().get(index).isAnswer()){
                System.out.println("The user's answer is: "+ userAns);
                System.out.println("The correct answer is: "+ qM.getQuestionBank().get(index).isAnswer());
                Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show();}
            else{
                System.out.println("The user's answer is: "+ userAns);
                System.out.println("The correct answer is: "+ qM.getQuestionBank().get(index).isAnswer());
                Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
                correctAnswers++;
                 }
            answeredQuest = new Question(getResources().getString(qM.getQuestionBank().get(index).getQuestionId())
                    , Boolean.valueOf(userAns));
            index++;
            //updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());}
            updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
            myProgress.setProgress(index);
        }
    }


    //Shows a dialog box whe the shopper purchases an item
    private void showAlertBox(){
        builder.setTitle("Result");
        builder.setMessage("Your score is: " + correctAnswers + " over"+ qM.getQuestionBank().size());
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"SAVE clicked",Toast.LENGTH_SHORT).show();
                //Call saveData from the StorageService class
                storageM.saveResult(MainActivity.this,answeredQuest);
                System.out.println(answeredQuest.toString());
                qM.shuffle();
            }
        });

        builder.setNegativeButton("IGNORE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"IGNORE clicked",Toast.LENGTH_SHORT).show();
                qM.shuffle();
            }
        });
        AlertDialog alertDialog=builder.create();
        builder.show(); }

    // Showing the "top side menu" in the main activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.top_side_menu, menu);
        return true;}

    // Required actions when a menu item is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.menu_item_1:
                Toast.makeText(this,"Getting the average",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_2:
                Toast.makeText(this,"Selecting then number of questions",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_3:
                Toast.makeText(this,"Resetting the result",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current", index);
    }
}

    /*@Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        int index = 0;
        savedInstanceState.putInt("Current index", index);
    }*/

/*@Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("current", index); }*/

/*
// Required actions when "true" of "false" button is clicked
    public void btnClicked(View view) {
        //if(index<=qM.getQuestionBank().size()){
        int count= qM.getQuestionBank().size();
        boolean done=false;
        if(index == count){
            done =true;
            showAlertBox(); }
        else{
            done=false;
             userAns = Boolean.valueOf((((Button) view).getText()).toString().toLowerCase(Locale.ROOT));
            System.out.println("The user input is: "+userAns);
            //if (userAns == Boolean.valueOf(qM.getQuestionBank().get(index).isAnswer())){
            if (userAns == Boolean.valueOf(qM.getQuestionBank().get(index).isAnswer())){
                correctAnswers++;
                //System.out.println("The correct answer is: "+ qM.getQuestionBank().get(index).isAnswer());
                System.out.println("The correct answer is: "+ qM.getQuestionBank().get(index).isAnswer());
                Toast.makeText(this,"Your answer is correct",Toast.LENGTH_SHORT).show();}
            else{Toast.makeText(this,"Your answer is incorrect",Toast.LENGTH_SHORT).show();
                index++;
                //updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());}
                updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
                myProgress.setProgress(index);

            }

        }
            /*else {showAlertBox();}*/

//for(int i= index; i<qM.getQuestionBank().size()-1;i++){}
//index++;
