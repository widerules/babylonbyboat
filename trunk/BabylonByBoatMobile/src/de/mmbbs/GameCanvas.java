package de.mmbbs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private static final String GAME_TITLE = "BabylonByBoate";
    private Bitmap water;
    private Bitmap wateralpha;

    // Spielinstanzen
    private Ship ship;
    private Lives lives;
    private Mine mines;
    private int gameState;

    public GameCanvas(Context context) {
        super(context);
        lives = new Lives(context);
    }

    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
        lives = new Lives(context);
    }

    private void initialize() {
        // Rohbilder in Bitmaps laden
        water = BitmapFactory.decodeResource(getResources(), R.drawable.waterrefl);
        wateralpha = BitmapFactory.decodeResource(getResources(), R.drawable.waterreflalpha);

        ship = new Ship("boat.png");
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
        c.drawText(GAME_TITLE, c.getWidth() / 2 - (GAME_TITLE.length() * 2), 10, p);
        drawWater(c);

        lives.paint(c, p);
        ship.paint(c);
    }

    private void drawWater(Canvas c) {
        // Die Wasserbilder müssen noch auf die entsprechende Größe skaliert werden
        // TODO-: (am-27.02.2012): das Skalieren evtl. in einen Thread auslagern, falls es zu lange dauert
        //                         aber spätestens, wenn die Animation hinzukommt
        Bitmap tmpwater = Bitmap.createScaledBitmap(water, c.getWidth(), c.getHeight(), true);
        Bitmap tmpwateralpha = Bitmap.createScaledBitmap(wateralpha, c.getWidth(), c.getHeight(), true);

        // und zeichnen
        c.drawBitmap(tmpwater, 0, 15, null);
        c.drawBitmap(tmpwateralpha, 0, 15, null);
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

}
