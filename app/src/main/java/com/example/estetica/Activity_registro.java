package com.example.estetica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_registro extends AppCompatActivity {
    private EditText usuario,contraseña,tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario=(EditText) findViewById(R.id.id);
        contraseña=(EditText) findViewById(R.id.contra);
        tel=(EditText) findViewById(R.id.tel);
    }
    public void RegistrarUsuario(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this, "bd_usuarios", null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String usr=usuario.getText().toString();
        String pass=contraseña.getText().toString();
        String tele=tel.getText().toString();
        if (!usr.isEmpty() && !pass.isEmpty() && !tele.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put(Utilidades.CAMPO_USR,usr);
            registro.put(Utilidades.CAMPO_PASS,pass);
            registro.put(Utilidades.CAMPO_TEL,tele);
            bd.insert("USUARIO", null,registro);
            bd.close();
            Limpiar();
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
            bd.close();
        }
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void Limpiar(){
        usuario.setText("");
        contraseña.setText("");
        tel.setText("");
    }

}