package com.example.galming_android.ui.retro.clases;

import android.os.Parcelable;


import java.io.Serializable;

public class OperacionProducto implements Serializable {
    private int opProdId;
    private int opProdPrecio;
    private int opProdDescuento;
    private int opProdStock;
    private Productos opProdProductos;
    private Operacion opProdOperacion;
    public int getOpProdId() {
        return opProdId;
    }

    public int getOpProdPrecio() {
        return opProdPrecio;
    }

    public int getOpProdDescuento() {
        return opProdDescuento;
    }

    public int getOpProdStock() {
        return opProdStock;
    }

    public Productos getOpProdProductos() {
        return opProdProductos;
    }

    public Operacion getOpProdOperacion() {
        return opProdOperacion;
    }
}
