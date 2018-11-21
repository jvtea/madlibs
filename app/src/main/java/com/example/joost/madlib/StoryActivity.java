package com.example.joost.madlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // get story from intent
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");

        // int storyTextID = getResources().getIdentifier("storyText", "id", getPackageName());
        TextView storyText = findViewById(R.id.storyText);

        storyText.setText(story.toString());
    }

    public void newStoryClicked (View view) {
        Intent intent = new Intent(this, StoryPickActivity.class);
        startActivity(intent);
        finish();
    }

}
