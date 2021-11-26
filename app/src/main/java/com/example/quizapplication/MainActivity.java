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

    Button btn_true, btn_false;
    ProgressBar myProgress;

    //QuestionManager qM = ((MyApp) getApplication()).getqManager();
    QuestionManager qM = new QuestionManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_true = (Button) findViewById(R.id.btn_T);
        btn_false = (Button) findViewById(R.id.btn_F);
        myProgress =  (ProgressBar) findViewById(R.id.pbar);
        updateFragment(qM.getQuestionBank().get(0).getQuestionId(),qM.getColors().get(0));
    }

    public void updateFragment(int qId, int colorId){
        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.main_frame_id);
        QuestionFragment qfragment = QuestionFragment.newInstance(qId,colorId);
        fm.beginTransaction().add(R.id.main_frame_id,qfragment).commit(); }

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

    // Required actions when "true" of "false" button is clicked
    public void btnClicked(View view) {
    }
}