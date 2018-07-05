package com.first.sab.ebook.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.first.sab.ebook.R;

public class ProfileActivity extends AppCompatActivity {
    EditText textFromEmail, textFromPassword;
    Button buttonMain, buttonSave;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textFromEmail = findViewById(R.id.profile_nametxt);
        textFromPassword = findViewById(R.id.profile_passtxt);
        buttonMain = findViewById(R.id.mainbtn);
        buttonSave = findViewById(R.id.btnsave);
        textFromEmail.setEnabled(false);
        textFromPassword.setEnabled(false);

        // login shared preference
        preferences = getSharedPreferences("pref_file", MODE_PRIVATE);
        textFromEmail.setText(preferences.getString("email", "no email"));
        textFromPassword.setText(preferences.getString("password", "no password"));

        // create activity
      /*  textFromEmail.setText(getIntent().getStringExtra("Email"));
        textFromPassword.setText(getIntent().getStringExtra("password"));
*/


        editor = preferences.edit();


        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            boolean b = false;
            @Override
            public void onClick(View view) {
                if(buttonSave.getText().toString().equals("Edit")){
                    textFromEmail.setEnabled(true);
                    textFromPassword.setEnabled(true);
                    buttonSave.setText("Save");
                    b = true;
                }else {
                    textFromEmail.setEnabled(false);
                    textFromPassword.setEnabled(false);
                    editor.putString("email", textFromEmail.getText().toString());
                    editor.putString("password" , textFromPassword.getText().toString());
                    editor.apply();
                    editor.commit();
                    b = false;
                    buttonSave.setText("Edit");

                }

            }
        });

    }
}
