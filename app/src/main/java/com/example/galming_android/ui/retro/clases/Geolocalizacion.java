package com.example.galming_android.ui.retro.clases;

import java.util.Date;

public class Geolocalizacion {

    private int geoId;
    private Usuario usuario;
    private Date fecha;
    private float geoLat;
    private float geoLon;

    public Geolocalizacion(int geoId, Usuario usuario, Date fecha, float geoLat, float geoLon)
    {
        this.geoId = geoId;
        this.usuario = usuario;
        this.fecha = fecha;
        this.geoLat = geoLat;
        this.geoLon = geoLon;
    }

    public void setGeoId(int geoId)
    {
        this.geoId = geoId;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public void setGeoLat(float geoLat)
    {
        this.geoLat = geoLat;
    }

    public void setGeoLon(float geoLon)
    {
        this.geoLon = geoLon;
    }

    public int getGeoId() {
        return geoId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getGeoLat() {
        return geoLat;
    }

    public float getGeoLon() {
        return geoLon;
    }
}
