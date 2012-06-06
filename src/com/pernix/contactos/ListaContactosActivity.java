package com.pernix.contactos;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class ListaContactosActivity extends ListActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list,new String[]{"En Construcción..."}));
	
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      boolean result = super.onCreateOptionsMenu(menu);
      
      //Cargamos el menú desde el fichero de recursos indicado por su identificador en la variable R
      MenuInflater menuInflater = getMenuInflater();
      menuInflater.inflate(R.menu.main_menu, menu);
      
      //Capturamos el item "Ayuda" del menú, para asociarle una intención, 
      //en este caso la itención que está asociada a la actividad HelpActivity
      MenuItem newMenuItem = menu.findItem(R.id.miNuevo);
      newMenuItem.setIntent(new Intent("com.pernix.contactos.intent.action.NEW"));
      
      return result;
    }	
}
