package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {

    private Context mcontext;
    private Button mIniciar;
    private EditText mcontraseña;
    private EditText musuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mcontext = this;

        musuario = (EditText) findViewById(R.id.username);
        mcontraseña = (EditText) findViewById(R.id.contrasena);
        mIniciar = (Button) findViewById(R.id.iniciar);

        mIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = musuario.getText().toString();
                String pass = mcontraseña.getText().toString();

                if(nombre.isEmpty()){
                    Toast.makeText(mcontext, "Debe introducir el usuario", Toast.LENGTH_SHORT).show();
                }

                if(pass.isEmpty()){
                    Toast.makeText(mcontext, "Debe introducir la contraseña", Toast.LENGTH_SHORT).show();
                }

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mcontext);
               // String usuarioG = preferences.getString()

                if(nombre.length()!=0 && pass.length()!=0){
                    Intent intent = getIntent();
                    Intent ingresar = new Intent(mcontext, MainActivity.class);
                    ingresar.putExtra("usuario", nombre);
                    ingresar.putExtra("password", pass);
                    setResult(RESULT_OK,intent);
                    startActivity(ingresar);
                }
            }
        });
    }


    public void registrar(View view){
        mIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registrar);
            }
        });
    }

}
