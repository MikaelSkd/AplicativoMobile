package com.mikael.aplicativos.primeiroapp;


import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends ListActivity {

    private static final int MY_PERMISSIONS_REQUES_CALL_PHONE = 1;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.acoes));
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Uri uri = null;
        switch (position){
            case 0:
                uri = Uri.parse("http://www.ifsp.edu.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intent);
                break;
            case 1: //discar um numero de telefone
                uri = Uri.parse("tel:(16)99600-9833");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                dispararIntent(intent);
                break;
            case 2: //realizar uma chamada telefonica
                uri = Uri.parse("tel:+55(16)99600-9833");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                dispararIntent(intent);
                break;
            case 3:// Mapa
                uri = Uri.parse("geo:0,0");
                intent = new Intent(Intent.ACTION_VIEW,  uri);
                dispararIntent(intent);
                break;
            case 4: //Visualizar a Lista de contatos
                uri = Uri.parse("content://com.android.contacts/contacts/");
                intent =new Intent( Intent.ACTION_PICK, uri);
                dispararIntent(intent);
                break;
            case 5: //Editar um sms
                uri = Uri.parse("sms:12345");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("sms_body", "Corpo do SMS");
                dispararIntent(intent);
                break;
            case 6: // compartilhar um conteudo
                intent = new Intent().setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, "Compartilhamento via Internet")
                        .setType("text/plain");
                dispararIntent(intent);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSIONS_REQUES_CALL_PHONE:
                if (grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    dispararIntent(intent);
                }else
                    Toast.makeText(this, R.string.nao_permitido, Toast.LENGTH_SHORT).show();
        }
    }

    private void solicitarPermissao(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUES_CALL_PHONE);
        }else {
            dispararIntent(intent);
        }
    }

    private void dispararIntent(Intent intent) {

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.nao_permitido, Toast.LENGTH_SHORT).show();
        }
    }
}