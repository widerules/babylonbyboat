package de.mmbbs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

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
	@Override
	public void paint(Canvas c, Paint p) {
		
	}
}
