package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class IndividualData extends AppCompatActivity {

    String cadetFirst;
    String cadetLast;
    String cadetFlight;
    String cadetScore;
    String fixmessage;

    TextView cadetTitle;
    TextView cadetFixMessage;
    TextView score;
    TextView flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_score_view);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = new Intent(this.getIntent());
        cadetFirst = intent.getStringExtra("first");
        cadetLast = intent.getStringExtra("last");
        cadetFlight = intent.getStringExtra("flight");
        cadetScore = intent.getStringExtra("score");
        fixmessage = intent.getStringExtra("fixmessage");

        cadetTitle = findViewById(R.id.cadetTitle);
        cadetFixMessage = findViewById(R.id.cadetFixMessage);
        score = findViewById(R.id.cadetScore);
        flight = findViewById(R.id.cadetFlight);

        cadetTitle.setText(cadetLast + ", " + cadetFirst);
        cadetFixMessage.setText(fixmessage);
        score.setText(cadetScore);
        flight.setText("Flight: " + cadetFlight);
    }
}
