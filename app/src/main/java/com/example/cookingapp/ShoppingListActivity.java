package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        TextView shoppingListView = findViewById(R.id.shoppingListView);
        shoppingListView.setText(getIntent().getExtras().getString("MISSING"));
    }

    public void shoppingListToMain (View view){
        Intent toMain = new Intent (this, MainActivity.class);

        startActivity(toMain);
    }


}
