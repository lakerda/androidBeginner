package com.example.caner.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        redirect();
    }
    private void redirect () {

        boolean isFirstRun = getSharedPreferences("Preferences", MODE_PRIVATE).getBoolean("isFirstRun",true);

        Intent intent ;     //= new Intent(this, MainActivity.class);
        if(isFirstRun){
            intent = new Intent(Splash.this,MainActivity.class);
            getSharedPreferences("Preferences", MODE_PRIVATE).edit().putBoolean("isFirstRun",false).commit();

        }
        else {
            int goToActivity = getSharedPreferences("Preferences",MODE_PRIVATE).getInt("whereToNext",0);
            if(goToActivity == 0){

                intent = new Intent(Splash.this,Main2Activity.class);

            } else if (goToActivity == 1) {

                intent = new Intent(Splash.this,MainActivity.class);

            } else{
                intent = new Intent(Splash.this,Main2Activity.class);


            }

        }
        startActivity(intent);

    }
}
