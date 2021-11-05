package com.example.muebleria2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.UserPresenceUnavailableException;
import android.widget.Toast;

import java.util.ArrayList;


public class SQL {
    SQLite conn;
    Context context;

    public SQL(Context context){
        this.context = context;
        conn = new SQLite(context, "muebleria", null, 3);
    }

    public usuario validar(String user, String pass){
        SQLiteDatabase db = conn.getWritableDatabase();

        int id = 0;
        String nom = "";
        String app= "";
        String apm= "";
        int foto= 0;
        String password= "";

        try{
            String sql = "select * from usuario where id = '"+ user +"'";
            Cursor cur = db.rawQuery(sql, null);
            while (cur.moveToNext()){
                id = cur.getInt(0);
                nom = cur.getString(1);
                app = cur.getString(2);
                apm = cur.getString(3);
                password = cur.getString(4);
                foto = cur.getInt(5);
            }
            nom = nom + " " + app + " " + apm;
            conn.close();
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
        }
        if(nom.equals("")){
            return null;
        }
        else{
            return new usuario(id, nom, foto);
        }
    }

    public int notaTotal(){
        SQLiteDatabase db = conn.getWritableDatabase();
        int total = 0;

        try{
            String sql = "select nota from nota GROUP BY nota order by nota desc limit 0,1";
            Cursor cur = db.rawQuery(sql, null);
            while (cur.moveToNext()) {
                total = cur.getInt(0);
            }
                conn.close();
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
        }
        total++;
        return total;

    }

    public nota buscarArticulo(int id, int cantidad){
        SQLiteDatabase db = conn.getWritableDatabase();
        //sku integer, marca texto, nom texto,costo integer, foto integer
        String sku = "";
        String marca = "";
        String nom = "";
        int costo = 0;
        int foto = 0;

        try {
            String sql = "select * from producto where sku = '"+ id +"'";
            Cursor cur = db.rawQuery(sql, null);
            while (cur.moveToNext()) {
                sku = cur.getString(0);
                marca = cur.getString(1);
                nom = cur.getString(2);
                costo = cur.getInt(3);
                foto = cur.getInt(4);
            }
            conn.close();

        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
        }

        return new nota(sku, marca, nom, costo, foto, cantidad);
    }

    public void insertNota(int sku, String marca, String nom, int costo, int foto, int cantidad, int total, int nota){
        SQLiteDatabase db = conn.getWritableDatabase();
        try{
            String sql = "insert into nota values ('"+ sku +"','"+ marca +"','"+ nom +"','"+ costo +"','"+ foto +"','"+ cantidad +"','"+ total +"','"+ nota +"')" ;
            db.execSQL(sql);
            conn.close();
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
        }
    }

    public ArrayList<nota> buscarNotaCompleta(int id){
        SQLiteDatabase db = conn.getWritableDatabase();
        ArrayList<nota> lista;
        lista = new ArrayList<nota>();

        String sku = "";
        String marca = "";
        String nom = "";
        int costo = 0;
        int foto = 0;
        int cantidad = 0;
        int total = 0;
        int nota = 0;

        try{
            String sql = "select * from nota where nota = '"+id+"'";
            Cursor cur = db.rawQuery(sql, null);
            while (cur.moveToNext()) {
                sku = "" + cur.getInt(0);
                marca = cur.getString(1);
                nom = cur.getString(2);
                costo = cur.getInt(3);
                foto = cur.getInt(4);
                cantidad  = cur.getInt(5);
                total = cur.getInt(6);
                nota = cur.getInt(7);

                nota n = new nota(sku, marca, nom, costo, foto, cantidad);
                lista.add(n);
            }
            conn.close();
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
        }

        return lista;

    }

    public boolean eliminarNotaCompleta(int id){
        SQLiteDatabase db = conn.getWritableDatabase();
        boolean acc;
        try{
            String sql = "delete from nota where nota = '"+id+"'";
            db.execSQL(sql);
            conn.close();
            acc = true;
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            conn.close();
            acc = false;
        }
        return acc;
    }

}
