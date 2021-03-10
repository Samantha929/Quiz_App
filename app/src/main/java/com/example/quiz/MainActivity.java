package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    Button trueButton;
    Button falseButton;
    TextView scoreTextView;
    TextView questionTextView;
    ProgressBar progressBar;
    int index;
    int question;
    int score;

    Toast toastMessage;

    private TrueFalse[] questionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, false),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, false),
            new TrueFalse(R.string.question_6, true),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, true),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true),
    };

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        scoreTextView = findViewById(R.id.score);
        questionTextView = findViewById(R.id.question_text_view);
        progressBar = findViewById(R.id.progress_bar);


        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("ScoreKey");
            index = savedInstanceState.getInt("IndexKey");
            scoreTextView.setText("Score" + score + "/" + questionBank.length);
        }

        else {
            score = 0;
            index = 0;
        }

        trueButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                Log.d("Quiz", "True button clicked");
                makeText(getApplicationContext(), "True Button Clicked", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        });

        falseButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                Log.d("Quiz", "False button clicked");
                makeText(getApplicationContext(), "False Button Clicked", Toast.LENGTH_SHORT).show();
                updateQuestion();
            };
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey", score);
        outState.putInt("IndexKey", index);
    }

    private void updateQuestion() {
        index = (index +1) % questionBank.length; //index+=1;
        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        scoreTextView.setText("Score" + score + "/" + questionBank.length);

        question = questionBank[index].getQuestionID();
        questionTextView.setText(question);
    }

    private void checkAnswer(boolean userSelection) {
        boolean correctAnswer = questionBank[index].isAnswer();

        if(userSelection == correctAnswer) {
            toastMessage = makeText(getApplicationContext(), "Answer Well Done", Toast.LENGTH_LONG);
            score = score + 1;
        }

        else {
                toastMessage = makeText(getApplicationContext(), "OPS! Not Right", Toast.LENGTH_SHORT);
            }

        }
}


