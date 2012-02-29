package de.mmbbs;
/*
 * Enumeration mit Spielzust�nden
 * @author Christian
 */
public enum State implements IStateManager {

    Ready {
        @Override
        public void startGame(Game game) {        	
        }
    	
        @Override
        public void looseLive(Game game) {
        }

        @Override
        public void pauseGame(Game game) {
        }

        @Override
        public void exitGame(Game game) {
        }
    },
    Playing {
        @Override
        public void startGame(Game game) {
        	
        }
    	
        @Override
        public void looseLive(Game game) {
        }

        @Override
        public void pauseGame(Game game) {
        }

        @Override
        public void exitGame(Game game) {
        }
    },
    Paused {
        @Override
        public void startGame(Game game) {
        }
    	
        @Override
        public void looseLive(Game game) {
        }

        @Override
        public void pauseGame(Game game) {
        }

        @Override
        public void exitGame(Game game) {
        }
    },
    Gameover {
        @Override
        public void startGame(Game game) {
        }
    	
        @Override
        public void looseLive(Game game) {
        }

        @Override
        public void pauseGame(Game game) {

        }

        @Override
        public void exitGame(Game game) {
        }
    },

}
