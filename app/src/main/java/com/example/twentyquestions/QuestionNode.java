package com.example.twentyquestions;

/**
 * Created by Peter on 2/20/2017.
 */


public class QuestionNode {
    public String data;
    public QuestionNode yes;
    public QuestionNode no;

    public QuestionNode(String data){
        this.yes = null;
        this.no = null;
        this.data = data;
    }
    public QuestionNode(String data,QuestionNode no, QuestionNode yes) {
        this.data = data;
        this.no = no;
        this.yes = yes;
    }

    public String getData() {
        return data;
    }

}

