package com.example.quizapplication.Model;

public class Question {
    private int questionId;
    private String question;
    private boolean answer;
    private int colorId;

    public Question(int questionId, boolean answer, int colorId) {
        this.questionId = questionId;
        this.answer = answer;
        this.colorId = colorId;}

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;}

    //Getters
    public int getQuestionId() {return questionId; }
    public boolean isAnswer() {return answer;}
    public int getColorId() {return colorId; }

    //Setters
    public void setQuestionId(int questionId) {this.questionId = questionId;}
    public void setAnswer(boolean answer) {this.answer = answer;}
    public void setColorId(int colorId) {this.colorId = colorId;}

    @Override
    public String toString() {
        return "Question: " + questionId +
                ", answer: " + answer;}
}
