package com.example.joost.madlib;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TypeWordsActivity extends AppCompatActivity {

    int phTotal;
    int phLeft;
    String nextPhType;

    //Story story = new Story;


    int inputTextID = getResources().getIdentifier("wordInputText", "id", getPackageName());
    TextInputEditText inputText = findViewById(inputTextID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_words);

        int textID = getResources().getIdentifier("textView2", "id", getPackageName());

        TextView storyText = findViewById(textID);

        Intent intent = getIntent();

        Story story = (Story) intent.getSerializableExtra("story");

        phTotal = story.getPlaceholderCount();

        phLeft = story.getPlaceholderRemainingCount();

        nextPhType = story.getNextPlaceholder();

        storyText.setText("Please enter a: " + nextPhType + "\n"
                           + "Words left: " + phLeft);
    }

    public void okButtonClicked (View view) {

        Log.d("Input Text: ", inputText.getText().toString());

        // figure out how to do this properly, Initialize outside onCreate and with simple.txt?
        this.story.fillInPlaceholder("LEUK");
    }
}
