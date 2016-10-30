package com.example.james.customer1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.R.attr.button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class Reader extends AppCompatActivity {
    private Button scan_btn, voicebotton;
    private Intent in;
    private TextView Kappa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        scan_btn = (Button) findViewById(R.id.scan_btn);
        final Activity activity= this;
        voicebotton = (Button) findViewById(R.id.toVoice);
        in = new Intent(this,Speech.class);
        Kappa = (TextView) findViewById(R.id.qrscan);
        scan_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View scan_btn)
            {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("SCAN");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        voicebotton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(in);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "SCAN CANCELED", Toast.LENGTH_SHORT).show();
            }
            else {
                //Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show()
                Kappa.setText(result.getContents());
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
