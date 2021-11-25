package com.example.quizapplication.Model;

import com.example.quizapplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuestionManager{

    public int colorIndex;
    private ArrayList<Question> questionBank = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList();


    Question q0 = new Question(R.string.Question0,false, getColors().get(0));
    Question q1 = new Question(R.string.Question1,false,getColors().get(1));
    Question q2 = new Question(R.string.Question2,false,getColors().get(2));
    Question q3 = new Question(R.string.Question3,false,getColors().get(3));
    Question q4 = new Question(R.string.Question4,false,getColors().get(4));
    Question q5 = new Question(R.string.Question5,false,getColors().get(5));
    Question q6 = new Question(R.string.Question6,false,getColors().get(6));
    Question q7 = new Question(R.string.Question7,false,getColors().get(7));
    Question q8 = new Question(R.string.Question8,false,getColors().get(8));
    Question q9 = new Question(R.string.Question9,false,getColors().get(9));

    public void builQuestinArrayList() {
        questionBank.add(q0);
        questionBank.add(q1);
        questionBank.add(q2);
        questionBank.add(q3);
        questionBank.add(q4);
        questionBank.add(q5);
        questionBank.add(q6);
        questionBank.add(q7);
        questionBank.add(q8);
        questionBank.add(q9); }

    void buildColorArrayList() {
        colors.add(R.color.Yellow);
        colors.add(R.color.purple_200);
        colors.add(R.color.PeachPuff);
        colors.add(R.color.Coral);
        colors.add(R.color.Magenta);
        colors.add(R.color.SandyBrown);
        colors.add(R.color.LightCyan);
        colors.add(R.color.Chocolate);
        colors.add(R.color.YellowGreen);
        colors.add(R.color.Thistle);}


    void shuffle(){
        Collections.shuffle(getColors());
        Collections.shuffle(getQuestionBank()); }


    //Getters
    public ArrayList<Integer> getColors() {return colors;}
    public ArrayList<Question> getQuestionBank() {return questionBank; }

    //Setters
    public void setQuestionBank(ArrayList<Question> questionBank) {this.questionBank = questionBank;}
    public void setColors(ArrayList<Integer> colors) {this.colors = colors; }

}

 /*Answers
    true
    false
    true
    false
    true
    false
    true
    true
    false
    false*/