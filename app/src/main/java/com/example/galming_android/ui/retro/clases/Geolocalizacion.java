package com.example.galming_android.ui.retro.clases;

public class Geolocalizacion {

    private int geoId;
    private int usuario;
    private String geoFecha;
    private double geoLat;
    private double geoLon;

    public Geolocalizacion(int geoId, int geoUsuario, String geoFecha, double geoLat, double geoLon)
    {
        this.geoId = geoId;
        this.usuario = geoUsuario;
        this.geoFecha = geoFecha;
        this.geoLat = geoLat;
        this.geoLon = geoLon;
    }

    public void setGeoId(int geoId)
    {
        this.geoId = geoId;
    }

    public void setUsuario(int geoUsuario)
    {
        this.usuario = geoUsuario;
    }

    public void setFecha(String geoFecha)
    {
        this.geoFecha = geoFecha;
    }

    public void setGeoLat(double geoLat)
    {
        this.geoLat = geoLat;
    }

    public void setGeoLon(double geoLon)
    {
        this.geoLon = geoLon;
    }

    public int getGeoId() {
        return geoId;
    }

    public int getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return geoFecha;
    }

    public double getGeoLat() {
        return geoLat;
    }

    public double getGeoLon() {
        return geoLon;
    }
}
