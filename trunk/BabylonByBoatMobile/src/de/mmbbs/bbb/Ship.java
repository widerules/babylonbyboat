package de.mmbbs.bbb;

/* @author David Redlich*/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;

public class Ship extends Basic2dObject implements SensorEventListener {

	private int screenwidth;
	private int screenheight;
	private int shipX;
	private int shipY;
	private final SensorManager mSensorManager;
	private final Sensor mAccelerometer;
	private final Sensor mGyroscope;
	private final Sensor mOrientation;
	private boolean accelerometer;
	private boolean gyroscope;
	private long lastUpdate;
	private Matrix matrix;
	private float direction = 0;
	private float oldDirection = 0;
	private ShipExplosion shipExplosion;
	private static final int ALIVE=0;
	private static final int EXPLODE=1;
	private int state=ALIVE;
	
	
	public Ship(int resourceId, Context context) {
		super(resourceId, context);

		shipExplosion = new ShipExplosion();

		// Sensormanager initialisieren
		mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_NORMAL);

		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
												SensorManager.SENSOR_DELAY_NORMAL);

//		lastUpdate = System.currentTimeMillis();

		// Sensoren laden
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

		// Screen-Abmasse besorgen
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		screenwidth = display.getWidth();
		screenheight = display.getHeight();

		// StartKoordinaten f√ºr das Ship
		shipX = (screenwidth / 2) - (getWidth() / 2);
		shipY = screenheight - getHeight();

	}

	public ShipExplosion getExplosion() {
		return shipExplosion;
	}
	
	@Override
	public void paint(Canvas c, Paint p) {
		if (state==ALIVE) {
			matrix = new Matrix();
			matrix.setTranslate(shipX, shipY);
			c.drawBitmap(getBitmap(), matrix, p);
			// if (oldDirection < direction) this.moveLeft();
			// if (oldDirection > direction) this.moveRight();
		}
		else if (state==EXPLODE) {
			shipExplosion.paint(this);
		}
	}

	public void moveLeft() {
//		matrix.preRotate(-1.f);
		shipX -= 1;
//		matrix.preRotate(1.f);
	}

	public void moveRight() {
//		matrix.preRotate(1.f);
		shipX += 1;
//		matrix.preRotate(-1.f);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float[] values = event.values;
		// Movement
		float x = values[0];
		float y = values[1];
		float z = values[2];

		if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
			// Multiplikator f¸r die Bewegungsgeschwindigkeit des Schiffes
			double multiplier = 1.0;

			if (event.values[1] > 5.0) {
				if (event.values[1] > 5.0 && event.values[1] <= 15.0) {
					multiplier = 3;
				}
				else if (event.values[1] > 15.0 && event.values[1] <= 30.0) {
					multiplier = 6;
				}
				else if (event.values[1] > 30.0) {
					multiplier = 9;
				}

				for (int i = 1; i < 3 * multiplier; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveLeft();
				}
			}
			if (event.values[1] < -5.0) {
				if (event.values[1] < -5.0 && event.values[1] >= -15.0) {
					multiplier = 3;
				}
				else if (event.values[1] < -15.0 && event.values[1] >= -30.0) {
					multiplier = 6;
				}
				else if (event.values[1] < -30.0) {
					multiplier = 9;
				}

				for (int i = 1; i < 3 * multiplier; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					moveRight();
				}
			}
		}

		else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			// Movement
			oldDirection = direction;
			direction = values[0];
				
//				x = values[0];
//				y = values[1];
//				z = values[2];

//				float accelationSquareRoot = (x * x + y * y + z * z)
//						/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
//				long actualTime = System.currentTimeMillis();
//				if (accelationSquareRoot >= 1.2) //
//				{
//					if (x < -1) {
//						for (int i = 1; i < 5; i++) {
//							moveRight();
//						}
//					} else {
//						for (int i = 1; i < 5; i++) {
//							moveLeft();
//						}
//					}
//
//					if (actualTime - lastUpdate < 200) {
//						return;
//					}
//					lastUpdate = actualTime;
//				}
		}
	}

	

	public Sensor getmAccelerometer() {
		return mAccelerometer;
	}

	public Sensor getmGyroscope() {
		return mGyroscope;
	}

	
	public void explode() {
		// TODO Auto-generated method stub
		state=EXPLODE;
	}

}
