package de.mmbbs;

import java.util.Vector;

import android.content.Context;

/*
 * Das Spiel als Objekt
 * @author Christian
 */
public class Game extends StateManager {

    // Spielinstanzen
    private Ship ship;
    private Lives lives;
    private Mine mines;
    private Vector<Mine> minesVector = new Vector<Mine>();
    private Score score;
    protected Context context;

    public Game(Context context) {
        this.context = context;
        setLives(new Lives(context));
        setScore(new Score());
        setShip(new Ship(R.drawable.boat, context));
        createMines(context, 3);
    }

    protected void createMines(Context context, int anzahl) {
        // Minen erstmal begrenzen. PERFORMANCE!
        if (minesVector.size() <= 12) {
            for (int i = 0; i < anzahl; i++) {
                minesVector.addElement(new Mine(R.drawable.mine, context, 50 + (i * 50), 20));
            }
        }
    }

    public Vector<Mine> getMinesVector() {
        return minesVector;
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
