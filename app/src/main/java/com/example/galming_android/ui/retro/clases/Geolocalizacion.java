package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geolocalizacion {
    @SerializedName("usuario")
    private int usuario;
    @SerializedName("geoLat")
    private float geoLat;
    @SerializedName("geoLon")
    private float geoLon;

    public Geolocalizacion(int usuario, float geoLat, float geoLon) {
        this.usuario = usuario;

        this.geoLat = geoLat;
        this.geoLon = geoLon;
    }
    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public float getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(float geoLat) {
        this.geoLat = geoLat;
    }

    public float getGeoLon() {
        return geoLon;
    }

    public void setGeoLon(float geoLon) {
        this.geoLon = geoLon;
    }
}
