package de.mmbbs;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class GameCanvas extends SurfaceView  {

	public GameCanvas(Context context) {
		super(context);
	}
	
	public GameCanvas(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas g) {
		// TODO Auto-generated method stub
		super.onDraw(g);
		this.render(g);
	}

	public void render(Canvas c) {
		// TODO Auto-generated method stub
		Paint p = new Paint();
		p.setColor(Color.CYAN);
		c.drawText("Hello Game", 100, 10, p);
	}
	
}
