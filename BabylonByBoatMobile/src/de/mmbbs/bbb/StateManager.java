package de.mmbbs.bbb;
/*
 * Abstrakte Klasse die Zustände verwaltet
 * @author Christian
 */

public abstract class StateManager{

    private static State currentState;

    public StateManager()
    {
        setState(State.Playing);
    }

    public void setState(State a) {
        currentState = a;
    }
    public State getState() {
        return currentState;
    }
    public abstract void startGame();

    public abstract void looseLive();

    public abstract void pauseGame();
    
    public abstract void exitGame();
}
