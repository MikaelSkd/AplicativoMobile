package com.mikael.aplicativos.primeiroapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class TelaEstadosActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] estados = getResources().getStringArray(R.array.estados);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, estados));
    }
}