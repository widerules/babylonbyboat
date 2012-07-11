/////////////////////////////////////////////////////////
//	BabylonByBoatMobile - Mine.java
//
//	created by Peter Hankel
//	on 16.02.2012
//
/////////////////////////////////////////////////////////

package de.mmbbs.bbb;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;

public class Mine extends Basic2dObject {

    private static int MINIMUM_SPEED = 2;
    private int SCREEN_WIDTH = 0;
    private int SCREEN_HEIGHT = 0;

    private float _speed_x;
    private float _speed_y;
    private float _speed_rotation;
    private Matrix matrix = new Matrix();
    
    private boolean _alive = true;

    /**
     * @author Peter Hankel
     * @param int ressourceId - ImageRessourceIdentifier
     * @param float position_x / _y - the Mine will be spawned at this position
     */
    public Mine(int ressourceName, Context context, int position_x, int position_y) {
        //TODO: Bild nur einmal laden..
        super(ressourceName, context);
        
        currentPosition = new Position(position_x, position_y);
     
        
        Random rand = new Random();
        _speed_x = rand.nextFloat() - 0.5f;
        _speed_y = rand.nextFloat() + MINIMUM_SPEED;
        _speed_rotation = rand.nextFloat() - 0.5f;
    }

    /**
     * @author Peter Hankel
     * @param int ressourceId - ImageRessourceIdentifier
     * @param Activity context - reference to an activity-context. Needed for getting the screenwidth
     */
    public Mine(int ressourceName, Activity context) {
        super(ressourceName);
        Random rand = new Random();

        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        SCREEN_WIDTH = metrics.widthPixels;
        SCREEN_HEIGHT = metrics.heightPixels;
        
        currentPosition = new Position((int)(rand.nextFloat() * metrics.widthPixels), -getHeight());

        _speed_x = rand.nextFloat() - 0.5f;
        _speed_y = rand.nextFloat() + MINIMUM_SPEED;
        _speed_rotation = rand.nextFloat() - 0.5f;
    }
    
    public boolean isAlive() {
    	return _alive;
    }
    
    @Override
    public void paint(Canvas c, Paint p) {
    	
        matrix.setRotate(_speed_rotation, getBitmap().getWidth() / 2, getBitmap().getHeight() / 2);
        c.drawBitmap(
        	Bitmap.createBitmap(getBitmap(), 0, 0, getBitmap().getWidth(), getBitmap().getHeight(), matrix, false),
        	currentPosition.x, currentPosition.y, null);
        currentPosition.x += _speed_x * (MINIMUM_SPEED + _speed_x);
        currentPosition.y += _speed_y;
        if (currentPosition.x > c.getWidth()) {
        	currentPosition.x = 0;
        }
        if (currentPosition.y > c.getHeight()) {
        	currentPosition.y = 0;
        }
        
    }

	public void explode() {
		_alive = false;
		BasicAnimation anim = new BasicAnimation(this);
		anim.setCurrentPosition(getCurrentPosition());
		anim.start();
	}
}
