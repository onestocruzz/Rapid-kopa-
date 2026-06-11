package com.rapidkopainc.rapidkopa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProductsScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        setTitle("Boost Pesa Phones And Products");
        List<Phones> phonesList = new ArrayList<>();
        //phonesList.add(new Phones("ABOUT Boost Pesa"));
        phonesList.add(new Phones("Boost Pesa SAMSUNG PHONES"));
        phonesList.add(new Phones("SAMSUNG A3 CORE"));
        phonesList.add(new Phones("SAMSUNG A03S"));
        phonesList.add(new Phones("SAMSUNG A03"));
        phonesList.add(new Phones("SAMSUNG A12"));
        phonesList.add(new Phones("SAMSUNG A22"));
        phonesList.add(new Phones("SAMSUNG A13"));
        phonesList.add(new Phones("SAMSUNG A23"));
        phonesList.add(new Phones("NOKIA C01 PLUS"));
        phonesList.add(new Phones("NOKIA 1.4"));
        phonesList.add(new Phones("NOKIA G20"));
        phonesList.add(new Phones("NOKIA G10"));
        phonesList.add(new Phones("NOKIA G21"));
        phonesList.add(new Phones("NOKIA G50"));
        phonesList.add(new Phones("NOKIA C21"));
        phonesList.add(new Phones("NOKIA C21 PLUS"));
        phonesList.add(new Phones("NOKIA C30"));
        phonesList.add(new Phones("HOW TO GET THE PHONES"));
        phonesList.add(new Phones("Boost Pesa MK 6000 (40W SOLAR PANEL \n 5 LIGHTS, 32 INCH TV, TORCH AND \n RADIO)"));
        phonesList.add(new Phones("Boost Pesa SOLAR FRIDGE  + 32-INCH TV \n (100 LITRES, 24-HOUR SERVICE)"));
      //  phonesList.add(new Phones("MKOPO HOSPICASH"));
       // phonesList.add(new Phones("MKOPO MOBILE LOANS"));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new PhonesAdapter(phonesList, this));


    }
}