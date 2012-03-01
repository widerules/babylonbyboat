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
	
	private Position currentPosition;

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Basic2dObject(int resourceId, Context context) {
		bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
	}

	public Basic2dObject(int ressourceId) {
		// TODO Auto-generated constructor stub
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}

	//Gibt Weite als Integer zurueck
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	//Gibt hoehe als Integer zurueck
	public int getHeight()
	{
		return bitmap.getHeight();
	}
	
	//Paint?
	public abstract void paint(Canvas c, Paint p);
	
	public ImageView getImage(int ressourceID)
	{
		return null;
	}
}