package de.mmbbs;
import java.util.ResourceBundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public class BasicAnimation
{
	private int _stepsX;
	private int _stepsY;
	private int _currentStep;
	public BasicAnimation(Basic2dObject object)
	{
		if(object.getClass() == Ship.Class)
		{
			_stepsX = 5;			
		}if(true)
		{
			_stepsX = 3;
		}
	}
	
	public static void start()
	{
		
	}
	public static void reset()
	{
		
	}	
	private int _stepsY = 0;
	private float currentsteps = 0;
	public static void paint()
	{
		if(currentsteps < _stepsX)
		{
			
		}
		else if(_stepsY = 4)
		{
			
		}
		else
		{
			currentsteps = 0;
			_stepsY += 1;
		}
		
		currentsteps += 1;
	}
	@Override
	public void paint(Canvas c, Paint p) 
	{
		c.drawBitmap();
	}
	
	
}

