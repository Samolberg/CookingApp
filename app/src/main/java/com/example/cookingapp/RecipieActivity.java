package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecipieActivity extends AppCompatActivity {
    String missing = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie);

        ArrayList<String> selected = getIntent().getStringArrayListExtra("selected");
        try {
            JSONArray array = new JSONArray(loadJSONFromAsset(this));
            int bestRecipeIndex = 0;
            int bestRecipeMatches = 0;
            for (int i = 0; i < array.length(); i++) {
                int currentMatches = 0;
                for (int j = 0; j < array.getJSONObject(i).getJSONArray("ingredients").length(); j++) {
                    String ingredient = array.getJSONObject(i).getJSONArray("ingredients").getString(j);
                  if(selected.contains(ingredient)){
                      currentMatches++;
                  }
                }
                if(currentMatches > bestRecipeMatches){
                    bestRecipeMatches = currentMatches;
                    bestRecipeIndex = i;
                }
            }


              Log.d("retsept", "Best match "+bestRecipeIndex);
              Log.d("retsept", "Best matches "+bestRecipeMatches);

            JSONObject retsept = array.getJSONObject(bestRecipeIndex);
            //Otsin puuduolevaid asju
            missing = "";
            for (int i = 0; i < retsept.getJSONArray("ingredients").length(); i++) {
                if(!selected.contains(retsept.getJSONArray("ingredients").get(i))){
                    Log.d("retsept", "Missing ingredients: "+retsept.getJSONArray("ingredients").get(i));
                    missing += retsept.getJSONArray("ingredients").get(i) + "\n";

                }

            }

            // Otsi vaated
            ImageView recipeImage = findViewById(R.id.recipeImage);
            TextView recipeTutorial = findViewById(R.id.recipeTutorial);

            //Vaadete täitmine

          //  Log.d("shoppinglist", missing);
            recipeTutorial.setText(retsept.getString("tutorial"));
            Picasso.with(this).load(retsept.getString("image")).into(recipeImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //Nupp mis viib ostunimekirja
    public void toShoppingList (View view){
        Intent shoppingList = new Intent (this, ShoppingListActivity.class);
        shoppingList.putExtra("MISSING", missing);
        startActivity(shoppingList);
    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Recipe.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


}
