package com.example.twentyquestions;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements Rounds.clickerManager{
    public BinaryQuestionTree questionTree;
    public String fileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTree = (BinaryQuestionTree) getFragmentManager().findFragmentById(R.id.display);
        fileContent = readFileFromAssets("animals.txt");
        questionTree.load(fileContent);
        questionTree.setDisplay();

    }


    public String readFileFromAssets(String fileName) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName)));
            String line;
            while (((line = reader.readLine()) != null)) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void moveLeft() {
        questionTree.moveNodeLeft();
    }

    @Override
    public void moveRight() {
        questionTree.moveNodeRight();
    }
}
