package com.example.quizapplication.Model;

import com.example.quizapplication.R;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuestionManager{

    public int colorIndex;
    private ArrayList<Question> questionBank = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList();

    /*Question q1 = new Question(R.string.Question1,false,getColors().get(1));
    Question q2 = new Question(R.string.Question2,false,getColors().get(2));
    Question q3 = new Question(R.string.Question3,false,getColors().get(3));
    Question q4 = new Question(R.string.Question4,false,getColors().get(4));
    Question q5 = new Question(R.string.Question5,false,getColors().get(5));
    Question q6 = new Question(R.string.Question6,false,getColors().get(6));
    Question q7 = new Question(R.string.Question7,false,getColors().get(7));
    Question q8 = new Question(R.string.Question8,false,getColors().get(8));
    Question q9 = new Question(R.string.Question9,false,getColors().get(9));
    Question q10 = new Question(R.string.Question0,false, getColors().get(0));*/

    //public QuestionManager(){}

    public QuestionManager(){
        this.colors.add(R.color.Yellow);
        this.colors.add(R.color.purple_200);
        this.colors.add(R.color.PeachPuff);
        this.colors.add(R.color.Coral);
        this.colors.add(R.color.Magenta);
        this.colors.add(R.color.SandyBrown);
        this.colors.add(R.color.LightCyan);
        this.colors.add(R.color.Chocolate);
        this.colors.add(R.color.YellowGreen);
        this.colors.add(R.color.Thistle);

        Question q1 = new Question(R.string.Question1,false,getColors().get(1));
        Question q2 = new Question(R.string.Question2,false,getColors().get(2));
        Question q3 = new Question(R.string.Question3,false,getColors().get(3));
        Question q4 = new Question(R.string.Question4,false,getColors().get(4));
        Question q5 = new Question(R.string.Question5,false,getColors().get(5));
        Question q6 = new Question(R.string.Question6,false,getColors().get(6));
        Question q7 = new Question(R.string.Question7,false,getColors().get(7));
        Question q8 = new Question(R.string.Question8,false,getColors().get(8));
        Question q9 = new Question(R.string.Question9,false,getColors().get(9));
        Question q10 = new Question(R.string.Question0,false, getColors().get(0));

        this.questionBank.add(q1);
        this.questionBank.add(q2);
        this.questionBank.add(q3);
        this.questionBank.add(q4);
        this.questionBank.add(q5);
        this.questionBank.add(q6);
        this.questionBank.add(q7);
        this.questionBank.add(q8);
        this.questionBank.add(q9);
        this.questionBank.add(q10);}

    /*public void builQuestinArrayList() {
        questionBank.add(q0);
        questionBank.add(q1);
        questionBank.add(q2);
        questionBank.add(q3);
        questionBank.add(q4);
        questionBank.add(q5);
        questionBank.add(q6);
        questionBank.add(q7);
        questionBank.add(q8);
        questionBank.add(q9); }*/

    /*void buildColorArrayList() {
        this.colors.add(R.color.Yellow);
        this.colors.add(R.color.purple_200);
        this.colors.add(R.color.PeachPuff);
        this.colors.add(R.color.Coral);
        this.colors.add(R.color.Magenta);
        this.colors.add(R.color.SandyBrown);
        this.colors.add(R.color.LightCyan);
        this.colors.add(R.color.Chocolate);
        this.colors.add(R.color.YellowGreen);
        this.colors.add(R.color.Thistle);}*/


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