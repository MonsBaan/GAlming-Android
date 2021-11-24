package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class ServicioEnvio {
    @SerializedName("fechaDevolucion")
    private String servFechaDev;
    @SerializedName("descripcion")
    private String servDescripcion;
    @SerializedName("precioCompra")
    private float servPrecioCompra;
    @SerializedName("descuentoCompra")
    private float servDescCompra;
    @SerializedName("usuario")
    private int servUsuario;
    @SerializedName("tipoServicio")
    private int servTipo;
    @SerializedName("producto")
    private int servProducto;

    public ServicioEnvio(String servFechaDev, String servDescripcion, float servPrecioCompra, float servDescCompra, int servUsuario, int servTipo, int servProducto) {
        this.servFechaDev = servFechaDev;
        this.servDescripcion = servDescripcion;
        this.servPrecioCompra = servPrecioCompra;
        this.servDescCompra = servDescCompra;
        this.servUsuario = servUsuario;
        this.servTipo = servTipo;
        this.servProducto = servProducto;
    }

    public String getServFechaDev() {
        return servFechaDev;
    }

    public void setServFechaDev(String servFechaDev) {
        this.servFechaDev = servFechaDev;
    }

    public String getServDescripcion() {
        return servDescripcion;
    }

    public void setServDescripcion(String servDescripcion) {
        this.servDescripcion = servDescripcion;
    }

    public float getServPrecioCompra() {
        return servPrecioCompra;
    }

    public void setServPrecioCompra(float servPrecioCompra) {
        this.servPrecioCompra = servPrecioCompra;
    }

    public float getServDescCompra() {
        return servDescCompra;
    }

    public void setServDescCompra(float servDescCompra) {
        this.servDescCompra = servDescCompra;
    }

    public int getServUsuario() {
        return servUsuario;
    }

    public void setServUsuario(int servUsuario) {
        this.servUsuario = servUsuario;
    }

    public int getServTipo() {
        return servTipo;
    }

    public void setServTipo(int servTipo) {
        this.servTipo = servTipo;
    }

    public int getServProducto() {
        return servProducto;
    }

    public void setServProducto(int servProducto) {
        this.servProducto = servProducto;
    }
}
