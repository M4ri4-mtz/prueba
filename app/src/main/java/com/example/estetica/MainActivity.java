package com.example.estetica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usr,contraseña;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usr=(EditText) findViewById(R.id.usr);
        contraseña=(EditText) findViewById(R.id.password);
        btn_ingresar=(Button) findViewById(R.id.btn1);
        btn_ingresar.setOnClickListener(this);
    }
    //boton para validar datos e iniciar sesion
    public void onClick(View view) {
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String id=usr.getText().toString();
        String pass=contraseña.getText().toString();
        if (!id.isEmpty() && !pass.isEmpty() ){
            Cursor fila=bd.rawQuery("select usr, pass from USUARIO", null);
            if (fila.moveToFirst()){
                if (fila.getString(1).equals(id)&&fila.getString(2).equals(pass)){
                }
                bd.close();
            }else{
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_SHORT).show();
                bd.close();
            }
        }else {
            Toast.makeText(this, "Debes introducir todos  los datos", Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }

    public  void Registro(View view){
        Intent intent= new Intent(this,Activity_registro.class);
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}