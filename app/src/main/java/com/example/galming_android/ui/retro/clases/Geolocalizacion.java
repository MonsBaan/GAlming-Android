package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geolocalizacion {
    @SerializedName("usuario")
    private int usuario;
    @SerializedName("geoFecha")
    private String geoFecha;
    @SerializedName("geoLat")
    private float geoLat;
    @SerializedName("geoLon")
    private float geoLon;

    public Geolocalizacion(int usuario, String geoFecha, float geoLat, float geoLon) {
        this.usuario = usuario;
        this.geoFecha = geoFecha;
        this.geoLat = geoLat;
        this.geoLon = geoLon;
    }
    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getGeoFecha() {
        return geoFecha;
    }

    public void setGeoFecha(String geoFecha) {
        this.geoFecha = geoFecha;
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
