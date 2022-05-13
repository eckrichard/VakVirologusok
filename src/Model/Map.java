package Model;

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
			int[] pointsX = {0, 134, 230, 216, 0};
			int[] pointsY = {0, 0, 154, 235, 250};
			Tile A = new Tile(pointsX, pointsY, 5);
			tiles.add(A);
		}
		/**
		 * Map2
		 */
		else {
			;
		}
		for(int i = 0; i < virologistNumber; i++){
			Bag bag = new Bag();
			Virologist virologist = new Virologist(tiles.get(0), bag);
			virologists.add(virologist);
			virologist.setMap(this);
		}
		//virologists.get(1).getBag().setSize(20);
		//virologists.get(0).setTile(tiles.get(15));
	}

	public Tile getTile(int i) {return tiles.get(i);}

	public void setMapNumber(int mapNumber) {
		this.mapNumber = mapNumber;
	}

	public void setVirologistNumber(int virologistNumber) {
		this.virologistNumber = virologistNumber;
	}

	public List<Virologist> getVirologists() {
		return virologists;
	}
}
