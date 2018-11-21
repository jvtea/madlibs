package com.example.joost.madlib;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TypeWordsActivity extends AppCompatActivity {

    //int phTotal;
    int phLeft;
    String nextPhType;

    Story story;

    TextView infoText;

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_words);

        // get textviews
        inputText = findViewById(R.id.editText);
        infoText = findViewById(R.id.infoText);

        // set story and placeholder information
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");
        phLeft = story.getPlaceholderRemainingCount();
        nextPhType = story.getNextPlaceholder().toLowerCase();
        infoText.setText("Please enter a/an: " + nextPhType + "\n"
                           + "Words left: " + phLeft);
    }

    public int okButtonClicked (View view) {

        // if nothing filled in, don't use button functionality
        if (inputText.getText().toString().equals("")) {
            return 1;
        }

        // fill in placeholder and empty input field
        story.fillInPlaceholder(inputText.getText().toString());
        inputText.setText("");

        // if all placeholders filled in, go to story screen
        if (story.isFilledIn()) {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("story", story);
            startActivity(intent);
            finish();
            return 0;
        }
        else {
            // update for new placeholder
            phLeft = story.getPlaceholderRemainingCount();
            nextPhType = story.getNextPlaceholder().toLowerCase();
            infoText.setText("Please enter a/an: " + nextPhType + "\n"
                    + "Words left: " + phLeft);
            return 0;
        }

    }
}
