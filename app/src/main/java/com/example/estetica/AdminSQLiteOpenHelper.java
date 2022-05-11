package com.example.estetica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE USUARIO(usr text primary key,pass int, tel int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
bd.execSQL("drop table  if exists USUARIO");
    }

    public  Boolean validacion(String usr){
        SQLiteDatabase bd=this.getWritableDatabase();
        Cursor cursor=bd.rawQuery("select * from USUARIO where usr=? and pass=?", new String[]{usr});
        if (cursor.getCount()>0)
            return  true;
        else
            return false;

    }
    public  Boolean validacionpass(String usr, String pass){
        SQLiteDatabase bd=this.getWritableDatabase();
        Cursor cursor=bd.rawQuery("select * from USUARIO where usr=? and pass=?", new String[]{usr,pass});
        if (cursor.getCount()>0)
            return  true;
        else
            return false;

    }
}
