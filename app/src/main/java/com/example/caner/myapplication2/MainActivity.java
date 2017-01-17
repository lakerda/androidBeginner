package com.example.caner.myapplication2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    private void setViews(){

        final TextView mainView =  (TextView) findViewById(R.id.main_main_view);    //parantez içinde cast ediyoruz belirtiyoruz ne olduğunu

        final TextView otherView = (TextView) findViewById(R.id.main_main_other);
        String text2 = "caner";

        final String text2Final = text2;
        Button mainButton = (Button) findViewById(R.id.main_click_button);


        //getSharedPreferences komutu eklendi
        boolean isFirstRun = getSharedPreferences("Preferences", MODE_PRIVATE).getBoolean("isFirstRun",true);

        if(isFirstRun) {

            mainButton.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                EditText mainEdit = (EditText) findViewById(R.id.main_main_edit);
                String text = mainEdit.getText().toString();


                mainView.setText(text);
                getSharedPreferences("Preferences", MODE_PRIVATE).edit().putInt("isFirstRun",3).commit();
                //otherView.setText(text2Final);

            }
        });}

        else {




            mainButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EditText mainEdit = (EditText) findViewById(R.id.main_main_edit);
                    String text = mainEdit.getText().toString();
                    otherView.setText(text);
//                    mainView.setText(text2Final);

                }
            });}









    }
    }




