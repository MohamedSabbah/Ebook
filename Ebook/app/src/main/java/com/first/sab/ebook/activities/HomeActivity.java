package com.first.sab.ebook.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.first.sab.ebook.adapters.CustomArrayAdapter;
import com.first.sab.ebook.modeles.ModelView;
import com.first.sab.ebook.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    GridView view;
    ArrayList<ModelView>modelViewArrayList;
    CustomArrayAdapter customArrayAdapter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        view = findViewById(R.id.viewlis);

        modelViewArrayList = new ArrayList<>();

        ModelView modelView = new ModelView();
        modelView.setImgModel(R.drawable.add);
        modelView.setTxtModel("add Book");

        ModelView modelView2 = new ModelView();
        modelView2.setImgModel(R.drawable.allbook);
        modelView2.setTxtModel("Show all Books");

        ModelView modelView3 = new ModelView();
        modelView3.setImgModel(R.drawable.delete);
        modelView3.setTxtModel("delete Book");

        ModelView modelView4 = new ModelView();
        modelView4.setImgModel(R.drawable.fovirate);
        modelView4.setTxtModel("Favorite Book");

        modelViewArrayList.add(modelView);
        modelViewArrayList.add(modelView2);
        modelViewArrayList.add(modelView3);
        modelViewArrayList.add(modelView4);

        customArrayAdapter = new CustomArrayAdapter(HomeActivity.this , modelViewArrayList);
        view.setAdapter(customArrayAdapter);



        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(HomeActivity.this ,DetailsActivity.class);
                intent.putExtra("position", i);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home,menu);

        return super.onCreateOptionsMenu(menu);



    }

    // Menu items select

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile_item:
                Intent intent = new Intent(HomeActivity.this , ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.Setting_item:
                Intent intent1 = new Intent(HomeActivity.this , CreateActivity.class);
                startActivity(intent1);
                break;
            case R.id.logout_item:

                Intent in = new Intent(HomeActivity.this , LoginActivity.class);
                startActivity(in);
                /*editor.clear();
                editor.apply();
*/
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
