package de.mmbbs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
public class GameCanvas extends SurfaceView {

    // Geschwindigkeitseinstellung
    private static final int DELAY = 10;
    private static final int WATERSPEED = 1;
    private static final int WATERALPHASPEED = 6;

    private Bitmap water;
    private Bitmap wateralpha;
    //   private Canvas canvas;
    private int waterPosY = 0;
    private int wateralphaPosY = 0;
    private long last_tick = 0;

    // Spielinstanzen
    private Game gameToDraw;

    public GameCanvas(Context context) {
        super(context);
        initialize();
    }

    public GameCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();        
    }

    private void initialize() {
        
    }

    @Override
    protected void onDraw(Canvas g) {
        // TODO Auto-generated method stub
        super.onDraw(g);
        this.render(g);
    }

    public void render(Canvas c) {
        // TODO Auto-generated method stub
        if (water == null || wateralpha == null) {
            loadAndScaleWaterBitmaps(c);
        }
        Paint p = new Paint();
        p.setColor(Color.CYAN);
        //c.drawText(GAME_TITLE, c.getWidth() / 2 - (GAME_TITLE.length() * 2), 10, p);

        // das Wasser zeichnen
        drawWater(c);

        gameToDraw.getLives().paint(c, p);        
        gameToDraw.getScore().paint(c, p);
        //gameToDraw.getMines().paint(c, p);
        //gameToDraw.getShip().paint(c, p);
    }

    /**
     * Läd die Bitmaps vom Wasser und skaliert diese auf die Größe von Canvas.
     * 
     * @param c - Canvas
     */
    private void loadAndScaleWaterBitmaps(Canvas c) {
        // Rohbilder in Bitmaps laden
        Bitmap tmpwater = BitmapFactory.decodeResource(getResources(), R.drawable.waterrefl);
        Bitmap tmpwateralpha = BitmapFactory.decodeResource(getResources(), R.drawable.waterreflalpha);
        // und skalieren
        water = Bitmap.createScaledBitmap(tmpwater, c.getWidth(), c.getHeight(), false);
        wateralpha = Bitmap.createScaledBitmap(tmpwateralpha, c.getWidth(), c.getHeight() + WATERALPHASPEED, false);
    }

    /**
     * Zeichnet die Water Bitmaps aufs Canvas und bei jedem neuen Aufruf wird die Position etwas nach unten verschoben.
     * 
     * @param c - Canvas
     */
    private void drawWater(Canvas c) {
        // Die Wasserbilder müssen noch auf die entsprechende Größe skaliert werden
        // TODO-: (am-27.02.2012): das Skalieren evtl. in einen Thread auslagern, falls es zu lange dauert
        //                         aber spätestens, wenn die Animation hinzukommt

        if (c != null) {
            long time = (System.currentTimeMillis() - last_tick);

            if (time >= DELAY) {
                last_tick = System.currentTimeMillis();

                // Water "oben" zeichnen
                c.drawBitmap(water, new Rect(0, water.getHeight() - waterPosY, water.getWidth(), water.getHeight()),
                    new Rect(0, 0, water.getWidth(), waterPosY), null);

                // Wateralpha "oben" zeichnen
                c.drawBitmap(wateralpha, new Rect(0, wateralpha.getHeight() - waterPosY, wateralpha.getWidth(),
                    wateralpha.getHeight()), new Rect(0, 0, wateralpha.getWidth(), waterPosY), null);

                // Water und Wateralpha zeichnen
                c.drawBitmap(water, 0, waterPosY, new Paint());
                c.drawBitmap(wateralpha, 0, waterPosY, new Paint());

                // Position (Höhe) nach unten verschieben
                waterPosY += WATERSPEED;

                // noch nicht verwendet!
                //wateralphaPosY += WATERALPHASPEED;
                if (waterPosY >= c.getHeight()) {
                    waterPosY = 0;
                }
                //                if (wateralphaPosY >= c.getHeight()) {
                //                    wateralphaPosY = 0;
                //                }
            }
        }
    }
    
    public void run(Canvas canvas) {

    }
    
	public void setGameToDraw(Game game) {
		this.gameToDraw = game;		
	}
}
