package de.mmbbs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;


public class Ship extends Basic2dObject implements SensorEventListener{
	

	private int screenwidth;
	private int screenheight;
	private int shipX;
	private int shipY;
	private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;
    private final Sensor mGyroscope;

	public Ship(int resourceId, Context context){
		super(resourceId, context);
		
		//Sensormanager initialisieren
		mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
	    
		//Sensoren laden
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		
         //Screen-Abmaße besorgen	    
		 WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		 Display display = wm.getDefaultDisplay();
		 screenwidth = display.getWidth();
		 screenheight = display.getHeight();
		
		 // StartKoordinaten für das Ship
		 shipX = (screenwidth /2) - (getWidth() /2);
		 shipY = screenheight - getHeight();

	}	
	
	@Override
	public void paint(Canvas c, Paint p) {
		c.drawBitmap(getBitmap(), shipX, shipY, p);
	}
	
	
	public void moveLeft()
	{
		shipX -= 1;
	}
	
	public void moveRight() {
		shipX += 1;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public Sensor getmAccelerometer() {
		return mAccelerometer;
	}

	public Sensor getmGyroscope() {
		return mGyroscope;
	}

	

	

}
