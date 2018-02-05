package com.example.beket.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by beket on 1/23/2018.
 */

 class SetQuestion {


    // sets the first question
    static void setFirstQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText, CheckBox firstCheckbox,
                                 CheckBox secondCheckBox, CheckBox thirdCheckbox, TextView correctAnswer,
                                 Button nextButton, TextView questionTextView, RadioButton firstRadioButton,
                                 RadioButton secondRadioButton, RadioButton thirdRadioButton, ImageView catsImageView) {
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        inputAnswerEditText.setVisibility(View.GONE);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        correctAnswer.setVisibility(View.GONE);
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.first_question);
        firstRadioButton.setText(R.string.first_question_first_answer);
        secondRadioButton.setText(R.string.first_question_second_answer);
        thirdRadioButton.setText(R.string.first_question_third_answer);
        catsImageView.setBackgroundResource(R.drawable.sleepingcat);
    }

    // sets the second question
    static void setSecondQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                  CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                  TextView correctAnswer, Button nextButton, TextView questionTextView,
                                  RadioGroup threeRadioGroup, ImageView catsImageView) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.second_question);
        firstCheckbox.setText(R.string.second_question_first_answer);
        secondCheckBox.setText(R.string.second_question_second_answer);
        thirdCheckbox.setText(R.string.second_question_third_answer);
        inputAnswerEditText.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.clearCheck();
        firstCheckbox.setVisibility(View.VISIBLE);
        secondCheckBox.setVisibility(View.VISIBLE);
        thirdCheckbox.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.purringcat);
        correctAnswer.setText(null);
    }

    // sets the third question
    static void setThirdQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                 CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                 TextView correctAnswer, Button nextButton, TextView questionTextView,
                                 RadioGroup threeRadioGroup, ImageView catsImageView) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.third_question);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        inputAnswerEditText.setVisibility(View.GONE);
        firstCheckbox.setChecked(false);
        secondCheckBox.setChecked(false);
        thirdCheckbox.setChecked(false);
        trueOrFalseRadioGroup.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.meowcat);
        correctAnswer.setText(null);
    }

    // sets the fourth question
    static void setFourthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                  CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                  TextView correctAnswer, Button nextButton, TextView questionTextView,
                                  RadioGroup threeRadioGroup, ImageView catsImageView, RadioButton firstRadioButton,
                                  RadioButton secondRadioButton, RadioButton thirdRadioButton) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.fourth_question);
        firstRadioButton.setText(R.string.fourth_question_first_answer);
        secondRadioButton.setText(R.string.fourth_question_second_answer);
        thirdRadioButton.setText(R.string.fourth_question_third_answer);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        inputAnswerEditText.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        trueOrFalseRadioGroup.clearCheck();
        threeRadioGroup.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.egyptcat);
        correctAnswer.setText(null);
    }

    // sets the fifth question
    static void setFifthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                 CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                 TextView correctAnswer, Button nextButton, TextView questionTextView,
                                 RadioGroup threeRadioGroup, ImageView catsImageView, RadioButton firstRadioButton,
                                 RadioButton secondRadioButton, RadioButton thirdRadioButton) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.fifth_question);
        threeRadioGroup.clearCheck();
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        inputAnswerEditText.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        firstRadioButton.setText(R.string.fifth_question_first_answer);
        secondRadioButton.setText(R.string.fifth_question_second_answer);
        thirdRadioButton.setText(R.string.fifth_question_third_answer);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.jumpingcat);
        correctAnswer.setText(null);
    }

    // sets the sixth question
    static void setSixthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                 CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                 TextView correctAnswer, Button nextButton, TextView questionTextView,
                                 RadioGroup threeRadioGroup, ImageView catsImageView) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.sixth_question);
        inputAnswerEditText.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.clearCheck();
        firstCheckbox.setText(R.string.sixth_question_first_answer);
        secondCheckBox.setText(R.string.sixth_question_second_answer);
        thirdCheckbox.setText(R.string.sixth_question_third_answer);
        firstCheckbox.setVisibility(View.VISIBLE);
        secondCheckBox.setVisibility(View.VISIBLE);
        thirdCheckbox.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.earcat);
        correctAnswer.setText(null);
    }

    // sets the seventh question
    static void setSeventhQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                   CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                   TextView correctAnswer, Button nextButton, TextView questionTextView,
                                   RadioGroup threeRadioGroup, ImageView catsImageView, RadioButton firstRadioButton,
                                   RadioButton secondRadioButton, RadioButton thirdRadioButton) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.seventh_question);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        inputAnswerEditText.setVisibility(View.GONE);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        firstCheckbox.setChecked(false);
        secondCheckBox.setChecked(false);
        thirdCheckbox.setChecked(false);
        firstRadioButton.setText(R.string.seventh_question_first_answer);
        secondRadioButton.setText(R.string.seventh_question_second_answer);
        thirdRadioButton.setText(R.string.seventh_question_third_answer);
        threeRadioGroup.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.nosecat);
        correctAnswer.setText(null);
    }

    // sets the eighth question
    static void setEighthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                  CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                  TextView correctAnswer, Button nextButton, TextView questionTextView,
                                  RadioGroup threeRadioGroup, ImageView catsImageView) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.eighth_question);
        inputAnswerEditText.setVisibility(View.GONE);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.clearCheck();
        trueOrFalseRadioGroup.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.litterkittenscat);
        correctAnswer.setText(null);
    }

    // sets the ninth question
    static void setNinthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                 CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                 TextView correctAnswer, Button nextButton, TextView questionTextView,
                                 RadioGroup threeRadioGroup, ImageView catsImageView, RadioButton firstRadioButton,
                                 RadioButton secondRadioButton, RadioButton thirdRadioButton) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.ninth_question);
        inputAnswerEditText.setVisibility(View.GONE);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        trueOrFalseRadioGroup.clearCheck();
        firstRadioButton.setText(R.string.ninth_question_first_answer);
        secondRadioButton.setText(R.string.ninth_question_second_answer);
        thirdRadioButton.setText(R.string.ninth_question_third_answer);
        threeRadioGroup.setVisibility(View.VISIBLE);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.braincat);
        correctAnswer.setText(null);
    }

    // sets the tenth question
    static void setTenthQuestion(RadioGroup trueOrFalseRadioGroup, EditText inputAnswerEditText,
                                 CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                 TextView correctAnswer, Button nextButton, TextView questionTextView,
                                 RadioGroup threeRadioGroup, ImageView catsImageView) {
        nextButton.setText(R.string.check_button);
        questionTextView.setText(R.string.tenth_question);
        firstCheckbox.setVisibility(View.GONE);
        secondCheckBox.setVisibility(View.GONE);
        thirdCheckbox.setVisibility(View.GONE);
        trueOrFalseRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.setVisibility(View.GONE);
        threeRadioGroup.clearCheck();
        inputAnswerEditText.setVisibility(View.VISIBLE);
        nextButton.setText(R.string.check_button);
        catsImageView.setBackgroundResource(0);
        catsImageView.setBackgroundResource(R.drawable.footpadcat);
        correctAnswer.setText(null);
    }
}
