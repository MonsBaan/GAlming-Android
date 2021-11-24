package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

public class MensajeSend {
    @SerializedName("mensaje")
    private String mensaje;
    @SerializedName("servicio")
    private int servicioID;

    public MensajeSend(String mensaje, int servicioID) {
        this.mensaje = mensaje;
        this.servicioID = servicioID;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getServicioID() {
        return servicioID;
    }

    public void setServicioID(int servicioID) {
        this.servicioID = servicioID;
    }
}

