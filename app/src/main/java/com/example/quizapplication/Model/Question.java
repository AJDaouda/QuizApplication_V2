package com.example.quizapplication.Model;

public class Question {
    private int questionId;
    //private String question;
    private int answer;
    //private boolean userAnswer;
    private int colorId;


    public Question(int questionId, int answer, int colorId) {
        this.questionId = questionId;
        this.answer = answer;
        this.colorId = colorId;}

    /*public Question(String question, boolean answer) {
        this.question = question;
        this.userAnswer = answer;}*/

    //Getters
    public int getQuestionId() {return questionId; }
    public int isAnswer() {return answer;}
    public int getColorId() {return colorId; }

    //Setters
    public void setQuestionId(int questionId) {this.questionId = questionId;}
    public void setAnswer(int answer) {this.answer = answer;}
    public void setColorId(int colorId) {this.colorId = colorId;}




    /*@Override
    public String toString() {
        return question + "," + userAnswer;}*/

   /* public static Question fromString(String stringQuestion){
        Question newQ = new Question("","");
        for (int i = 0; i<stringQuestion.toCharArray().length; i++){
            if (stringQuestion.toCharArray()[i] == ','){
                String question = stringQuestion.substring(0, i - 1  );
                String answer = stringQuestion.substring(i + 1,stringQuestion.toCharArray().length );
                newQ = new Question(question,answer);
            }
        }
        return newQ;
    }*/
}
