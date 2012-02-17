package de.mmbbs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Ship extends Basic2dObject{
	
	private static final Bitmap bitmap = BitmapFactory.decodeFile("");
	
	public Ship(String ressourcename){
		super(ressourcename);
		
	}
	
	public void moveLeft()
	{
		
	}
	
	public void moveRight() {
		
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	

}
