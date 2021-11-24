package com.example.galming_android.ui.retro.clases;

import com.google.gson.annotations.SerializedName;

public class StockChange {

    @SerializedName("producto")
    private String productoID;
    @SerializedName("stock")
    private String stock;

    public StockChange(String productoID) {
        this.productoID = productoID;
        stock = "";
    }

}
