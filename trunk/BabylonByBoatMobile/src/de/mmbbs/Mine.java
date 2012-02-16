/////////////////////////////////////////////////////////
//	BabylonByBoatMobile - Mine.java
//
//	created by Peter Hankel
//	on 16.02.2012
//
/////////////////////////////////////////////////////////

package de.mmbbs;

import java.util.Random;

import android.app.Activity;
import android.util.DisplayMetrics;

public class Mine extends Basic2dObject {
	private static int MINIMUM_SPEED = 2;
	
	private float _position_x;
	private float _position_y;
	private float _rotation;
	
	private float _speed_x;
	private float _speed_y;
	private float _speed_rotation;
	
	
	/**
	 * @author Peter Hankel
	 * @param float position_x / _y - the Mine will be spawned at this position
	 */
	public Mine(float position_x, float position_y) {
		_position_x = position_x;
		_position_y = position_y;
		
		Random rand = new Random();
		_speed_x = rand.nextFloat() - 0.5f;
		_speed_y = rand.nextFloat() + MINIMUM_SPEED;
	}
	
	/**
	 * @author Peter Hankel
	 * @param Activity context - reference to an activity-context. Needed for getting the screenwidth
	 */ 
	public Mine(Activity context) {
		Random rand = new Random();
		
		DisplayMetrics metrics = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		_position_x = rand.nextFloat() * metrics.widthPixels;
		
		//TODO: Hier die halbe Breite des Bildes nehmen...
		_position_y = 0; 
		
		_speed_x = rand.nextFloat() - 0.5f;
		_speed_y = rand.nextFloat() + MINIMUM_SPEED;
	}
	
	public void tick() {
		_position_x += _speed_x;
		_position_y += _speed_y;
		_rotation += _speed_rotation;
	}
}
