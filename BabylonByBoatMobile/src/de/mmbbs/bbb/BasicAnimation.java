package de.mmbbs.bbb;
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
		if(object.getClass() == Ship.class)
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
	private float currentsteps = 0;
	
	public void paint()
	{
		if(currentsteps < _stepsX)
		{
			
		}
		else if(_stepsY == 4)
		{
			
		}
		else
		{
			currentsteps = 0;
			_stepsY += 1;
		}
		
		currentsteps += 1;
	}

	public void paint(Canvas c, Paint p) 
	{
		//c.drawBitmap();
	}

	public void setCurrentPosition(Position currentPosition) {
		// TODO Auto-generated method stub
		
	}
	
	
}

