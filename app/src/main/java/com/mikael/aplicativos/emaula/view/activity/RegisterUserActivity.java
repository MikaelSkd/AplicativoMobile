package com.mikael.aplicativos.emaula.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.mikael.aplicativos.emaula.R;
import com.mikael.aplicativos.emaula.model.entity.UserEntity;
import com.mikael.aplicativos.emaula.view.model.UserViewModel;

public class RegisterUserActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private TextInputEditText txtName;
    private TextInputEditText txtEmail;
    private TextInputEditText txtPassword;
    private Button btnRegister;

    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        userViewModel= new ViewModelProvider(this).get(UserViewModel.class);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        textView = findViewById(R.id.toolbar_titulo);
        textView.setText(R.string.titulo_tela_cadastro);


        txtName = findViewById(R.id.txt_edit_nome);
        txtEmail = findViewById(R.id.txt_edit_email);
        txtPassword = findViewById(R.id.txt_edit_senha);

        btnRegister = findViewById(R.id.btn_usuario_cadastro);
        btnRegister.setOnClickListener(view -> {
            UserEntity user = new UserEntity(
                    txtEmail.getText().toString(),
                    txtName.getText().toString(),
                    "",
                    txtPassword.getText().toString(),
                    ""
            );

            userViewModel.createUser(user);

            userViewModel.login(user.getEmail(), user.getPassword())
                    .observe(RegisterUserActivity.this, userEntity -> {
                        finish();
                    });
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}