package de.mmbbs;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Score {
	private Integer Points;
	
	//Konstruktor - score setzen
	public Score()
	{
		this.Points = 0;
	}
	
	//Punkte hochzählen
	public void inc()
	{
		this.Points = this.Points + 1;
	}
	
	//Punkte zurückgeben
	public String getScore()
	{
		String sPoints;
		sPoints = this.Points.toString();
		while (sPoints.length() < 5)
		{
			sPoints = "0" + this.Points.toString();
		}
		return sPoints;
	}
	
	//Punkte ausgeben
	public void paint(Canvas c, Paint p) {
		c.drawText("Score: " + getScore(), c.getWidth()-100, 10, p);
	}	
}
