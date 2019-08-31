package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   {


    private TextView inputName = findViewById(R.id.etNome);
    private TextView inputTelefone = findViewById(R.id.etTelefone);
    private TextView inputEmail = findViewById(R.id.etEmail);
    private TextView inputEndereco = findViewById(R.id.etEndereco);
    private TextView enderecoRoot = findViewById(R.id.txtRoot);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_main);
            enderecoRoot = findViewById(R.id.txtRoot);
            inputName = findViewById(R.id.etNome);
            inputTelefone = findViewById(R.id.etTelefone);
            inputEmail = findViewById(R.id.etEmail);
            inputEndereco = findViewById(R.id.etEndereco);

            enderecoRoot.append(GetRoot());


        }catch (Exception e ){
            e.getMessage();
        }


    }

    private void showMenssagem(String msg){

        Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_SHORT).show();
    }

    private String GetRoot() {

        File root = android.os.Environment.getExternalStorageDirectory();
        return root.toString();
    }
    public List <String> dadoInputados(){
        String a = inputName.getText().toString();
        String b = inputTelefone.getText().toString();
        String c =inputEmail.getText().toString();
        String d =inputEndereco.getText().toString();

        List <String> lista = new ArrayList<>();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);

        return lista;
    }
    public void btnSalvar(View view){
        String arquivos = dadoInputados().get(0).toString();
        File arq;

        byte[] dados;

        try {
            FileOutputStream fos = new FileOutputStream(arquivos);
            for(String dado : dadoInputados()){
                fos.write(dado.getBytes());
            }






        }catch (Exception e){
            e.getMessage();
        }

    }



}
