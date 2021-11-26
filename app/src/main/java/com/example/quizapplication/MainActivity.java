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
import android.widget.Toast;

import com.example.quizapplication.Model.MyApp;
import com.example.quizapplication.Model.QuestionManager;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm = getSupportFragmentManager();
    //QuestionMananger qM = new QuestionMananger90

    QuestionManager qM = ((MyApp) getApplication()).getqManager();

    public void updateFragment(int qId, int colorId){
        QuestionFragment qfragment = (QuestionFragment) fm.findFragmentById(R.id.frag_container);
        if (qfragment == null){
            // add f3
            qfragment = new QuestionFragment();
            fm.beginTransaction().add(R.id.frag_container,qfragment).commit();
            //fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateFragment(qM.getQuestionBank().get(0).getQuestionId(),qM.getColors().get(0));
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

    // Required actions when "true" of "false" button is clicked
    public void btnClicked(View view) {
    }
}