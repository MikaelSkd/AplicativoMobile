package com.mikael.aplicativos.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        /*String nome = intent.getStringExtra("nome");
        int idade = intent.getIntExtra("idade", -1);

        String msg = String.format("Nome: %s\n Idade: %d", nome, idade);
        */

        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        String msg = String.format("Welcome %s!", pessoa.getNome(), pessoa.getSenha());

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d("ciclo", getClassName() + ".onCreate() chamado");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo", getClassName() + ".onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo", getClassName() + "onResume() chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo", getClassName() + "onPause() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo", getClassName() + "onStop() chamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ciclo", getClassName() + "onRestart() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclo", getClassName() + "onDestroy() chamado");
    }

    private String getClassName() {
        String nomeClass = getClass().getName();
        return nomeClass.substring(nomeClass.lastIndexOf("."));
    }
}