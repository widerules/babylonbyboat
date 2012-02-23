package de.mmbbs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

public class Basic2dObject {
	
	//Klassenvaribalen
	private Bitmap bitmap;
	private int xPos;
	private int yPos;

	public Basic2dObject(String ressourcesname) {
		bitmap = BitmapFactory.decodeFile(ressourcesname);
	}
	
	//Gibt Weite als Integer zurück
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	//Gibt hoehe als Integer zurück
	public int getHeight()
	{
		return bitmap.getHeight();
	}

	//Gibt hit als Booliean zurück
	public boolean hit(Basic2dObject b2dO)
	{
		return true; 
	}
	
	//Holt sich die Position des Boots auf der X Achse
	public int getXPos()
	{
		return 0;
	}
	
	//Holt sich die Position des Boots auf der Y Achse
	public int getYPos()
	{
		return 0;
	}
	
	//Paint?
	public void paint(Canvas c) {
		
	}
	
	public ImageView getImage(int ressourceID)
	{
		return null;
	}
}
