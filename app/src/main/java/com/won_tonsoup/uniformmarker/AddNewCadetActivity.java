package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewCadetActivity extends AppCompatActivity {

    String cadetFirst;
    String cadetLast;
    int cadetFlight;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference cadetsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cadet);
        setTitle("Add New Cadet");
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        cadetsDatabaseReference = firebaseDatabase.getReference().child("Cadets");
        final TextView errorMsg = (TextView) findViewById(R.id.intErrorMessage);
        final EditText addFirst = (EditText) findViewById(R.id.addFirstText);
        final EditText addLast = (EditText) findViewById(R.id.addLastText);
        final EditText addFlight = (EditText) findViewById(R.id.addFlightText);
        Button addCadetButton = (Button) findViewById(R.id.addNewCadetButton);
        errorMsg.setVisibility(View.INVISIBLE);
        addCadetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean isInt = true;
                if(addFirst.getText().toString().isEmpty() || addLast.getText().toString().isEmpty() || addFlight.getText().toString().isEmpty()) {
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    try {
                        Integer.parseInt(addFlight.getText().toString());
                    } catch(NumberFormatException e){
                        errorMsg.setVisibility(View.VISIBLE);
                        isInt = false;
                    }
                    if(isInt) {
                        cadetFirst = addFirst.getText().toString();
                        cadetLast = addLast.getText().toString();
                        cadetFlight = Integer.parseInt(addFlight.getText().toString());
                        Cadet newCadet = new Cadet(cadetFirst, cadetLast, cadetFlight, cadetFirst + cadetLast);
                        cadetsDatabaseReference.push().setValue(newCadet);
                        finish();
                    }
                }
            }
        });
    }
}
