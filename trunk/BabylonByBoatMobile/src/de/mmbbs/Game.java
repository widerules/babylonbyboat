package de.mmbbs;

import android.content.Context;

/*
 * Das Spiel als Objekt
 * @author Christian
 */
public class Game extends StateManager{
    // Spielinstanzen
    private Ship ship;
    private Lives lives;
    private Mine mines;
    private Score score;    
    
    public Game (Context context){
    	setLives(new Lives(context));
    	setScore(new Score());
        setShip(new Ship("boat.png"));        
    }

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Lives getLives() {
		return lives;
	}

	public void setLives(Lives lives) {
		this.lives = lives;
	}

	public Mine getMines() {
		return mines;
	}

	public void setMines(Mine mines) {
		this.mines = mines;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public void startGame() {
		this.getState().startGame(this);		
	}

	@Override
	public void looseLive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}    
}
