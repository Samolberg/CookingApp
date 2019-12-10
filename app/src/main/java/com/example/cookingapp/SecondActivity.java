package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void toRecipie (View view){
       ArrayList<String> selected = new ArrayList<>();
        Switch chickenSwitch = findViewById(R.id.chickenSwitch);
        Switch meatSwitch = findViewById(R.id.meatSwitch);
        if (chickenSwitch.isChecked()){
            selected.add("chicken");
        }if (meatSwitch.isChecked()){
            selected.add("meat");
        }
        Intent recipieIntent = new Intent (this, RecipieActivity.class);
        recipieIntent.putStringArrayListExtra("selected",selected);
        startActivity(recipieIntent);
    }
}