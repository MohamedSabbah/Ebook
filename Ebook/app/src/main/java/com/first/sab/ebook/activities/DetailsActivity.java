package com.first.sab.ebook.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.first.sab.ebook.R;
import com.first.sab.ebook.adapters.CustomArrayAdapter;
import com.first.sab.ebook.adapters.DetailCustomAdapter;
import com.first.sab.ebook.dataBase.Sqlite;
import com.first.sab.ebook.modeles.ModelDetails;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ListView addList,deleteList, showList,fevoratelist;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        addList = findViewById(R.id.view_Add_details);
        deleteList = findViewById(R.id.view_delete_details);
        showList = findViewById(R.id.view_showAll_details);
        fevoratelist = findViewById(R.id.view_fovirate_details);
        button = findViewById(R.id.btn_next_details);
        editText =findViewById(R.id.txt_Details);


        final int position  = getIntent().getIntExtra("position",10);

        Toast.makeText(DetailsActivity.this, "the position is " + position,Toast.LENGTH_LONG).show();


            final ArrayList<ModelDetails>modelDetailsArrayList;
            final DetailCustomAdapter customArrayAdapter;

        switch (position){
            case 0:
                showList.setVisibility(View.GONE);
                deleteList.setVisibility(View.GONE);
                fevoratelist.setVisibility(View.GONE);

                modelDetailsArrayList = new ArrayList<>();
                customArrayAdapter = new DetailCustomAdapter(DetailsActivity.this, modelDetailsArrayList);
                addList.setAdapter(customArrayAdapter);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ModelDetails details = new ModelDetails();
                        details.setImg(R.drawable.add);
                         details.setTxt1(editText.getText().toString());
                         details.setTxt2(editText.getText().toString());
                         modelDetailsArrayList.add(details);
                         customArrayAdapter.notifyDataSetChanged();

                        Sqlite sqlite = new Sqlite(DetailsActivity.this);
                        sqlite.addData(editText.getText().toString(),editText.getText().toString());

                    }
                });

                break;
            case 1:
                deleteList.setVisibility(View.GONE);
                fevoratelist.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                addList.setVisibility(View.GONE);



                Sqlite sqlite = new Sqlite(DetailsActivity.this);
                modelDetailsArrayList = sqlite.retriveData();

                customArrayAdapter = new DetailCustomAdapter(DetailsActivity.this, modelDetailsArrayList);
                showList.setAdapter(customArrayAdapter);




                break;
            case 2:
                showList.setVisibility(View.GONE);
                fevoratelist.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                addList.setVisibility(View.GONE);



                final Sqlite sqlite1 = new Sqlite(DetailsActivity.this);
                modelDetailsArrayList = sqlite1.retriveData();

                customArrayAdapter = new DetailCustomAdapter(DetailsActivity.this, modelDetailsArrayList);
                deleteList.setAdapter(customArrayAdapter);
                deleteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                        sqlite1.deleteOneBook( modelDetailsArrayList.get(i).getId());


                        modelDetailsArrayList.remove(i);
                        customArrayAdapter.notifyDataSetChanged();

                    }
                });

                break;

            case 3:
                deleteList.setVisibility(View.GONE);
                showList.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                addList.setVisibility(View.GONE);


                ModelDetails details4 = new ModelDetails();
                details4.setImg(R.drawable.delete);
                details4.setTxt1("Book1");
                details4.setTxt2("Author1");

                ModelDetails details5 = new ModelDetails();
                details5.setImg(R.drawable.delete);
                details5.setTxt1("Book2");
                details5.setTxt2("Author2");

                modelDetailsArrayList = new ArrayList<>();
                modelDetailsArrayList.add(details4);
                modelDetailsArrayList.add(details5);
                customArrayAdapter = new DetailCustomAdapter(DetailsActivity.this, modelDetailsArrayList);
                fevoratelist.setAdapter(customArrayAdapter);
                break;

        }

    }
}
