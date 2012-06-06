package com.pernix.contactos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MostrarContactoActivity extends Activity {

    private Button botonLlamar;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
      //Asignamos a cada objeto visual creado a su respectivo elemento de main.xml           
      super.onCreate(savedInstanceState);
      setContentView(R.layout.add);
      botonLlamar = (Button) findViewById(R.id.btnViewCall);

      //Llamar al contacto actual por teléfono
      botonLlamar.setOnClickListener(new View.OnClickListener() 
      {
        public void onClick(View v) 
        {        
          //Mostrar un mensaje de confirmación antes de realizar la llamada  
          AlertDialog.Builder alertDialog = new AlertDialog.Builder(MostrarContactoActivity.this);
          alertDialog.setMessage("¿Desea realizar la llamada al contacto?");
          alertDialog.setTitle("Llamar a contacto...");
          alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
          alertDialog.setCancelable(false);
          alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            {
              try 
              {                       
                EditText num=(EditText)findViewById(R.id.txtNumber); 
                String number = "tel:" + num.getText().toString().trim();
                Toast.makeText(getApplicationContext(), 
                        "Llamando al " + num.getText().toString().trim(), Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number)); 
                startActivity(callIntent);
              } 
              catch (Exception e) 
              {
                  Toast.makeText(getApplicationContext(), 
                          "No se ha podido realizar la llamada", Toast.LENGTH_LONG).show();
              }
            } 
          }); 
          alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            {
              Toast.makeText(getApplicationContext(), 
                      "Llamada cancelada", Toast.LENGTH_LONG).show();
            } 
          }); 
          alertDialog.show();
        } 
      });
    
    }
}
