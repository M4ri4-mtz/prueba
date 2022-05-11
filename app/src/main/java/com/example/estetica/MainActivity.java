package com.example.estetica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
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
        String u=usr.getText().toString();
        String p=contraseña.getText().toString();
        if (TextUtils.isEmpty(u) || TextUtils.isEmpty(p))
            Toast.makeText(MainActivity.this," los datos son requeridos", Toast.LENGTH_SHORT).show();
            else{
                Boolean validacion =admin.validacionpass(u,p);
                if (validacion==true){
                    Toast.makeText(MainActivity.this,"inicio correcto", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(this,Activity_registro.class);
                    startActivity(intent);
                }
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