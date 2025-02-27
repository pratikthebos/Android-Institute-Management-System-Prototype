package com.sunbeam.day81.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.sunbeam.day81.R;

public class activity_login extends AppCompatActivity {

    EditText editEmail,editPassword;
    CheckBox checkBox;
    TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        checkBox = findViewById(R.id.checkBox);
        textRegister = findViewById(R.id.textRegister);
       textRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    public void login(View view) {
        Log.e("Login Activity","Login Activity");
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}