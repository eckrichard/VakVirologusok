package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A pályán található mezőket tárolja és megépíti a pályát.
 */
public class Map {
	private List<Tile> tiles;
	private List<Virologist> virologists;
	private int mapNumber = 1;
	private int virologistNumber = 4;

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
		/**
		 * Map1
		 */
		if(mapNumber == 1){
			for(int i = 0; i < 14; i++){
				tiles.add(new Tile());
			}
			for(int i = 0; i < 2; i++){
				//tiles.add(new Laboratory());
			}
			for(int i = 0; i < 2; i++){
				//tiles.add(new Storage());
			}
			for(int i = 0; i < 2; i++){
				//tiles.add(new Shelter());
			}
		}
		/**
		 * Map2
		 */
		else {
			for(int i = 0; i < 27; i++){
				tiles.add(new Tile());
			}
			for(int i = 0; i < 4; i++){
				//tiles.add(new Laboratory());
			}
			for(int i = 0; i < 4; i++){
				//tiles.add(new Storage());
			}
			for(int i = 0; i < 4; i++){
				//tiles.add(new Shelter());
			}
		}
		for(int i = 0; i < virologistNumber; i++){
			virologists.add(new Virologist());
		}
	}

	public void setMapNumber(int mapNumber) {
		this.mapNumber = mapNumber;
	}

	public void setVirologistNumber(int virologistNumber) {
		this.virologistNumber = virologistNumber;
	}
}
