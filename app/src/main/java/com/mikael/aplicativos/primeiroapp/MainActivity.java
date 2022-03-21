package com.mikael.aplicativos.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onClickBtnEnviar(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);

       /* intent.putExtra("nome", "Ana Maria");
        intent.putExtra("idade", 25);*/

//        Pessoa pessoa2 = new Pessoa();

        TextView txtNome = findViewById(R.id.editText);
        TextView txtIdade = findViewById(R.id.editText2);

        String nome = txtNome.getText().toString();
        String senha = txtIdade.getText().toString();

        Pessoa pessoa = new Pessoa(nome, senha);
        intent.putExtra("pessoa", pessoa);
        startActivity(intent);
    }
}