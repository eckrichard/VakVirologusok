package Model;

import Control.GamePanel;

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

	public void setActive() {
		if(active != map.getVirologists().size() - 1)
			active++;
		else
			active = 0;
	}

	/**
	 * Leállítja a játékot
	 */
	public void endGame() {
		gamerunning = false;
	}

	/**
	 * visszaadja az aktív játékos sorszámát
	 * @return active - a sorszám
	 */
	public int getActive(){
		return active;
	}

	public Map getMap() {
		return map;
	}
}
