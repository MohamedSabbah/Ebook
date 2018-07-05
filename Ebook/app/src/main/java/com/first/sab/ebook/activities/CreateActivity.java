package com.first.sab.ebook.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.first.sab.ebook.R;

public class CreateActivity extends AppCompatActivity {
    Button buttoncreate;
    TextView viewHaveAccount;
    EditText textEmailCreate ,textPassCreate;
    String createEmail,createPass;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("pref_file", MODE_PRIVATE);
        if (sharedPreferences.contains("email")) {
            Intent intent = new Intent(CreateActivity.this, HomeActivity.class);

            startActivity(intent);
            finish();

        }
        setContentView(R.layout.activity_create);
        buttoncreate = findViewById(R.id.btn_create);
        viewHaveAccount = findViewById(R.id.have_account);
        textEmailCreate = findViewById(R.id.edit_email);
        textPassCreate = findViewById(R.id.edit_pass);


        viewHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttoncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEmail = textEmailCreate.getText().toString();
                createPass = textPassCreate.getText().toString();

                Intent intent = new Intent(CreateActivity.this, LoginActivity.class);
                intent.putExtra("Email",createEmail);
                intent.putExtra("password", createPass);
                startActivity(intent);
                finish();

            }
        });
    }
}
