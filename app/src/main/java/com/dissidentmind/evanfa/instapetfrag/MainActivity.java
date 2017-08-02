package com.dissidentmind.evanfa.instapetfrag;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOfItems;
    ArrayList<Pet> arrayItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton btns = (ImageButton) findViewById(R.id.btnStar);

        //ImageButton btnS = (ImageButton) miActionBar.findViewById(R.id.btnStar);
        /**
         * App Bar Declaration
         */
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PetPerfil.class);
                final ArrayList<String> arrayFields = getFieldsValues();
                intent.putExtra("valueStr",arrayFields);
                startActivity(intent);
            }
        });

        listOfItems = (RecyclerView) findViewById(R.id.rvItems);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listOfItems.setLayoutManager(layoutManager);

        startItems();
        startAdapater();
    }

    public void startItems(){
        arrayItem = new ArrayList<Pet>();

        arrayItem.add(new Pet("Panchita", 0,R.drawable.doggy1));
        arrayItem.add(new Pet("Pedrito", 0,R.drawable.doggy2));
        arrayItem.add(new Pet("Paty", 0,R.drawable.doggy3));
        arrayItem.add(new Pet("Birolo", 0,R.drawable.doggy4));
        arrayItem.add(new Pet("Tabata", 0,R.drawable.doggy5));
        arrayItem.add(new Pet("Chihuas", 0,R.drawable.doggy6));
        arrayItem.add(new Pet("Guapo", 0,R.drawable.doggy7));
        arrayItem.add(new Pet("Sadi", 0,R.drawable.doggy8));
        arrayItem.add(new Pet("Tepino", 0,R.drawable.doggy9));
        arrayItem.add(new Pet("Poncho", 0,R.drawable.doggy10));
    }

    protected ArrayList getFieldsValues() {
        final ArrayList<String> arr = new ArrayList<String>();

        TextView txtName = (TextView) findViewById(R.id.tvName); //inN
        TextView txtCalif = (TextView) findViewById(R.id.tvCalif);

        String txtCleanName = txtName.getText().toString();
        String txtCleanCalif = txtCalif.getText().toString();

        arr.add(txtCleanName);
        arr.add(txtCleanCalif);

        return arr;
    }

    public void startAdapater(){
        ItemAdapter adAdapter = new ItemAdapter(arrayItem, this);
        listOfItems.setAdapter(adAdapter);
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btnBarContact) {
            //return true;
        }
        if(id == R.id.btnBarAbout){

        }

        return super.onOptionsItemSelected(item);
    }
}
