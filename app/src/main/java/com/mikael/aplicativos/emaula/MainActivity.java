package com.mikael.aplicativos.emaula;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout produtoItem;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView txtTitulo;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTitulo = findViewById(R.id.toolbar_titulo);
        txtTitulo.setText(getString(R.string.app_name));

        drawerLayout = findViewById(R.id.nav_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.toogle_open, R.string.toogle_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_account:
                    Toast.makeText(MainActivity.this, "`Minha Conta", Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_cadastro_categorias:
                    intent = new Intent(MainActivity.this, RegisterCategoryActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_cadastro_itens:
                    intent = new Intent(MainActivity.this, RegisterItemsActivity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_logout:
                    intent = new Intent(MainActivity.this, UserLoginActivity.class);
                    startActivity(intent);
                    break;

                default:
                    Toast.makeText(MainActivity.this, "Erro, tente novamente!", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        produtoItem = findViewById(R.id.ll_produto_item);
        produtoItem.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,
                    ProductDetailActivity.class);
            startActivity(intent);
        });

        txtLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name);
        txtLogin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserLoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
}