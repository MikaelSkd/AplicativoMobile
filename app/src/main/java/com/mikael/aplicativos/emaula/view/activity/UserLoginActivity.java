package com.mikael.aplicativos.emaula.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.mikael.aplicativos.emaula.R;
import com.mikael.aplicativos.emaula.view.model.UserViewModel;

public class UserLoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private Button btnCadastrar;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userViewModel= new ViewModelProvider(this).get(UserViewModel.class);


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