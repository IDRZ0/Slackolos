package com.slackolos.kaumamusic;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.database.BaseHelper;

import static com.slackolos.kaumamusic.constantes.Constantes.PREFERENCE_ESTADO_BUTTON_SESION;
import static com.slackolos.kaumamusic.constantes.Constantes.STRING_PREFERENCES;

public class LoginActivity extends AppCompatActivity  {

    private Context mcontext;
    private Button mIniciar;
    private EditText mcontraseña;
    private EditText musuario;
    private VideoView mvideo;
    private RadioButton mradiobutton;

    private boolean isActivateRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mcontext = this;

        if(obtenerEstadoButton()){
            Intent intent = new Intent(mcontext, MainActivity.class);
            startActivity(intent);
            finish();
        }

        musuario = (EditText) findViewById(R.id.username);
        mcontraseña = (EditText) findViewById(R.id.contrasena);
        mIniciar = (Button) findViewById(R.id.iniciar);
        mvideo = (VideoView) findViewById(R.id.video);
        mradiobutton = (RadioButton) findViewById(R.id.radioButton);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.video_login;
        mvideo.setVideoURI(Uri.parse(path));
        mvideo.start();

        mIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = musuario.getText().toString();
                String pass = mcontraseña.getText().toString();

                if(usuarioValido(nombre,pass)){
                    Intent intent = new Intent(mcontext, MainActivity.class);
                    intent.putExtra(Constantes.USUARIO, nombre);
                    intent.putExtra(Constantes.PASSWORD, pass);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(mcontext, "ERROR: NOMBRE O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                }
            }
        });


        isActivateRadioButton = mradiobutton.isChecked();

        mradiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isActivateRadioButton){
                    mradiobutton.setChecked(false);
                }
                isActivateRadioButton = mradiobutton.isChecked();
            }
        });
    }

    public static void  chageEstadoButton(Context c,boolean b){
        SharedPreferences preferences = c.getSharedPreferences(STRING_PREFERENCES,MODE_PRIVATE);
        preferences.edit().putBoolean(PREFERENCE_ESTADO_BUTTON_SESION,b).apply();
    }

    public void guardarEstadoButton(){
        SharedPreferences preferences = getSharedPreferences(STRING_PREFERENCES,MODE_PRIVATE);
        preferences.edit().putBoolean(PREFERENCE_ESTADO_BUTTON_SESION,mradiobutton.isChecked()).apply();
    }

    public boolean obtenerEstadoButton(){
        SharedPreferences preferences = getSharedPreferences(STRING_PREFERENCES,MODE_PRIVATE);
        return preferences.getBoolean(PREFERENCE_ESTADO_BUTTON_SESION,false);
    }


    public void registrar(View view){
      Intent intent = new Intent(mcontext, RegisterActivity.class);
      startActivityForResult(intent, Constantes.REGISTRO);
    }


    private boolean usuarioValido(String usuario, String password) {
        if(usuario.isEmpty()){
            Toast.makeText(mcontext, "DEBE INTRODUCIR EL NOMBRE", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.isEmpty()){
            Toast.makeText(mcontext, "DEBE INTRODUCIR LA CONTRASEÑA", Toast.LENGTH_SHORT).show();
            return false;
        }

       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mcontext);
        String usuarioG = preferences.getString(Constantes.P_USUARIO,"");
        String passG = preferences.getString(Constantes.P_PASSWORD,"");
        return usuario.equals(usuarioG) && password.equals(passG); */

       guardarEstadoButton();

        BaseHelper baseHelper = new BaseHelper(this.mcontext);
        return baseHelper.login(usuario,password);
    }

}
