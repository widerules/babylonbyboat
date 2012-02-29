package de.mmbbs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Ship extends Basic2dObject{
	
	private static final Bitmap bitmap = BitmapFactory.decodeFile("");
	
	public Ship(int ressourceName, Context context){
		super(ressourceName);		
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
