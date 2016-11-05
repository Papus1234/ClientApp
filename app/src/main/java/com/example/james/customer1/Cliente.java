package com.example.james.customer1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Cliente extends AppCompatActivity {

    private Button ING;
    private EditText Name , IPE, PRIOR;;
    static String NOM;
    static String ip;
    static String priori;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        in = new Intent(this,Reader.class);
        ING = (Button) findViewById(R.id.ingresar);
        Name = (EditText) findViewById(R.id.Usuario);
        IPE = (EditText) findViewById(R.id.IP);
        PRIOR = (EditText) findViewById(R.id.Prioridad);


        ING.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                NOM = Name.getText().toString();
                ip = IPE.getText().toString();
                priori = PRIOR.getText().toString();


                Intent Kek = new Intent(getApplicationContext(), Reader.class);
                Kek.putExtra("NOM",NOM);
                Kek.putExtra("ip", ip);
                Kek.putExtra("priori", priori);
                startActivity(in);
            }
        });
    }


}

