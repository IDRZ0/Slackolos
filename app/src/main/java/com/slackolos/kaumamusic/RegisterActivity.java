package com.slackolos.kaumamusic;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        parent.setBackgroundResource(R.drawable.gra);
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
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        parent.addView(pass);

        registrar = new Button(mContext);
        registrar.setText("Registrar");
        registrar.setTextSize(22);
        registrar.setBackgroundResource(R.drawable.button_background2);
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
                    ((TextView) layouttoast.findViewById(R.id.textoWarn)).setText("INGRESE EL NOMBRE DE USUARIO");
                    Toast mensaje = new Toast(getBaseContext());
                    mensaje.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    mensaje.setView(layouttoast);
                    mensaje.setDuration(Toast.LENGTH_LONG);
                    mensaje.show();
                    return;
                }

                if(pass.getText().toString().isEmpty()){
                    LayoutInflater inflater = getLayoutInflater();
                    View layouttoast = inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.viewToast));
                    ((TextView) layouttoast.findViewById(R.id.textoWarn)).setText("INGRESE LA CONTRASEÑA");
                    Toast mensaje = new Toast(getBaseContext());
                    mensaje.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    mensaje.setView(layouttoast);
                    mensaje.setDuration(Toast.LENGTH_LONG);
                    mensaje.show();
                    return;
                }

                confirPass();

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

    private void confirPass() {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.pass_confir_layout);

        final EditText pass2 = dialog.findViewById(R.id.contrasena);
        Button confir = dialog.findViewById(R.id.botonConfir);

        confir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 = pass.getText().toString();
                String password2 = pass2.getText().toString();

                if(password1.equals(password2)) {
                    dialog.dismiss();
                } else {
                    dialog.dismiss();
                    pass2.setError("LAS CONTRASEÑAS NO COINCIDEN");
                }
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

}
