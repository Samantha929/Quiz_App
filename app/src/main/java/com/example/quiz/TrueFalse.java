package com.example.quiz;

public class TrueFalse {
    private int questionID;
    private boolean answer;

    public TrueFalse (int questionResourceID, boolean trueOrFalse) {
        questionID = questionResourceID;
        answer = trueOrFalse;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
