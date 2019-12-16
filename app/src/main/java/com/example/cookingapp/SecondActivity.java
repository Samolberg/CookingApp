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
        Switch fetaSwitch = findViewById(R.id.fetaSwitch);
        Switch carrotSwitch = findViewById(R.id.carrotSwitch);
        Switch tomatoSwitch = findViewById(R.id.tomatoSwitch);
        Switch potatoSwitch = findViewById(R.id.potatoSwitch);
        Switch koorSwitch = findViewById(R.id.koorSwitch);
        Switch kapsasSwitch = findViewById(R.id.kapsasSwitch);
        if (chickenSwitch.isChecked()){
            selected.add("kana");
        }if (meatSwitch.isChecked()){
            selected.add("liha");
        }if (fetaSwitch.isChecked()){
            selected.add("feta");
        }if (tomatoSwitch.isChecked()){
            selected.add("tomat");
        }if (potatoSwitch.isChecked()){
            selected.add("kartul");
        }if (carrotSwitch.isChecked()){
            selected.add("porgand");
        }if (koorSwitch.isChecked()){
            selected.add("koor");
        }if (kapsasSwitch.isChecked()){
            selected.add("hapukapsas");
        }
        Intent recipieIntent = new Intent (this, RecipieActivity.class);
        recipieIntent.putStringArrayListExtra("selected",selected);
        startActivity(recipieIntent);
    }
}