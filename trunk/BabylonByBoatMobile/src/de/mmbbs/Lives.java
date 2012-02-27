package de.mmbbs;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Lives {

    private int livecounter;
    private Bitmap bm;
    private int bm_width;

    // Konstruktor
    public Lives(Context context) {
    	// Herz Icon zuweisen
        InputStream is = context.getResources().openRawResource(R.drawable.herz);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        this.bm = BitmapFactory.decodeStream(is);
        // Breite des Icon's speichern
        this.bm_width = this.bm.getWidth();

        // Am Anfang hat man 3 Leben
        this.livecounter = 3;
    }

    // Leben zeichnen
    public void paint(Canvas g, Paint p) {
    	final int top = 15+5; // 15 ist der schwarze Bereich über dem Wasser
    	int left = 5;

    	for (int i=1;i<=this.livecounter;i++) {
    		// Bild zeichnen
        	g.drawBitmap(this.bm, left, top, p);
        	// Abstand zum nächsten Bild: 5px
        	left = left + this.bm_width + 5;
    	}
    }

    // Leben um 1 reduzieren
    public void dec() {
        this.livecounter = this.livecounter - 1;

        if (this.livecounter < 0) {
        	this.livecounter = 0;
        }
    }

    // Leben ausgeben
    public Integer getLives() {
        return this.livecounter;
    }
}