package com.example.beket.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        nameEditText.setText("");
    }

    // starts quiz
    public void startQuiz(View v){
        if(nameEditText.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Pleas insert your name!", Toast.LENGTH_LONG).show();
        } else {
            String name = nameEditText.getText().toString().trim();
            Intent startQuizIntent = new Intent(MainActivity.this, QuizActivity.class);
            startQuizIntent.putExtra("UserName", name);
            startActivity(startQuizIntent);
        }
    }
}
