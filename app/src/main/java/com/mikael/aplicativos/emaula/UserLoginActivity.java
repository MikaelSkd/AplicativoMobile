package com.mikael.aplicativos.emaula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class UserLoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        textView = findViewById(R.id.toolbar_titulo);
        textView.setText(R.string.usuario_login_titulo);

        btnCadastrar = findViewById(R.id.btn_login_cadastrar);
        btnCadastrar.setOnClickListener(view -> {
            Intent intent = new Intent(UserLoginActivity.this, RegisterUserActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}