package de.mmbbs;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class Lives {
	private Integer livecounter;
	private Bitmap bm;

	// Konstruktor
	public Lives (Context context) {
		InputStream is = context.getResources().openRawResource(R.drawable.herz);
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		this.bm = BitmapFactory.decodeStream(is);

		this.livecounter = 3;
	}

	// Leben zeichnen
	@Deprecated
	public void paint_alt (Canvas g, Paint p) {
		g.drawText("Lives: " + livecounter.toString(), 10, 10, p);
	}

	public void paint (Canvas g, Paint p) {
		g.drawBitmap(this.bm, 10, 10, p);
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