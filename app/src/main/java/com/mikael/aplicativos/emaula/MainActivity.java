package com.mikael.aplicativos.emaula;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout produtoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtoItem = findViewById(R.id.ll_produto_item);
        produtoItem.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            startActivity(intent);
        });
    }
}