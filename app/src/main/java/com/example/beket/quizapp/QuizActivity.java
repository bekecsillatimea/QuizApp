package com.example.beket.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    String name, currentQuestion;
    String QUESTION_KEY = "QUESTION", RESULT_KEY = "RESULT", CORRECT_ANSWER_TEXT_KEY = "ANSWER",
            CORRECT_ANSWER_BACKGROUND_KEY = "BACKGROUND", BUTTON_TEXT_KEY = "BUTTON";
    boolean isAnswerCorrect;
    ImageView catsImageView;
    TextView questionTextView, correctAnswer;
    RadioGroup threeRadioGroup, trueOrFalseRadioGroup;
    RadioButton firstRadioButton, secondRadioButton, thirdRadioButton,
            trueRadioButton, falseRadioButton, answer;
    EditText inputAnswerEditText;
    CheckBox firstCheckbox, secondCheckBox, thirdCheckbox;
    Button nextButton;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("UserName");
        }
        catsImageView = (ImageView) findViewById(R.id.cats_image_view);
        questionTextView = (TextView) findViewById(R.id.question_text_view);
        threeRadioGroup = (RadioGroup) findViewById(R.id.radio_group_three);
        firstRadioButton = (RadioButton) findViewById(R.id.radio_one);
        secondRadioButton = (RadioButton) findViewById(R.id.radio_two);
        thirdRadioButton = (RadioButton) findViewById(R.id.radio_three);
        trueOrFalseRadioGroup = (RadioGroup) findViewById(R.id.radio_group_true_false);
        trueRadioButton = (RadioButton) findViewById(R.id.radio_true);
        falseRadioButton = (RadioButton) findViewById(R.id.radio_false);
        inputAnswerEditText = (EditText) findViewById(R.id.edit_text);
        firstCheckbox = (CheckBox) findViewById(R.id.checkbox_one);
        secondCheckBox = (CheckBox) findViewById(R.id.checkbox_two);
        thirdCheckbox = (CheckBox) findViewById(R.id.checkbox_three);
        correctAnswer = (TextView) findViewById(R.id.answer_text_view);
        nextButton = (Button) findViewById(R.id.next_button);

        if (savedInstanceState != null) {
            currentQuestion = savedInstanceState.getString(QUESTION_KEY);
            result = savedInstanceState.getInt(RESULT_KEY);
            if (currentQuestion.contains("1.")) {
                SetQuestion.setFirstQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        firstRadioButton, secondRadioButton, thirdRadioButton, catsImageView);
            } else if (currentQuestion.contains("2.")) {
                SetQuestion.setSecondQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView);
            } else if (currentQuestion.contains("3.")) {
                SetQuestion.setThirdQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView);
            } else if (currentQuestion.contains("4.")) {
                SetQuestion.setFourthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
            } else if (currentQuestion.contains("5.")) {
                SetQuestion.setFifthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
            } else if (currentQuestion.contains("6.")) {
                SetQuestion.setSixthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView);
            } else if (currentQuestion.contains("7.")) {
                SetQuestion.setSeventhQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
            } else if (currentQuestion.contains("8.")) {
                SetQuestion.setEighthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView);
            } else if (currentQuestion.contains("9.")) {
                SetQuestion.setNinthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
            } else if (currentQuestion.contains("10.")) {
                SetQuestion.setTenthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                        secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                        threeRadioGroup, catsImageView);
            }
            nextButton.setText(savedInstanceState.getString(BUTTON_TEXT_KEY));
            if (!savedInstanceState.getString(CORRECT_ANSWER_TEXT_KEY).isEmpty()) {
                correctAnswer.setText(savedInstanceState.getString(CORRECT_ANSWER_TEXT_KEY));
                if (savedInstanceState.getBoolean(CORRECT_ANSWER_BACKGROUND_KEY)) {
                    CheckQuestion.setAnswerRight(correctAnswer);
                    isAnswerCorrect = savedInstanceState.getBoolean(CORRECT_ANSWER_BACKGROUND_KEY);
                } else {
                    CheckQuestion.setAnswerWrong(correctAnswer);
                }
            }
        } else {
            SetQuestion.setFirstQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    firstRadioButton, secondRadioButton, thirdRadioButton, catsImageView);
        }
    }

    @SuppressLint("NewApi")
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        currentQuestion = questionTextView.getText().toString();
        savedInstanceState.putString(QUESTION_KEY, currentQuestion);
        savedInstanceState.putString(BUTTON_TEXT_KEY, nextButton.getText().toString());
        savedInstanceState.putInt(RESULT_KEY, result);
        savedInstanceState.putString(CORRECT_ANSWER_TEXT_KEY, correctAnswer.getText().toString());
        if (correctAnswer.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean(CORRECT_ANSWER_BACKGROUND_KEY, isAnswerCorrect);
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    //sets next question according to current one
    private void setNextQuestion() {
        currentQuestion = questionTextView.getText().toString();
        correctAnswer.setVisibility(View.GONE);
        if (currentQuestion.contains("1.")) {
            SetQuestion.setSecondQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView);
        } else if (currentQuestion.contains("2.")) {
            SetQuestion.setThirdQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView);
        } else if (currentQuestion.contains("3.")) {
            SetQuestion.setFourthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
        } else if (currentQuestion.contains("4.")) {
            SetQuestion.setFifthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
        } else if (currentQuestion.contains("5.")) {
            SetQuestion.setSixthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView);
        } else if (currentQuestion.contains("6.")) {
            SetQuestion.setSeventhQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
        } else if (currentQuestion.contains("7.")) {
            SetQuestion.setEighthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView);
        } else if (currentQuestion.contains("8.")) {
            SetQuestion.setNinthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView, firstRadioButton, secondRadioButton, thirdRadioButton);
        } else if (currentQuestion.contains("9.")) {
            SetQuestion.setTenthQuestion(trueOrFalseRadioGroup, inputAnswerEditText, firstCheckbox,
                    secondCheckBox, thirdCheckbox, correctAnswer, nextButton, questionTextView,
                    threeRadioGroup, catsImageView);
        }
    }

    // adds point is answer is correct
    private void addToResult() {
        if (isAnswerCorrect) {
            result += 1;
        }
    }

    // checks answers according to question
    private void checkQuestion(){
        if (currentQuestion.contains("1.") && threeRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkFirstQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("2.") && (firstCheckbox.isChecked() || secondCheckBox.isChecked() || thirdCheckbox.isChecked())) {
            isAnswerCorrect = CheckQuestion.checkSecondQuestion(firstCheckbox, secondCheckBox, thirdCheckbox, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("3.") && trueOrFalseRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = trueOrFalseRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkThirdQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("4.") && threeRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkFourthQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("5.") && threeRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkFifthQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("6.") && (firstCheckbox.isChecked() || secondCheckBox.isChecked() || thirdCheckbox.isChecked())) {
            isAnswerCorrect = CheckQuestion.checkSixthQuestion(firstCheckbox, secondCheckBox, thirdCheckbox, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("7.") && threeRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkSeventhQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("8.") && trueOrFalseRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = trueOrFalseRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkEighthQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("9.") && threeRadioGroup.getCheckedRadioButtonId() != -1) {
            int selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = (RadioButton) findViewById(selectedId);
            isAnswerCorrect = CheckQuestion.checkNinthQuestion(answer, correctAnswer, nextButton);
            addToResult();
        } else if (currentQuestion.contains("10.") && !inputAnswerEditText.getText().toString().isEmpty()) {
            String inputAnswer = inputAnswerEditText.getText().toString().trim();
            String wrongAnswer = (getString(R.string.tenth_question_second_correct_answer, inputAnswer));
            isAnswerCorrect = CheckQuestion.checkTenthQuestion(inputAnswer, wrongAnswer, correctAnswer, nextButton);
            addToResult();
        } else {
            Toast.makeText(QuizActivity.this, R.string.input_answer, Toast.LENGTH_SHORT).show();
        }
    }

    // checks button text
    public void checkButton(View v) {
        currentQuestion = questionTextView.getText().toString();
        if (nextButton.getText().toString().contains("Reset")) {
            Intent resetIntent = getIntent();
            finish();
            startActivity(resetIntent);
        } else if (nextButton.getText().toString().contains("Submit")) {
            correctAnswer.setVisibility(View.GONE);
            Toast.makeText(QuizActivity.this, name + ", you got " + result + " out of 10 right!", Toast.LENGTH_LONG).show();
            nextButton.setText(R.string.button_reset);
        } else if (nextButton.getText().toString().contains("Next")) {
            setNextQuestion();
        } else if (nextButton.getText().toString().contains("Check")) {
            checkQuestion();
        }
    }
}