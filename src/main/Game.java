package main;

/**
 * A játék indítása és befejezése a feladata.
 */
public class Game {

	private Map map;
	private boolean gaímerunning;

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
}
