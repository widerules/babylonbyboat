package de.mmbbs;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BabylonByBoate extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setTheme(R.style.Theme_Blue);
        setContentView(R.layout.main);
        
    }
    
    //Menü hinzufügen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.startscreen_menu, menu);
        return true;    	
    }
    
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
	   
	   AlertDialog.Builder aboutView = new AlertDialog.Builder(this);
	   aboutView.setTitle(R.string.about_title);
	   aboutView.setMessage(R.string.about_text);
	   aboutView.setPositiveButton(R.string.btn_ok, null);
	   
	   aboutView.show();
	   
	   return true;
   }
    
    public void buttonClick(View v) {
    	this.startActivity(new Intent(this,Game.class));
    }

}