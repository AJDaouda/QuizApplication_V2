package com.example.quizapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quizapplication.Model.MyApp;
import com.example.quizapplication.Model.QuestionManager;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm = getSupportFragmentManager();

    Button btn_true, btn_false;
    ProgressBar myProgress;

    //QuestionManager qM = ((MyApp) getApplication()).getqManager();
    QuestionManager qM = new QuestionManager();
    int index = 0;
    String userAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_true = (Button) findViewById(R.id.btn_T);
        btn_false = (Button) findViewById(R.id.btn_F);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);
        System.out.println("my list is: " + qM.getQuestionBank().toString());
        updateFragment(qM.getQuestionBank().get(index).getQuestionId(),qM.getQuestionBank().get(index).getColorId());
        index++; }

    /*public void updateFragment(int qId, int colorId) {
        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.main_frame_id);
        QuestionFragment qfragment = QuestionFragment.newInstance(qId, colorId);
        fm.beginTransaction().add(R.id.main_frame_id, qfragment).commit();
        /*if (qfragment == null){
            // add it
            fm.beginTransaction().add(R.id.main_frame_id,qfragment).commit();
            }
        else {
            // remove it
            fm.beginTransaction().remove(qfragment).commit(); }*/



    public void updateFragment(int qId, int colorId) {
        QuestionFragment qfragment = (QuestionFragment) fm.findFragmentById(R.id.main_frame_id);
        if (qfragment == null){
            // add f3
            qfragment = QuestionFragment.newInstance(qId, colorId);
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.beginTransaction().add(R.id.main_frame_id,qfragment).commit();

        }
        else {
            // remove it
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fm.beginTransaction().remove(qfragment).commit();
        }
    }



    // Required actions when "true" of "false" button is clicked
    public void btnClicked(View view) {
        for(int i= index; i<qM.getQuestionBank().size()-1;i++){
            updateFragment(qM.getQuestionBank().get(i).getQuestionId(),qM.getQuestionBank().get(i).getColorId());
         userAns = ((Button)view).getText().toString();
        if (userAns==String.valueOf(qM.getQuestionBank().get(i).isAnswer())){
            Toast.makeText(this,"Your answer is correct",Toast.LENGTH_SHORT).show();}
        else{Toast.makeText(this,"Your answer is incorrect",Toast.LENGTH_SHORT).show();}
        }
        //index++;
    }

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


}