package de.mmbbs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

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
    
    //Menue hinzufuegen
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
	   //aboutView.setMessage(R.string.about_text);
	   ScrollView sv = new ScrollView(this);
	     
	   LinearLayout credits = new LinearLayout(this);
	   credits.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	   credits.setOrientation(LinearLayout.VERTICAL);
	   ImageView img = new ImageView(this);
	   img.setLayoutParams(new LayoutParams(400, 200));
	   img.setImageResource(R.drawable.about);
	   credits.addView(img);
	   
	   TextView tv = new TextView(this);
	   tv.setText(R.string.about_text);
	   credits.addView(tv);
	   sv.addView(credits);
	   aboutView.setView(sv);
	   aboutView.setPositiveButton(R.string.btn_ok, null);
	   //aboutView.setIcon(R.drawable.mine);
	
	   aboutView.show();
	   
	   return true;
   }
    
    public void buttonClick(View v) {
    	Intent i = new Intent();
    	i.setClass(getBaseContext(), GameActivity.class);
    	this.startActivity(i);
    }

}