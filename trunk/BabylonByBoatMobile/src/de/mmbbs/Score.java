package de.mmbbs;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Score {
	private Integer Punkte;
	
	//Konstruktor - score setzen
	public Score()
	{
		Punkte = 10000;
	}
	
	//Punkte hochzählen
	public void inc()
	{
		Punkte = Punkte + 1;
	}
	
	//Punkte zurückgeben
	public String getScore()
	{
		String sPunkte;
		sPunkte = Punkte.toString();
		return sPunkte;
	}
	
	//Punkte ausgeben
	public void paint (Canvas c, Paint p) {
		c.drawText("Score: " + Punkte, c.getWidth()-100, 10, p);
	}	
}
