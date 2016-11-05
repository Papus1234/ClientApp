package com.example.james.customer1;

/**
 * Created by James on 1/11/2016.
 */

public class ClienteMake {
    String Nombre;
    String IP;
    int mesa;
    int prioridad;

    public ClienteMake(String NAME, String ip, int Prio)
    {
        prioridad = Prio;
        Nombre = NAME;
        IP = ip;

    }
    public void setMesa(int numero)
    {
        mesa = numero;
    }

}
