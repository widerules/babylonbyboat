package de.mmbbs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public abstract class Basic2dObject {
	
	//Klassenvaribalen
	private Bitmap bitmap;
	private int xPos;
	private int yPos;


	public Basic2dObject(int resourceId, Context context) {
				
		bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
	}
	
	

	public Basic2dObject(int ressourceId) {
		// TODO Auto-generated constructor stub
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}

	//Gibt Weite als Integer zur�ck
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	//Gibt hoehe als Integer zur�ck
	public int getHeight()
	{
		return bitmap.getHeight();
	}

	//Gibt hit als Booliean zur�ck
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
	public abstract void paint(Canvas c, Paint p);
	
	public ImageView getImage(int ressourceID)
	{
		return null;
	}
}
