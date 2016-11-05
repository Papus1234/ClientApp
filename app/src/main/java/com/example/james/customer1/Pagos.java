package com.example.james.customer1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.james.customer1.Conexion.Conexion;

import org.json.JSONException;

import java.io.IOException;

public class Pagos extends AppCompatActivity {
    private Button coment;
    private Button Fin;
    private TextView Keepo;
    String Coment;
    Conexion conect;
    int Pago;
    private EditText COM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);


        coment = (Button) findViewById(R.id.COMENTAR);
        Fin = (Button) findViewById(R.id.FINALIZAR);

        Keepo= (TextView) findViewById(R.id.PAGO);
        String EL= Speech.PAGAR +"";
        Keepo.setText(EL);

        COM = (EditText) findViewById(R.id.COM);

    }
    public void onButtonClick(View portal) throws JSONException,IOException{
        if (portal.getId() == R.id.COMENTAR){
            //Coment = COM.getText().toString();
            //JSONObject obj =new JSONObject();
            //obj.put("Coment", Coment);
            //conect.conect(Cliente.ip, "8080","Comentario" );
           // conect.post(obj);
            Toast.makeText(this, "Su comentario ha sido registrado", Toast.LENGTH_LONG).show();
        }
        if (portal.getId() == R.id.FINALIZAR)
        {
            //Pago = Speech.PAGAR;
            //JSONObject b = new JSONObject();
            //try {
                //b.put("pago", Pago);

                //conect.conect(Cliente.ip, "8080", "Pagar");
              //  conect.post(b);
            //}catch (JSONException e) {
              //  e.printStackTrace();
            //} catch (IOException e) {
              //  e.printStackTrace();
            //}
            Toast.makeText(Pagos.this, "SU pago ha sido efectuado", Toast.LENGTH_LONG).show();
        }
    }

}
