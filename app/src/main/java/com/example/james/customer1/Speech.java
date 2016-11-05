package com.example.james.customer1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.james.customer1.Conexion.Conexion;
import com.example.james.customer1.Resou.Platillo;
import com.example.james.customer1.Resou.Receta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Speech extends AppCompatActivity {
        private TextView resultBOX;
        String NOM;
        String ip;
        int priori;
        int Mesa;
        Conexion conect = new Conexion();
        ArrayList<Integer> Meme2 = new ArrayList<>();
        static int PAGAR;
        private Intent Pag;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_speech);
            Pag = new Intent(this,Pagos.class);

            //from past activity
            Bundle extras = getIntent().getExtras();
            if (extras != null)
            {
                NOM = extras.getString("NOM");
                ip = extras.getString("ip");
                priori = extras.getInt("priori");
                Mesa= extras.getInt("Mesa");

            }
            conect.conect(Cliente.ip, "8080", "Platillos");






            resultBOX =(TextView) findViewById(R.id.TVResult);


        }

        //Aqui se genera el Menu en la pantalla
        private void populateList( ArrayList<String> meme)
        {
            //Hacer lista de strings


            //Constructor de items a popular en ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.menu_create, meme);


            //configurar el ListView para utilizar los items creados con el contructor
            ListView list = (ListView) findViewById(R.id.MENU);
            list.setAdapter(adapter);

        }


        public void onButtonClick(View portal) throws JSONException, IOException{
            if (portal.getId() == R.id.VOICE) {

                promptSpeechinput();

            }
            if (portal.getId() == R.id.Test)
            {
                List <Platillo> PLAT = new ArrayList<Platillo>();
                PLAT = FixIt(conect.get("Platillos"));
                ArrayList<String> Meme = new ArrayList<>();

                for (int l=0; l < PLAT.size(); l++)
                {
                    String NOMB = PLAT.get(l).getNombre();
                    int PRECIO = PLAT.get(l).getPrecio();
                    Meme.add(l, NOMB);
                    Meme2.add(l,PRECIO);
                }
                populateList(Meme);
                RegisterClick();

            }
            if (portal.getId()== R.id.PAGAR)
            {
                startActivity(Pag);
            }

        }

    private void RegisterClick() {
        ListView list = (ListView) findViewById(R.id.MENU);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewCLicked, int position, long id)
            {
                TextView textView = (TextView) viewCLicked;
                String message = "selection :"+ position +" platillo"+ textView.getText().toString();
                Toast.makeText(Speech.this, message, Toast.LENGTH_SHORT).show();
                PAGAR = Meme2.get(position);

                JSONObject a=new JSONObject();
                try {
                    a.put("nombrePlatillo",textView.getText().toString());
                    a.put("clienteNombre",Cliente.NOM);
                    a.put("priori",Cliente.priori);
                    a.put("Mesa", Reader.Mesa);
                conect.conect(Cliente.ip,"8080","HacerOrden");
                conect.post(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public List<Platillo> FixIt (String pls) throws JSONException,IOException{
            JSONArray jsonarray = new JSONArray(pls);
            List<Platillo>platillo=new ArrayList<>();
            ArrayList<String> MenuO = new ArrayList<>();

            for (int i = 0; i < jsonarray.length(); i++) {
                Platillo aux = new Platillo();
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String nutri = jsonobject.getString("informacion_nutricional");

                System.err.println(nutri);

                aux.setInformacion_nutricional(nutri);
                String nombre = jsonobject.getString("nombre");

                System.err.println(nombre);
                MenuO.add(nombre);

                aux.setNombre(nombre);
                int precio = jsonobject.getInt("precio");

                System.err.println(precio);

                aux.setPrecio(precio);

                JSONObject receta = jsonobject.getJSONObject("receta");

                String recet = receta.getString("textoPasos");

                aux.setReceta(new Receta(recet));

                System.err.println(aux.getReceta().getPasos());

                int time = jsonobject.getInt("tiempo_de_preparacion");
                aux.setTiempo_de_preparacion(time);


                System.err.println(aux.getTiempo_de_preparacion());
                System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                platillo.add(i, aux);

            }
            System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            return platillo;



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