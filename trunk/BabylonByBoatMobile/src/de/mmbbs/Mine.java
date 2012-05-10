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

    private float _position_x;
    private float _position_y;
    private float _rotation = 10;

    private float _speed_x;
    private float _speed_y;
    private float _speed_rotation;
    private Matrix matrix = new Matrix();

    /**
     * @author Peter Hankel
     * @param int ressourceId - ImageRessourceIdentifier
     * @param float position_x / _y - the Mine will be spawned at this position
     */
    public Mine(int ressourceName, Context context, float position_x, float position_y) {
        //TODO: Bild nur einmal laden..
        super(ressourceName, context);
        _position_x = position_x;
        _position_y = position_y;

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
        _position_x = rand.nextFloat() * metrics.widthPixels;
        _position_y = -getHeight() / 2;

        _speed_x = rand.nextFloat() - 0.5f;
        _speed_y = rand.nextFloat() + MINIMUM_SPEED;
        _speed_rotation = rand.nextFloat() - 0.5f;
    }

    public void tick() {
        if (_position_y > SCREEN_HEIGHT + getHeight() / 2) {

        }
        else if (_position_x < 0) {
            _position_x = 0;
            _speed_x *= -1;
        }
        else if (_position_x > SCREEN_WIDTH - getWidth() / 2) {
            _position_x = SCREEN_WIDTH - getWidth() / 2;
            _speed_x *= -1;
        }
        _position_x += _speed_x;
        _position_y += _speed_y;
        _rotation += _speed_rotation;
    }

    @Override
    public void paint(Canvas c, Paint p) {
        matrix.setRotate(_speed_rotation, getBitmap().getWidth() / 2, getBitmap().getHeight() / 2);
        c.drawBitmap(
            Bitmap.createBitmap(getBitmap(), 0, 0, getBitmap().getWidth(), getBitmap().getHeight(), matrix, false),
            _position_x, _position_y, null);
        _position_x += _speed_x * (MINIMUM_SPEED + _speed_x);
        _position_y += _speed_y;
        if (_position_x > c.getWidth()) {
            _position_x = 0;
        }
        if (_position_y > c.getHeight()) {
            _position_y = 0;
        }
    }

	public void explode() {
		// TODO Auto-generated method stub
		
	}
}
