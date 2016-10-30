package com.example.james.customer1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Speech extends AppCompatActivity {
        private TextView resultBOX;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_speech);
            resultBOX =(TextView) findViewById(R.id.TVResult);
        }

        public void onButtonClick(View portal) {
            if (portal.getId() == R.id.VOICE) {

                promptSpeechinput();
            }

        }

        public void promptSpeechinput() {
            Intent Val = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            Val.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            Val.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            Val.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hable porfavor!");
            try {
                startActivityForResult(Val, 100);
            } catch (ActivityNotFoundException a) {
                Toast.makeText(com.example.james.customer1.Speech.this, "Device Not Compatible", Toast.LENGTH_LONG).show();


            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent Val)
        {
            super.onActivityResult(requestCode, resultCode, Val);
            switch(requestCode){
                case 100: if (resultCode == RESULT_OK && Val != null)
                {
                    ArrayList<String> result = Val.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    resultBOX.setText(result.get(0));
                }
                    break;
            }
        }
    }