package de.mmbbs.bbb;

import java.io.InputStream;

import de.mmbbs.bbb.R;
import de.mmbbs.bbb.R.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Lives {

    private int livecounter; // Anzahl der aktuell vorhandenen Leben
    private Bitmap bm; // Variabel für unser Live Icon
    private int bm_width; // Breite des Bildes

    // Konstruktor
    public Lives(Context context) {
        // Herz Icon zuweisen
        InputStream is = context.getResources().openRawResource(R.drawable.herz); // Bild wird aus den Ressourcen geholt
        BitmapFactory.Options opts = new BitmapFactory.Options(); // Variabel um Bild ohne vorherige Speicherreservierung zu Laden
        opts.inJustDecodeBounds = true; // Speicherlose Pixelreservierung = true
        this.bm = BitmapFactory.decodeStream(is); // Unser Bild wird ins Bitmapformat umgewandelt
        // Breite des Icon's speichern
        this.bm_width = this.bm.getWidth(); // Breite des Bildes abfragen

        // Am Anfang hat man 3 Leben
        this.livecounter = 3; // Lebensanzahl auf 3 setzen
    }

    // Leben zeichnen
    public void paint(Canvas c, Paint p) {
        final int top = 5; // Variabel für Abstand zum Bildrand
        int left = 5; // Variabel für Abstand zum Bildrand

        for (int i = 1; i <= this.livecounter; i++) {
            // Bild zeichnen
            c.drawBitmap(this.bm, left, top, p);
            // Abstand zum n‰chsten Bild: 5px
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