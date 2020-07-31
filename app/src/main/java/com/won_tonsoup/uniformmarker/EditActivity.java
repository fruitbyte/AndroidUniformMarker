package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity {

    String cadetFirst;
    String cadetLast;
    int cadetFlight;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference cadetsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cadet);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        cadetsDatabaseReference = firebaseDatabase.getReference().child("Cadets");

        Intent intent = new Intent(this.getIntent());
        cadetFirst = intent.getStringExtra("first");
        cadetLast = intent.getStringExtra("last");
        cadetFlight = Integer.parseInt(intent.getStringExtra("flight"));
        setTitle("Edit Cadet");

        TextView first = (TextView) findViewById(R.id.cadetEditFirst);
        TextView last = (TextView) findViewById(R.id.cadetEditLast);
        TextView flight = (TextView) findViewById(R.id.cadetEditFlight);

        first.setText(cadetFirst);
        last.setText(cadetLast);
        flight.setText(String.valueOf(cadetFlight));
    }

    public void updateBtnClick(View view) {
        final EditText first_field = (EditText) findViewById(R.id.first_field);
        EditText last_field = (EditText) findViewById(R.id.last_field);
        EditText flight_field = (EditText) findViewById(R.id.flight_field);

        if(first_field.getText().toString().isEmpty()){
        } else {
            cadetFirst = first_field.getText().toString();
        }

        if(last_field.getText().toString().isEmpty()){
        } else {
            cadetLast = last_field.getText().toString();
        }

        if(flight_field.getText().toString().isEmpty()){
        } else {
            cadetFlight = Integer.parseInt(flight_field.getText().toString());
        }

        final String firstlast = cadetFirst + cadetLast;

        cadetsDatabaseReference.orderByChild("firstlast").equalTo(firstlast).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    final String keyValue = childSnapshot.getKey();
                    Map<String, Object> updates = new HashMap<>();
                    updates.put(keyValue + "/first", cadetFirst);
                    updates.put(keyValue + "/last", cadetLast);
                    updates.put(keyValue + "/flight", cadetFlight);
                    updates.put(keyValue + "/firstlast", firstlast);
                    cadetsDatabaseReference.updateChildren(updates);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        finish();
    }

    public void deleteBtnClick(View view) {
        String firstlast = cadetFirst + cadetLast;
        cadetsDatabaseReference.orderByChild("firstlast").equalTo(firstlast).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    snapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        finish();
    }
}
