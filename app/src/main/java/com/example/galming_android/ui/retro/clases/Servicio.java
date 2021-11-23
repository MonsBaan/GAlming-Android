package com.example.galming_android.ui.retro.clases;

import java.io.Serializable;
import java.util.Date;

public class Servicio implements Serializable {
    private int servId;
    private String servFecha;
    private String servFechaDev;
    private String servDescripcion;
    private float servPrecioCompra;
    private float servDescCompra;
    private Usuario servUsuario;
    private TipoServicio servTipo;
    private Productos servProducto;

    public int getServId() {
        return servId;
    }

    public String getServFecha() {
        return servFecha;
    }

    public String getServFechaDev() {
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
