package com.pernix.contactos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgendaActivity extends Activity {
    EditText editNombre,editTelefono;
    private Button botonGuardar;
    private Button botonCerrar;  
       
    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
      //Asignamos a cada objeto visual creado a su respectivo elemento de main.xml           
      super.onCreate(savedInstanceState);
      setContentView(R.layout.add);
      editNombre   = (EditText) findViewById(R.id.txtName);   
      editTelefono = (EditText) findViewById(R.id.txtNumber); 
      botonGuardar = (Button) findViewById(R.id.cmdAdd);
      
      //Guardar el contacto actual en la agenda
      botonGuardar.setOnClickListener(new View.OnClickListener() 
      {
        public void onClick(View v) 
        {
        }
      });
    }
    
      
}