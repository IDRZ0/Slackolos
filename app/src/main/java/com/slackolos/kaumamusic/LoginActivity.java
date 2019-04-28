package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {
    private static final String LOG = LoginActivity.class.getName();

    private Context mcontext;
    private Button mregistrar;
    private EditText mcontraseña;
    private EditText musuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mcontext = this;

        musuario = (EditText) findViewById(R.id.username);
        mcontraseña = (EditText) findViewById(R.id.contrasena);
        mregistrar = (Button) findViewById(R.id.register);

    }

    public void iniciar(View view){
        String nombre = musuario.getText().toString();
        String pass = mcontraseña.getText().toString();

        if(nombre.length()==0){
            Toast.makeText(mcontext, "Debe introducir el usuario", Toast.LENGTH_SHORT).show();
        }
        if(pass.length()==0){
            Toast.makeText(mcontext, "Debe introducir la contraseña", Toast.LENGTH_SHORT).show();
        }
        if(nombre.length()!=0&&pass.length()!=0){
            Intent intent = getIntent();
            Intent ingresar = new Intent(LoginActivity.this,MainActivity.class);
            ingresar.putExtra("usuario", nombre);
            ingresar.putExtra("password", pass);
            setResult(RESULT_OK,intent);
            startActivity(ingresar);
        }
    }

    public void registrar(View view){
        mregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registrar);
            }
        });
    }

}
