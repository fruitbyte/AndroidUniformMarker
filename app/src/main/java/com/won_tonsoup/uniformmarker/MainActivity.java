package com.won_tonsoup.uniformmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void markBtnClick(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void editBtnClick(View view) {
        Intent intent = new Intent(this, EditListActivity.class);
        startActivity(intent);
    }

    public void statsBtnClick(View view) {
        Intent intent = new Intent(this, DataMenu.class);
        startActivity(intent);
    }

    public void infoBtnClick(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void helpBtnClick(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}
