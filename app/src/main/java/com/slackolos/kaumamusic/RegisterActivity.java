package com.slackolos.kaumamusic;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.usuario.Usuario;

public class RegisterActivity extends AppCompatActivity {

    private Context mContext;

    private LinearLayout parent;

    private TextView tUser;
    private EditText user;

    private TextView tPass;
    private EditText pass;

    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;

        parent = new LinearLayout(mContext);
        parent.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        parent.setOrientation(LinearLayout.VERTICAL);

        tUser = new TextView(mContext);
        tUser.setText("Nombre de Usuario");
        tUser.setTextSize(22);
        parent.addView(tUser);

        user = new EditText(mContext);
        parent.addView(user);

        tPass = new TextView(mContext);
        tPass.setText("Contraseña");
        tPass.setTextSize(22);
        parent.addView(tPass);

        pass = new EditText(mContext);
        parent.addView(pass);

        registrar = new Button(mContext);
        registrar.setText("Registrar");
        registrar.setTextSize(22);
        registrar.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        parent.addView(registrar);

        setContentView(parent);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().isEmpty()){
                    LayoutInflater inflater = getLayoutInflater();
                    View layouttoast = inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.viewToast));
                }

                if(pass.getText().toString().isEmpty()){
                    LayoutInflater inflater = getLayoutInflater();
                    View layouttoast = inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.viewToast));
                }

                final Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.pass_confir_layout);

                Usuario usuario1 = new Usuario();
                usuario1.setNombre(user.getText().toString());
                usuario1.setPassword(pass.getText().toString());

                String json = new Gson().toJson(usuario1);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Constantes.P_USUARIO, user.getText().toString());
                editor.putString(Constantes.P_PASSWORD,pass.getText().toString());
                editor.apply();

                Intent intent = new Intent();
                intent.putExtra(Constantes.REGISTRAR, json);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}
