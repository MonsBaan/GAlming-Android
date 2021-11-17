package com.example.galming_android.ui.retro.clases;

import java.util.Date;

public class Servicio {
    private int servId;
    private Date servFecha;
    private Date servFechaDev;
    private String servDescripcion;
    private float servPrecioCompra;
    private float servDescCompra;
    private Usuario servUsuario;
    private TipoServicio servTipo;
    private Productos servProducto;

    public int getServId() {
        return servId;
    }

    public Date getServFecha() {
        return servFecha;
    }

    public Date getServFechaDev() {
        return servFechaDev;
    }

    public String getServDescripcion() {
        return servDescripcion;
    }

    public float getServPrecioCompra() {
        return servPrecioCompra;
    }

    public float getServDescCompra() {
        return servDescCompra;
    }

    public Usuario getServUsuario() {
        return servUsuario;
    }

    public TipoServicio getServTipo() {
        return servTipo;
    }

    public Productos getServProducto() {
        return servProducto;
    }
}
