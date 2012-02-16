package de.mmbbs;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Lives {
	private Integer livecounter;

	// Konstruktor
	public Lives () {
		this.livecounter = 3;
	}

	// Leben zeichnen
	public void paint (Canvas g, Paint p) {
		Paint paint = new Paint();
	    paint.setStyle(Paint.Style.FILL);

		g.drawText("Lives: " + livecounter.toString(), 10, 10, p);
	}

	// Leben um 1 reduzieren
	public void dec () {
		this.livecounter = this.livecounter - 1;
	}

	// Leben ausgeben
	public Integer getLives () {
		return this.livecounter;
	}
}