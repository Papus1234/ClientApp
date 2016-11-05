package com.example.james.customer1.Conexion;

import android.content.Context;
import android.os.StrictMode;

import com.example.james.customer1.Resou.Platillo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Conexion
{
    public Context context;
    String URL;
    public HttpClient httpclient = new DefaultHttpClient();
    public  String ip, port, path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        URL = "http://"+ip+":"+port+"/ProyectoServer/webapi/Cliente/"+path;
    }

    public Conexion(){
    }
    public void conect(String ip, String port,String path) {
        this.ip=ip;
        this.port=port;
        this.path=path;
        URL = "http://"+ip+":"+port+"/ProyectoServer/webapi/Cliente/"+path;
        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(p);
        StrictMode.enableDefaults();
//      HttpPost httppost=new HttpPost(URL);
//      httppost.setHeader("Content-Type","application/json");
//      JSONArray cheffs = new JSONArray(result)
//      HttpEntity entityy=new StringEntity(cheff.toString());
//      httppost.setEntity(entityy);
    }
    public void setContext(Context context){
        this.context=context;
    }
    public void postPlatillo(Platillo platillo) throws JSONException, IOException {
        JSONObject JO = new JSONObject();
        JO.put("nombre",platillo.getNombre());
        JO.put("informacion_nutricional",platillo.getInformacion_nutricional());
        JO.put("receta",platillo.getReceta().getPasos());
        JO.put("ingredientes",platillo.getIngredientes());
        post(JO);
    }
    public void post(JSONObject JSONobject) throws JSONException, IOException
    {
//      HttpEntity entityy=new StringEntity(cheff.toString());
//      httppost.setEntity(entityy);
        HttpPost request = new HttpPost(URL);
        request.addHeader("content-type", "application/json");
        StringEntity params = new StringEntity(JSONobject.toString());
        request.setEntity(params);
        httpclient.execute(request);

        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();

        String responseText = EntityUtils.toString(entity);
        CharSequence text1 = responseText;
        }

    public String get(String path)throws JSONException, IOException
    {
        setPath(path);
        HttpGet request=new HttpGet(URL);
        httpclient.execute(request);

        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();

        String responseText = EntityUtils.toString(entity);
        CharSequence text1 = responseText;
        text1.toString();
        return (String) text1;
    }
}