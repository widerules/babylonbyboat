package de.mmbbs;
import java.util.ResourceBundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public class BasicAnimation extends Basic2dObject
{
	private int _stepsX;
	private int _stepsY;
	private int _currentStep;
	private int _resourceName;
	public BasicAnimation(int resourceName)
	{
		super(resourceName);
		_resourceName = resourceName;
		int xPos= getXPos();
		int yPos = getYPos();
		if(resourceName == R.drawable.boat)
		{
			_stepsX = 5;
			paint();
		}
		else
		{
			_stepsX = 3;
		}
	}
	public static void reset()
	{
		
	}	
	public static void paint()
	{
		int currentSteps = 0;
	}
	@Override
	public void paint(Canvas c, Paint p) {
		// TODO Auto-generated method stub
		
	}
	
	
}

