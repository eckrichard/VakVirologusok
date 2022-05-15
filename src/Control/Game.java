package Control;

import Control.GamePanel;
import Model.Map;

/**
 * A játék indítása és befejezése a feladata.
 */
public class Game {
	private GamePanel panel;

	private Map map;
	private boolean gamerunning;
	private int active = 0;
	private boolean hasMoved = false;

	/**
	 * A játékot irányító osztály konstruktora
	 */
	public Game(){
		map = new Map();
		map.setGame(this);
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
	public void setHasMoved(Boolean move) {
		this.hasMoved = move;
	}
	public Boolean getHasMoved() {
		return this.hasMoved;
	}

	public void setActiveDie() {
		this.active--;
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
