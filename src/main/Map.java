package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A pályán található mezőket tárolja és megépíti a pályát.
 */
public class Map {
	private List<Tile> tiles;
	private List<Virologist> virologists;

	/**
	 * A pálya konstruktora
	 */
	public Map(){
		tiles = new ArrayList<Tile>();
		virologists = new ArrayList<Virologist>();
	}
	/**
	 * Megépíti a pályát
	 *
	 */
	public void Build() {

	}
}
