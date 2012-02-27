package de.mmbbs;
import java.util.ResourceBundle;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;

public class BasicAnimation extends Basic2dObject
{
	private int _stepsX;
	private int _stepsY;
	private int _currentStep;
	private String _resourceName;
	public BasicAnimation(String resourceName)
	{
		super(resourceName);
		_resourceName = resourceName;
		int xPos= getXPos();
		int yPos = getYPos();
		if(resourceName == "boot")
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
	
	
}
