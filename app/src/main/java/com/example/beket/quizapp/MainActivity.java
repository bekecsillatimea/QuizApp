package com.example.beket.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name_edit_text) EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        nameEditText.setText("");
    }

    // opens QuizActivity
    @OnClick(R.id.start_button)
    public void startQuiz(){
        if(nameEditText.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Pleas insert your name!", Toast.LENGTH_SHORT).show();
        } else {
            String name = nameEditText.getText().toString().trim();
            Intent startQuizIntent = new Intent(MainActivity.this, QuizActivity.class);
            startQuizIntent.putExtra("UserName", name);
            startActivity(startQuizIntent);
        }
    }
}
