package de.mmbbs;
/*
 * Interface IStateManager
 * @author Christian
 */

 
public interface IStateManager {

    public void startGame(Game game) ;
    public void looseLive(Game game) ;
    public void pauseGame(Game game) ;
    public void exitGame(Game game) ;
}
