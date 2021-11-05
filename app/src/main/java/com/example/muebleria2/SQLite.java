package com.example.muebleria2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table usuario (id integer, nom texto, app texto, apm texto, pass texto, foto integer)";
        db.execSQL(sql);

        sql = "insert into usuario values(1,'TORRES','ROSAS','JUAN MIGUEL','8141' ,'" + R.drawable.b1 +"')";
        db.execSQL(sql);
        sql = "insert into usuario values(2,'GONZÁLEZ','VALDÉS ','PALOMA','8759' ,'" + R.drawable.b2+ "')";
        db.execSQL(sql);
        sql = "insert into usuario values(3,'NAVARRO','VANEGAS','RAFAEL','1980' ,'" + R.drawable.b3+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(4,'SALINAS','VIVEROS','PATRICIA','2649' ,'" + R.drawable.b4+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(5,'SETIÉN','ARANDA','MARÍA ASUNCIÓN','8093' ,'"+ R.drawable.b5+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(6,'CRUZ','ESPINOSA','ERICK','1464' ,'"+ R.drawable.b6+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(7,'GARCÍA','CABRERO','ANA CRISTINA','8886' ,'"+ R.drawable.b7+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(8,'GÓMEZ','CORDERO','ALEJANDRA','3107' ,'"+ R.drawable.b8+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(9,'CURIEL','DEL RÍO','CARLOS ALFONSO','8914' ,'"+ R.drawable.b9+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(10,'VERDUZCO','LEFFMANS','RENATA','8381' ,'"+ R.drawable.b10+"')";
        db.execSQL(sql);
        sql = "insert into usuario values(11,'VARELA','MALDONADO','MANUEL','9680' ,'"+ R.drawable.b11+"')";

        sql = "create table producto (sku integer, marca texto, nom texto,costo integer, foto integer)";
        db.execSQL(sql);
        sql = "insert into producto values (136009 ,'DIECSA','RACK TV SALEM','5265','" + R.drawable.d136009+ "')";
        db.execSQL(sql);
        sql = "insert into producto values (152591 ,'RAMPE','MESA ENGROSADA PARA TV 55 62.5X119.6X41.3 CM','3299','" + R.drawable.d152591+ "')";
        db.execSQL(sql);
        sql = "insert into producto values (153396 ,'DIB','MESA PARA COMEDOR DE MDF 90 X 150 X 75 CM CAFÉ ROBLE','6499','" + R.drawable.d153396+ "')";
        db.execSQL(sql);
        sql = "insert into producto values (162201 ,'BERTOLINI','MESA DE TV PANTALLA 47 ROYAL IMBUÍA CAPUCCINO 65 x 122 x 48 CM','2399','" + R.drawable.d162201+ "')";
        db.execSQL(sql);
        sql = "insert into producto values (154579 ,'BERTOLINI','MESA DE TV BERTOLINI EVER IMBUIA NEGRO CON PANEL','3499','" + R.drawable.d154579+ "')";
        db.execSQL(sql);
        sql = "insert into producto values (160652 ,'SKANOR','MESA DE TV CON REPISAS FRESNO 55X120X40','1999','" + R.drawable.d160652+ "')";
        db.execSQL(sql);

        sql = "create table nota (sku integer, marca texto, nom texto,costo integer,  foto integer, cantidad integer, total integer, nota integer)";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists usuario");
        db.execSQL("drop table if exists producto");
        db.execSQL("drop table if exists nota");
        onCreate(db);
    }
}
