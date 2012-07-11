package de.mmbbs.bbb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView;

public abstract class Basic2dObject {

	//Klassenvaribalen
	private Bitmap bitmap;
	
	protected Position currentPosition;

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
	
	public boolean hit(Basic2dObject o) {
		if(o != null 
				&& this.currentPosition.y >= o.getCurrentPosition().y 
				&& this.currentPosition.y <= o.getCurrentPosition().y + o.getHeight()
				&& this.currentPosition.x >= o.getCurrentPosition().x 
				&& this.currentPosition.x <= o.getCurrentPosition().x + o.getWidth()) {
			return true;
		}
		return false;
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