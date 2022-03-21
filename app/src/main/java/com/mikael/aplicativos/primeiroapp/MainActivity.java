package com.mikael.aplicativos.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSelecionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelecionar = findViewById(R.id.btn_selecionar);
        btnSelecionar.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), TelaEstadosActivity.class);
            startActivity(intent);
        });
    }
}