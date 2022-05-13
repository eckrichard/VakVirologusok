package main;

import gui.GamePanel;

/**
 * A játék indítása és befejezése a feladata.
 */
public class Game {
	private GamePanel panel;

	private Map map;
	private boolean gamerunning;
	private int active = 0;

	/**
	 * A játékot irányító osztály konstruktora
	 */
	public Game(){
		map = new Map();
	}

	/**
	 * Elindítja a játékot. Meghívja a Map Build metódusát
	 */
	public void startGame() {
		map.Build();
		gamerunning = true;
	}

	/**
	 * Leállítja a játékot
	 */
	public void endGame() {
		gamerunning = false;
	}

	public int getActive(){
		return active;
	}

	public Map getMap() {
		return map;
	}
}
