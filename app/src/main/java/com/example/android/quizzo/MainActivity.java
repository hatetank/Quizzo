package com.example.android.quizzo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gradeQuiz(View view) {
        int numberCorrect = 0;

        // extract answers for grading
        EditText answer1 = (EditText) findViewById(R.id.answer1);
        EditText answer4 = (EditText) findViewById(R.id.answer4);
        CheckBox cb1 = (CheckBox) findViewById(R.id.vertical_orientation_checkbox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.horizontal_orientation_checkbox);
        CheckBox cb3 = (CheckBox) findViewById(R.id.overflow_orientation_checkbox);
        CheckBox cb4 = (CheckBox) findViewById(R.id.directional_orientation_checkbox);
        CheckBox cb5 = (CheckBox) findViewById(R.id.new_user_orientation_checkbox);
        RadioButton answer3 = (RadioButton) findViewById(R.id.answer3);
        RadioButton answer5 = (RadioButton) findViewById(R.id.answer5);

        // Grade question 1
        if (answer1.getText().toString().equalsIgnoreCase("TextView")) {
            numberCorrect++;
        }

        // Grade question 2
        // verify correct answers checked
        if (cb1.isChecked() && cb2.isChecked()) {
            // verify no incorrect answers checked
            if (!(cb3.isChecked() || cb4.isChecked() || cb5.isChecked())) {
                numberCorrect++;
            }
        }

        // Grade question 3
        if (answer3.isChecked()) {
            numberCorrect++;
        }
        // Grade question 4
        if (answer4.getText().toString().equalsIgnoreCase("Intent")) {
            numberCorrect++;
        }
        // Grade question 5
        if (answer5.isChecked()) {
            numberCorrect++;
        }

        // display grade to user
        popGradeToast(createResultText(numberCorrect));
    }

    /**
     * Builds the String for grading results.
     *
     * @param numberCorrect number of correct guesses
     * @return text of quiz results
     */
    private String createResultText(int numberCorrect) {
        Double percent = numberCorrect / 5.0 * 100.0;
        return String.format(Locale.getDefault(), "You got %d out of 5 correct!\nGrade: %d%%",
                numberCorrect, percent.intValue());
    }

    /**
     * Pops a toast with Quiz results
     *
     * @param gradingText message to display in toast
     */
    private void popGradeToast(String gradingText) {
        Toast.makeText(this, gradingText, Toast.LENGTH_LONG).show();
    }
}
