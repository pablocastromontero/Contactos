package com.pernix.contactos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DBManager {

    private SQLiteDatabase baseDatos;   
    private static final String TAG = "bdagenda";   
    private static final String nombreBD = "agenda";   
    private static final String tablaContacto = "contacto";  
      
    //guardamos en un String toda la creación de la tabla        
    private static final String crearTablaContacto = "create table if not exists "  
        + " contacto (codigo integer primary key autoincrement, "  
        + " nombre text not null, telefono text not null unique);";   
      
	
	private DBManager(){
		
	}
	
	public static DBManager getInstance(){
		
		if ()
		
	}
	
    private void abrirBasedatos() 
    {   
      try 
      {   
        baseDatos = openOrCreateDatabase(nombreBD, MODE_WORLD_WRITEABLE, null);   
        baseDatos.execSQL(crearTablaContacto);   
      }    
      catch (Exception e)
      {   
        Log.i(TAG, "Error al abrir o crear la base de datos" + e);   
      }   
    }  
	

    private boolean insertarFila(String nombre, String telefono) 
    {   
      ContentValues values = new ContentValues();   
      values.put("nombre",nombre );   
      values.put("telefono", telefono);
      Toast.makeText(getApplicationContext(), "Nombre: " + nombre + ", " +
              "teléfono: " + telefono, Toast.LENGTH_LONG).show();
      return (baseDatos.insert(tablaContacto, null, values) > 0);   
    }
	
}
