package de.mmbbs;

import android.graphics.Canvas;
import android.provider.MediaStore.Images;

public class Basic2dObject {
	
	private Images image;
	private int xPos;
	private int yPos;

	public Basic2dObject(String ressourcename) {
		
	}
	
	public int getWidth()
	{
		return 0;
	}
	
	public int getHeight()
	{
		return 0;
	}
	
	public boolean hit(int O)
	{
		return true; 
	}
	
	public int getXPos()
	{
		return 0;
	}
	
	public int getYPos()
	{
		return 0;
	}
	
	public void paint(Canvas c) {
		
	}
}
