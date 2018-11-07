package com.example.beket.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizActivity extends AppCompatActivity {

    String name, currentQuestion;
    String QUESTION_KEY = "QUESTION", RESULT_KEY = "RESULT", CORRECT_ANSWER_TEXT_KEY = "ANSWER",
            CORRECT_ANSWER_BACKGROUND_KEY = "BACKGROUND", BUTTON_TEXT_KEY = "BUTTON";
    boolean isAnswerCorrect;
    @BindView(R.id.cats_image_view)
    ImageView catsImageView;
    @BindView(R.id.question_text_view)
    TextView questionTextView;
    @BindView(R.id.answer_text_view)
    TextView correctAnswer;
    @BindView(R.id.radio_group_three)
    RadioGroup threeRadioGroup;
    @BindView(R.id.radio_group_true_false)
    RadioGroup trueOrFalseRadioGroup;
    @BindView(R.id.radio_one)
    RadioButton firstRadioButton;
    @BindView(R.id.radio_two)
    RadioButton secondRadioButton;
    @BindView(R.id.radio_three)
    RadioButton thirdRadioButton;
    @BindView(R.id.edit_text)
    EditText inputAnswerEditText;
    @BindView(R.id.checkbox_one)
    CheckBox firstCheckbox;
    @BindView(R.id.checkbox_two)
    CheckBox secondCheckBox;
    @BindView(R.id.checkbox_three)
    CheckBox thirdCheckbox;
    @BindView(R.id.next_button)
    Button nextButton;
    RadioButton answer;

    int result = 0, checkboxType = 0, threeRadioGroupType = 1,
            trueOrFalseRadioGroupType = 2, inputAnswerEditTextType = 3;
    String[] questions, emptyArray;
    int[] catsImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("UserName");
        }
        questions = getResources().getStringArray(R.array.questions);
        emptyArray = new String[]{""};
        catsImages = new int[]{R.drawable.sleepingcat, R.drawable.purringcat, R.drawable.meowcat,
                R.drawable.egyptcat, R.drawable.jumpingcat, R.drawable.earcat,
                R.drawable.nosecat, R.drawable.litterkittenscat,
                R.drawable.braincat, R.drawable.footpadcat};

        if (savedInstanceState != null) {
            currentQuestion = savedInstanceState.getString(QUESTION_KEY);
            Arrays.asList(questions).contains(currentQuestion);
            result = savedInstanceState.getInt(RESULT_KEY);
            onScreenRotation();
            nextButton.setText(savedInstanceState.getString(BUTTON_TEXT_KEY));
            if (!TextUtils.isEmpty(savedInstanceState.getString(CORRECT_ANSWER_TEXT_KEY))) {
                correctAnswer.setText(savedInstanceState.getString(CORRECT_ANSWER_TEXT_KEY));
                if (savedInstanceState.getBoolean(CORRECT_ANSWER_BACKGROUND_KEY)) {
                    CheckQuestion.setAnswerRight(correctAnswer);
                } else {
                    CheckQuestion.setAnswerWrong(correctAnswer);
                }
            }
        } else {
            setQuestion(1, questions[0], catsImages[0],
                    getResources().getStringArray(R.array.firstQuestionAnswers));
        }
    }

    // sets correct question in case of screen rotation
    private void onScreenRotation() {
        switch (getIndex()) {
            case 0:
                setQuestion(threeRadioGroupType, questions[0], catsImages[0],
                        getResources().getStringArray(R.array.firstQuestionAnswers));
                break;
            case 1:
                setQuestion(checkboxType, questions[1], catsImages[1],
                        getResources().getStringArray(R.array.secondQuestionAnswers));
                break;
            case 2:
                setQuestion(trueOrFalseRadioGroupType, questions[2], catsImages[2], emptyArray);
                break;
            case 3:
                setQuestion(threeRadioGroupType, questions[3], catsImages[3],
                        getResources().getStringArray(R.array.fourthQuestionAnswers));
                break;
            case 4:
                setQuestion(threeRadioGroupType, questions[4], catsImages[4],
                        getResources().getStringArray(R.array.fifthQuestionAnswers));
                break;
            case 5:
                setQuestion(checkboxType, questions[5], catsImages[5],
                        getResources().getStringArray(R.array.sixthQuestionAnswers));
                break;
            case 6:
                setQuestion(threeRadioGroupType, questions[6], catsImages[6],
                        getResources().getStringArray(R.array.seventhQuestionAnswers));
                break;
            case 7:
                setQuestion(trueOrFalseRadioGroupType, questions[7], catsImages[7], emptyArray);
                break;
            case 8:
                setQuestion(threeRadioGroupType, questions[8], catsImages[8],
                        getResources().getStringArray(R.array.ninthQuestionAnswers));
                break;
            case 9:
                setQuestion(inputAnswerEditTextType, questions[9], catsImages[9], emptyArray);
                break;
        }
    }

    //gets current questions index from questions list
    private int getIndex() {
        int index = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i].equals(currentQuestion)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // sets current question
    private void setQuestion(int type, String question, int imageId, String[] questionAnswer) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(question);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(imageId);
        threeRadioGroup.clearCheck();
        firstCheckbox.setChecked(false);
        secondCheckBox.setChecked(false);
        thirdCheckbox.setChecked(false);
        trueOrFalseRadioGroup.clearCheck();
        inputAnswerEditText.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        correctAnswer.setVisibility(View.GONE);
        switch (type) {
            case 0:
                firstCheckbox.setText(questionAnswer[0]);
                secondCheckBox.setText(questionAnswer[1]);
                thirdCheckbox.setText(questionAnswer[2]);
                firstCheckbox.setVisibility(View.VISIBLE);
                secondCheckBox.setVisibility(View.VISIBLE);
                thirdCheckbox.setVisibility(View.VISIBLE);
                break;
            case 1:
                firstRadioButton.setText(questionAnswer[0]);
                secondRadioButton.setText(questionAnswer[1]);
                thirdRadioButton.setText(questionAnswer[2]);
                threeRadioGroup.setVisibility(View.VISIBLE);
                break;
            case 2:
                trueOrFalseRadioGroup.setVisibility(View.VISIBLE);
                break;
            case 3:
                inputAnswerEditText.setVisibility(View.VISIBLE);
                break;
        }

    }

    @SuppressLint("NewApi")
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        currentQuestion = questionTextView.getText().toString();
        savedInstanceState.putString(QUESTION_KEY, currentQuestion);
        savedInstanceState.putString(BUTTON_TEXT_KEY, nextButton.getText().toString());
        savedInstanceState.putInt(RESULT_KEY, result);
        if (correctAnswer.getVisibility() == View.VISIBLE) {
            savedInstanceState.putString(CORRECT_ANSWER_TEXT_KEY, correctAnswer.getText().toString());
            savedInstanceState.putBoolean(CORRECT_ANSWER_BACKGROUND_KEY, isAnswerCorrect);
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    //sets next question according to current one
    private void setNextQuestion() {
        switch (getIndex()) {
            case 0:
                setQuestion(checkboxType, questions[1], catsImages[1],
                        getResources().getStringArray(R.array.secondQuestionAnswers));
                break;
            case 1:
                setQuestion(trueOrFalseRadioGroupType, questions[2], catsImages[2], emptyArray);
                break;
            case 2:
                setQuestion(threeRadioGroupType, questions[3], catsImages[3],
                        getResources().getStringArray(R.array.fourthQuestionAnswers));
                break;
            case 3:
                setQuestion(threeRadioGroupType, questions[4], catsImages[4],
                        getResources().getStringArray(R.array.fifthQuestionAnswers));
                break;
            case 4:
                setQuestion(checkboxType, questions[5], catsImages[5],
                        getResources().getStringArray(R.array.sixthQuestionAnswers));
                break;
            case 5:
                setQuestion(threeRadioGroupType, questions[6], catsImages[6],
                        getResources().getStringArray(R.array.seventhQuestionAnswers));
                break;
            case 6:
                setQuestion(trueOrFalseRadioGroupType, questions[7], catsImages[7], emptyArray);
                break;
            case 7:
                setQuestion(threeRadioGroupType, questions[8], catsImages[8],
                        getResources().getStringArray(R.array.ninthQuestionAnswers));
                break;
            case 8:
                setQuestion(inputAnswerEditTextType, questions[9], catsImages[9], emptyArray);
                break;
        }
    }

    // adds point if answer is correct
    private void addToResult() {
        if (isAnswerCorrect) {
            result += 1;
        }
    }

    // gets the selected id from radio groups
    private void checkedRadio() {
        int selectedId;
        if (threeRadioGroup.getVisibility() == View.VISIBLE) {
            selectedId = threeRadioGroup.getCheckedRadioButtonId();
            answer = findViewById(selectedId);
        } else if (trueOrFalseRadioGroup.getVisibility() == View.VISIBLE) {
            selectedId = trueOrFalseRadioGroup.getCheckedRadioButtonId();
            answer = findViewById(selectedId);
        }
    }

    // checks answers according to question
    private void checkQuestion() {
        currentQuestion = questionTextView.getText().toString();
        checkedRadio();
        switch (getIndex()) {
            case 0:
                isAnswerCorrect = CheckQuestion.checkFirstQuestion(answer, correctAnswer, nextButton);
                break;
            case 1:
                isAnswerCorrect = CheckQuestion.checkSecondQuestion(firstCheckbox, secondCheckBox, thirdCheckbox, correctAnswer, nextButton);
                break;
            case 2:
                isAnswerCorrect = CheckQuestion.checkThirdQuestion(answer, correctAnswer, nextButton);
                break;
            case 3:
                isAnswerCorrect = CheckQuestion.checkFourthQuestion(answer, correctAnswer, nextButton);
                break;
            case 4:
                isAnswerCorrect = CheckQuestion.checkFifthQuestion(answer, correctAnswer, nextButton);
                break;
            case 5:
                isAnswerCorrect = CheckQuestion.checkSixthQuestion(firstCheckbox, secondCheckBox, thirdCheckbox, correctAnswer, nextButton);
                break;
            case 6:
                isAnswerCorrect = CheckQuestion.checkSeventhQuestion(answer, correctAnswer, nextButton);
                break;
            case 7:
                isAnswerCorrect = CheckQuestion.checkEighthQuestion(answer, correctAnswer, nextButton);
                break;
            case 8:
                isAnswerCorrect = CheckQuestion.checkNinthQuestion(answer, correctAnswer, nextButton);
                break;
            case 9:
                String inputAnswer = inputAnswerEditText.getText().toString().trim();
                String wrongAnswer = (getString(R.string.tenth_question_second_correct_answer, inputAnswer));
                isAnswerCorrect = CheckQuestion.checkTenthQuestion(inputAnswer, wrongAnswer, correctAnswer, nextButton);
                break;
        }
        addToResult();
    }

    // gets question type
    private int getQuestionType() {
        int type = -1;

        if (firstCheckbox.getVisibility() == View.VISIBLE) {
            type = checkboxType;
        } else if (threeRadioGroup.getVisibility() == View.VISIBLE) {
            type = threeRadioGroupType;
        } else if (trueOrFalseRadioGroup.getVisibility() == View.VISIBLE) {
            type = trueOrFalseRadioGroupType;
        } else if (inputAnswerEditText.getVisibility() == View.VISIBLE) {
            type = inputAnswerEditTextType;
        }
        return type;
    }

    // checks if question is answered according to its type
    private boolean checkIfQuestionIsAnswered(int type) {
        boolean isAnswered = false;
        switch (type) {
            case 0:
                if (firstCheckbox.isChecked() || secondCheckBox.isChecked() || thirdCheckbox.isChecked()) {
                    isAnswered = true;
                }
                break;
            case 1:
                if (threeRadioGroup.getCheckedRadioButtonId() != -1) {
                    isAnswered = true;
                }
                break;
            case 2:
                if (trueOrFalseRadioGroup.getCheckedRadioButtonId() != -1) {
                    isAnswered = true;
                }
                break;
            case 3:
                if (!inputAnswerEditText.getText().toString().isEmpty()) {
                    isAnswered = true;
                }
                break;
        }
        return isAnswered;
    }

    // checks button text
    @OnClick(R.id.next_button)
    public void checkButton() {
        String buttonText = nextButton.getText().toString();
        if (buttonText.contains("Reset")) {
            Intent resetIntent = getIntent();
            startActivity(resetIntent);
        } else if (buttonText.contains("Next")) {
            setNextQuestion();
        } else if (buttonText.contains("Check")) {
            if (checkIfQuestionIsAnswered(getQuestionType())) {
                checkQuestion();
            } else {
                Toast.makeText(QuizActivity.this, R.string.input_answer, Toast.LENGTH_SHORT).show();
            }
        } else if (buttonText.contains("Submit")) {
            correctAnswer.setVisibility(View.GONE);
            Toast.makeText(QuizActivity.this, name + ", you got " + result + " out of 10 right!", Toast.LENGTH_LONG).show();
            nextButton.setText(R.string.button_reset);
        }
    }
}