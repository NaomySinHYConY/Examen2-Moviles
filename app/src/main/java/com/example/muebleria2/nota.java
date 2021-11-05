package com.example.muebleria2;

public class nota {
    //(sku integer, marca texto, nom texto,costo integer,  foto integer, cantidad integer, total integer)
    String sku = "";
    String marca = "";
    String nom = "";
    int costo = 0;
    int foto = 0;
    int cantidad = 0;
    int total = 0;

    public nota(String sku, String marca, String nom, int costo, int foto, int cantidad){
        this.sku = sku;
        this.marca = marca;
        this.nom = nom;
        this.costo = costo;
        this.foto = foto;
        this.cantidad = cantidad;
        this.total = costo*cantidad;
    }

    public nota(){

    }
}
