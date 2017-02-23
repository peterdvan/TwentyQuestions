package com.example.twentyquestions;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Peter on 2/20/2017.
 */

public class BinaryQuestionTree extends Fragment {
    private QuestionNode root;
    TextView questionText;
    private QuestionNode current;
    private int counter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        counter = 0;
        View view = inflater.inflate(R.layout.questiontext,container,false);
        questionText = (TextView) view.findViewById(R.id.Question);
        return view;
    }

    public BinaryQuestionTree () {
        root = null;
    }

    public void load(String text) {
        Scanner scanner = new Scanner(text);
        root = loadHelper(root, scanner);
        current = root;

    }
    public QuestionNode loadHelper(QuestionNode node, Scanner scanner) {
        if(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            node = new QuestionNode(line.substring(2));
            if (line.startsWith("Q")) {
                node.yes = loadHelper(node.yes, scanner);
                node.no = loadHelper(node.no, scanner);
            }
        }
        return node;
    }

    public void display() {
        QuestionNode current = root;
        displayHelper(current);
    }
    private void displayHelper(QuestionNode node) {
        if(node != null) {
            Log.d("MyTag",node.data);
            displayHelper(node.yes);
            displayHelper(node.no);
        }
    }

   public void moveNodeLeft() {
        counter++;
        if(current.yes == null || counter == 20){
            current = root;
            questionText.setText("I win!!!");
            counter = 0;
        } else {
            current = current.yes;
            setDisplay();
        }
    }
    public void moveNodeRight() {
        counter++;
        if (current.no == null || counter == 20){
            current = root;
            questionText.setText("I don't have the answer you win!!!");
            counter = 0;
        } else {
            current = current.no;
            setDisplay();
        }
    }
    public void setDisplay() {
        questionText.setText(current.getData());
    }

}
