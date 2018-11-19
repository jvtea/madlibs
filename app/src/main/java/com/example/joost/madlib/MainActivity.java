package com.example.joost.madlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // function to go to next story picking screen
    public void beginClicked (View view) {

        Intent intent = new Intent(this, StoryPickActivity.class);
        startActivity(intent);

        // probeer zoner finish hier of met back altijd naar dit scherm.
    }


}
