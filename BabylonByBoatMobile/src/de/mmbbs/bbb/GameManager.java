package de.mmbbs.bbb;

/*
 * Klasse StateManager
 * @author Christian
 */
import android.graphics.Canvas;

public class GameManager implements Runnable, ExplosionListener {

    Thread runner;
    GameCanvas gc;
    Game game;
    long start, stop, diff;
    private long last_tick = 0;

    public GameManager(GameCanvas canvas) {
        gc = canvas;
        game = new Game(gc.getContext());
        gc.setGameToDraw(game);
        game.setState(State.Ready);
        initialiseGameScreenDrawing();
    }

    private void initialiseGameScreenDrawing() {
        if (game.getState().equals(State.Ready)) {
            game.setState(State.Playing);
            runner = new Thread(this);
            runner.start();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Canvas c = null;
        while (game.getState().equals(State.Playing)) {
            c = null;
            try {
                c = gc.getHolder().lockCanvas();
                synchronized (gc.getHolder()) {
                    start = System.currentTimeMillis();

                    if (c != null) {
                        gc.render(c);
                    }
                    stop = System.currentTimeMillis();
                    diff = stop - start;
                    long time = (System.currentTimeMillis() - last_tick);

                    if (time >= 5000) {
                        last_tick = System.currentTimeMillis();
                        game.createMines(game.context, 3);
                    }
                }
            }
            finally {
                if (c != null) {
                    gc.getHolder().unlockCanvasAndPost(c);
                }
            }
            try {
                if ((50 - diff) > 0) {
                    Thread.sleep(50 - diff);
                }
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

	@Override
	public void explosionFinished() {
		// TODO Auto-generated method stub
		
	}
}
