package com.example.beket.quizapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by beket on 1/24/2018.
 */

class CheckQuestion {

    private static boolean isCorrect;

    // sets red color for wrong answer
    @SuppressLint("NewApi")
    static void setAnswerWrong(TextView correctAnswer) {
        GradientDrawable gradientDrawableWrong = new GradientDrawable();
        gradientDrawableWrong.setShape(GradientDrawable.RECTANGLE);
        gradientDrawableWrong.setColor(Color.RED);
        correctAnswer.setVisibility(View.VISIBLE);
        correctAnswer.setBackground(gradientDrawableWrong);
    }

    // sets green color for right answer
    @SuppressLint("NewApi")
    static void setAnswerRight(TextView correctAnswer) {
        GradientDrawable gradientDrawableRight = new GradientDrawable();
        gradientDrawableRight.setShape(GradientDrawable.RECTANGLE);
        gradientDrawableRight.setColor(Color.GREEN);
        correctAnswer.setVisibility(View.VISIBLE);
        correctAnswer.setBackground(gradientDrawableRight);
    }

    // checks first question and gives correct answer
    static boolean checkFirstQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("70")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.first_question_first_correct_answer);
            isCorrect = true;

        } else if (answer.getText().toString().contains("50")) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.first_question_second_correct_answer);
            isCorrect = false;

        } else if (answer.getText().toString().contains("85")) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.first_question_third_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks second question and gives correct answer
    static boolean checkSecondQuestion(CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                       TextView correctAnswer, Button nextButton) {
        if (firstCheckbox.isChecked() && secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.second_question_first_correct_answer);
            isCorrect = true;
        } else if (firstCheckbox.isChecked() && !secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_second_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_third_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && !secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_fourth_correct_answer);
            isCorrect = false;
        } else if (firstCheckbox.isChecked() && !secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_fifth_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_sixth_correct_answer);
            isCorrect = false;
        } else if (firstCheckbox.isChecked() && secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.second_question_seventh_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks third question and gives correct answer
    static boolean checkThirdQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("True")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.third_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.third_question_second_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks fourth question and gives correct answer
    static boolean checkFourthQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("Egypt")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.fourth_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.fourth_question_second_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks fifth question and gives correct answer
    static boolean checkFifthQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("6")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.fifth_question_first_correct_answer);
            isCorrect = true;
        } else if (answer.getText().toString().contains("2")) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.fifth_question_second_correct_answer);
            isCorrect = false;
        } else if (answer.getText().toString().contains("4.5")) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.fifth_question_third_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks sixth question and gives correct answer
    static boolean checkSixthQuestion(CheckBox firstCheckbox, CheckBox secondCheckBox, CheckBox thirdCheckbox,
                                      TextView correctAnswer, Button nextButton) {
        if (firstCheckbox.isChecked() && !secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_first_correct_answer);
            isCorrect = true;
        } else if (firstCheckbox.isChecked() && !secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_second_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_third_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && !secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_fourth_correct_answer);
            isCorrect = false;
        } else if (firstCheckbox.isChecked() && secondCheckBox.isChecked() && !thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_fifth_correct_answer);
            isCorrect = false;
        } else if (!firstCheckbox.isChecked() && secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_sixth_correct_answer);
            isCorrect = false;
        } else if (firstCheckbox.isChecked() && secondCheckBox.isChecked() && thirdCheckbox.isChecked()) {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.sixth_question_seventh_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks seventh question and gives correct answer
    static boolean checkSeventhQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("nose")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.seventh_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.seventh_question_second_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks eight question and gives correct answer
    static boolean checkEighthQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("True")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.eighth_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.eighth_question_second_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks ninth question and gives correct answer
    static boolean checkNinthQuestion(RadioButton answer, TextView correctAnswer, Button nextButton) {
        if (answer.getText().toString().contains("90%")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.ninth_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(R.string.ninth_question_second_correct_answer);
            isCorrect = false;
        }
        nextButton.setText(R.string.next_button);
        return isCorrect;
    }

    // checks tenth question and gives correct answer
    static boolean checkTenthQuestion(String inputAnswer, String wrongAnswer, TextView correctAnswer, Button nextButton) {
        if (inputAnswer.contains("foot pads") && !inputAnswer.contains("nose") && !inputAnswer.contains("tongue")) {
            setAnswerRight(correctAnswer);
            correctAnswer.setText(R.string.tenth_question_first_correct_answer);
            isCorrect = true;
        } else {
            setAnswerWrong(correctAnswer);
            correctAnswer.setText(wrongAnswer);
            isCorrect = false;
        }
        nextButton.setText(R.string.button_submit);
        return isCorrect;
    }
}
