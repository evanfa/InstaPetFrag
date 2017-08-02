package com.dissidentmind.evanfa.instapetfrag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.dissidentmind.evanfa.instapetfrag.Pet;

import java.util.ArrayList;

public class PetPerfil extends AppCompatActivity {
    //private RecyclerView listItemsSecond;
    //ArrayList<Pet> arrayItemsStarsSecond;

    private Toolbar starBar;
    private ActionMenuView amvMenuView;

    private RecyclerView listItemsStar;
    ArrayList<Pet> arrayItemsStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_perfil);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            final ArrayList<String> arr = extras.getStringArrayList("valueStr");
            for(int wX = 0; wX < arr.size(); wX++){
                System.out.println(arr.get(wX));
            }
        }

        /**
         *Setting up "UP" to the main activity (Father Activity)
         * Update in Android Manifest
         */
        Toolbar miActionBar = (Toolbar) findViewById(R.id.starBar); /*Nested Bar (Second)*/
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listItemsStar = (RecyclerView) findViewById(R.id.rvItemsStars);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);*/
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listItemsStar.setLayoutManager(layoutManager);

        startItems();
        startAdapater();
    }

    public void startItems(){
        arrayItemsStars = new ArrayList<Pet>();

        arrayItemsStars.add(new Pet("Chihuas", 0,R.drawable.doggy6));
        arrayItemsStars.add(new Pet("Guapo", 0,R.drawable.doggy7));
        arrayItemsStars.add(new Pet("Sadi", 0,R.drawable.doggy8));
        arrayItemsStars.add(new Pet("Tepino", 0,R.drawable.doggy9));
        arrayItemsStars.add(new Pet("Poncho", 0,R.drawable.doggy10));
    }

    public void startAdapater(){
        ItemAdapter adAdapter = new ItemAdapter(arrayItemsStars, this);
        listItemsStar.setAdapter(adAdapter);
    }
}
