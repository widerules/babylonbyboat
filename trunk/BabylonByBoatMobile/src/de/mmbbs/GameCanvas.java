package de.mmbbs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * 
 * (16.02.2012 14:58:53) am:<ul><li>Neue Methoden hinzugefügt (ohne Inhalt).</li></ul>
 * (16.02.2012 14:43:54) am:<ul><li>Klasse ExplosionListener wird nun implementiert</li></ul>
 * 
 * @author Alex
 *
 */
public class GameCanvas extends SurfaceView implements ExplosionListener {

    // TODO-: (am-16.02.2012): States über StatePattern auslagern!
    private static final int STATE_LOSTLIVE = 1;
    private static final int STATE_SPIEL = 1;
    private static final int STATE_GAMEOVER = -1;

    private int lives;
    private int gameState;

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

    /**
     * getLives - Liefert die Anzahl der Lebenspunkte.
     * 
     * @return - Anzahl Leben
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * setLives - Setzt die Anzahl Leben
     * 
     * @param lives - Anzahl Leben
     */
    private void setLives(int lives) {
        this.lives = lives;
    }

    private void run() {
        // TODO-: (am-16.02.2012): noch mit Inhalt füllen
    }

    /**
     * getState - Liefert den aktuellen Spielstatus (state)
     */
    public void geState() {
        // TODO-: (am-16.02.2012): noch mit Inhalt füllen
    }

    /**
     * decLives - Zieht den aktuellen Lebenspunkten einen Lebenspunkt ab.
     */
    private void decLives() {
        // TODO-: (am-16.02.2012): noch mit Inhalt füllen
        setLives(getLives() - 1);
    }

}
