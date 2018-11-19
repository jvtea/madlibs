package com.example.joost.madlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.InputStream;

public class StoryPickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_pick);
    }

    /** allows user to choose story */
    public void storyClicked (View view) {

        // initialize stream as simple.txt
        InputStream stream = getResources().openRawResource(R.raw.madlib0_simple);

        // choose correct stream based on id of clicked button
        switch(view.getId()) {
            case R.id.simpleButton:
                break;
            case R.id.tarzanButton:
                stream = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case R.id.universityButton:
                stream = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case R.id.clothesButton:
                stream = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case R.id.danceButton:
                stream = getResources().openRawResource(R.raw.madlib4_dance);
                break;
        }

        // set new intent with story as extra
        Story story = new Story(stream);
        Intent intent = new Intent(this, TypeWordsActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
        finish();

    }

}
