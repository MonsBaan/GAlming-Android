package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Mensajes {
    private int Id;
    private boolean EsTrabajador;
    private String Mensaje;
    private String Fecha;


    public int getMensajesId() {
        return Id;
    }

    public boolean getEsTrabajador() {
        return EsTrabajador;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public String getFecha() {
        return Fecha;
    }
}
