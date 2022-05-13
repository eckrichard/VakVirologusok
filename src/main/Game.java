package main;

import gui.GamePanel;

/**
 * A játék indítása és befejezése a feladata.
 */
public class Game {
	private GamePanel panel;

	private Map map;
	private boolean gaímerunning;
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
		gaímerunning = true;
	}

	/**
	 * Leállítja a játékot
	 */
	public void endGame() {
		gaímerunning = false;
	}

	public int getActive(){
		return active;
	}

	public Map getMap() {
		return map;
	}
}
