package com.example.quizapplication.Model;

public class Attempt {
    private String numOfCorrectAns;

    public Attempt(String numOfattempt) {
        this.numOfCorrectAns = numOfattempt;
    }

    public String getNumOfattempt() {return numOfCorrectAns;}

    // Shopping _ Nov - 25 - 2021


    @Override
    public String toString() {return numOfCorrectAns+"";}

    public static Attempt fromString(String stringAttempt){
        Attempt myAttempt = new Attempt("");
        for (int i = 0; i<stringAttempt.toCharArray().length; i++){
            if (stringAttempt.toCharArray()[i] =='-'){
                String numOfattempt = stringAttempt.substring(0, i);
                System.out.println("My numOfattempt is: "+numOfattempt);
                myAttempt = new Attempt(numOfattempt);
            }
        }
        return myAttempt;
    }
}
