package de.mmbbs;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Game extends Activity implements Runnable{
	Thread runner;
	GameCanvas gc;
	long start,stop,diff;
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
	        setContentView(R.layout.game);
	        gc=(GameCanvas) this.findViewById(R.id.gui);
	        runner = new Thread(this);
	        runner.start();
	    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Canvas c = null;
		while (true) {
			c=null;
			try {
				c=gc.getHolder().lockCanvas();
				synchronized(gc.getHolder()) {
					start = System.currentTimeMillis();
					
					if (c!=null) {
						gc.render(c);
					}
					stop = System.currentTimeMillis();
					diff=stop-start;
				}
			}
			finally {
				if (c != null) {
					gc.getHolder().unlockCanvasAndPost(c);
				}				
			}
			try {
				if ((50-diff)>0)
				Thread.sleep(50-diff);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
