package com.example.quiz_mobile;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MahasiswaViewModel mahasiswaViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nim = findViewById(R.id.etNim);
        EditText nama = findViewById(R.id.etNama);
        TextView hasil = findViewById(R.id.tvResult);
        TextView hasil2 = findViewById(R.id.tvNim);
        Button insert = findViewById(R.id.btnInsert);

        mahasiswaViewModel = new ViewModelProvider(this).get(MahasiswaViewModel.class);
        mahasiswaViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hasil.setText(s);
            }
        });
        mahasiswaViewModel.getNim().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hasil2.setText(s);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswaViewModel.getName().setValue(nama.getText().toString());
                mahasiswaViewModel.getNim().setValue(nim.getText().toString());
            }
        });

    }


}