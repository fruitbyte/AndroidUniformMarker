package com.won_tonsoup.uniformmarker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class DataMenu extends AppCompatActivity {

    TextView lowest_score;
    TextView scores_under_twelve;
    TextView average;
    TextView dataCollected;
    TextView dateSelected;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference scoresDatabaseReference;

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    ArrayList<Integer> scoreList = new ArrayList<>();
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        lowest_score = findViewById(R.id.lowNumber);
        scores_under_twelve = findViewById(R.id.lessNumber);
        average = findViewById(R.id.avgNumber);
        dataCollected = findViewById(R.id.dataCollected);
        dateSelected = findViewById(R.id.dateSelected);
        actionBar.hide();

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        scoresDatabaseReference = firebaseDatabase.getReference().child("Scores");

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month++;
                date = month + "-" + dayOfMonth + "-" + year;
                dateSelected.setText(date);


                scoresDatabaseReference.orderByChild("timestamp").equalTo(date).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            DataSender dataSender = ds.getValue(DataSender.class);
                            scoreList.add(dataSender.getScore());
                        }
                        //Find Scores Less Than 12
                        int underTwelve = 0;
                        int sum = 0;
                        for(int i = 0; i < scoreList.size(); i++){
                            if(scoreList.get(i) <= 12){
                                underTwelve++;
                            }
                            sum = sum + scoreList.get(i);
                        }
                        scores_under_twelve.setText(String.valueOf(underTwelve));

                        //Calculate Average
                        double averageNumber = sum / scoreList.size();
                        average.setText(String.valueOf(averageNumber));

                        //Find Lowest Score
                        int lowscore = Collections.min(scoreList);
                        lowest_score.setText(String.valueOf(lowscore));

                        //Find amount of data collected
                        dataCollected.setText(String.valueOf(scoreList.size()));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });


            }
        };
    }

    public void individualDataClick(View view) {
        Intent intent = new Intent(this, IndividualDataList.class);
        intent.putExtra("date", date);
        startActivity(intent);
    }

    public void datePick(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, dayOfMonth);
        datePickerDialog.getWindow();
        datePickerDialog.show();
    }
}
