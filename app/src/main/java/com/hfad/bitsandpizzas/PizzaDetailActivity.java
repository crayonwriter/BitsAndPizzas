package com.hfad.bitsandpizzas;

import android.drm.DrmStore;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

public class PizzaDetailActivity extends AppCompatActivity {

    //Constant to pass ID of pizza as extra information in the intent
    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        //Use the pizza ID to populate the TextView and ImageView
        int pizzaId = (Integer)getIntent().getExtras().get(EXTRA_PIZZA_ID);
        String pizzaName = Pizza.pizzas[pizzaId].getName();
        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
        int pizzaImage = Pizza.pizzas[pizzaId].getImageResourceId();
        ImageView imageView = findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage));
        imageView.setContentDescription(pizzaName);
    }
}
