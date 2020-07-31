package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EditListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditRecyclerAdapter adapter;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference cadetsDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addedit_cadet_list);
        recyclerView = findViewById(R.id.recycler_view_edit);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        cadetsDatabaseReference = firebaseDatabase.getReference().child("Cadets");

        setTitle("Edit Cadet List");

        cadetsDatabaseReference.orderByChild("last").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Cadet> cadetList = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Cadet cadet = ds.getValue(Cadet.class);
                    cadetList.add(cadet);
                }
                adapter = new EditRecyclerAdapter(cadetList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_tool, menu);
        MenuItem addItem = menu.findItem(R.id.add_button);
        MenuItem searchItem = menu.findItem(R.id.filter_search_edit);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        addItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(EditListActivity.this, AddNewCadetActivity.class);
                startActivity(intent);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}
