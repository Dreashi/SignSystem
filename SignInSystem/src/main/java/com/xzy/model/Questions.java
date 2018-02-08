package com.xzy.model;

import java.io.Serializable;

public class Questions implements Serializable {
    private int questionId ;
    private String questionContent;
    private String questionOption;
    private String[] questionOptions;
    private String questionAnswer;



    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String[] questionOptions) {
        this.questionOptions = questionOptions;
    }
}
