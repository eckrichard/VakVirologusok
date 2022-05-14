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
			createTiles1();
		}
		/**
		 * Map2
		 */
		else {

		}
		for(int i = 0; i < virologistNumber; i++){
			Bag bag = new Bag();
			Virologist virologist = new Virologist(null, bag);
			virologists.add(virologist);
			virologist.setMap(this);
		}
		virologists.get(0).getBag().Add(new Glove("gear"));
		virologists.get(0).getBag().Add(new BonusBag("gear"));
		virologists.get(0).getBag().Add(new Cape("gear"));
		virologists.get(0).getBag().Add(new Axe("gear"));
		virologists.get(0).getBag().Add(new ForgetAgent(null,"agent"));
		virologists.get(0).getBag().Add(new Material("material"));
		virologists.get(0).LearnCode(new GeneticCode(new ForgetAgent(null, "forget")));
	}
	
	public void addPolygon(int type, int[] pointsX, int[] pointsY, int n) {
		switch (type) {
			case 1:
				Tile tmp = new Tile(pointsX, pointsY, n);
				tiles.add(tmp);
				break;
			case 2:
				Laboratory tmp_L = new Laboratory(null, pointsX, pointsY, n);
				tiles.add(tmp_L);
				break;
			case 3:
				Shelter tmp_Sh = new Shelter(null, pointsX, pointsY, n);
				tiles.add(tmp_Sh);
				break;
			case 4:
				Storage tmp_St = new Storage(null, pointsX, pointsY, n);
				tiles.add(tmp_St);
				break;
		}
	}

	public void createPolygon(int type, int x1, int y1, int x2, int y2, int x3, int y3){
		int[] pointsX = {x1, x2, x3};
		int[] pointsY = {y1, y2, y3};
		addPolygon(type, pointsX, pointsY, 3);
	}
	public void createPolygon(int type, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		int[] pointsX = {x1, x2, x3, x4};
		int[] pointsY = {y1, y2, y3, y4};
		addPolygon(type, pointsX, pointsY, 4);
	}
	public void createPolygon(int type, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5){
		int[] pointsX = {x1, x2, x3, x4, x5};
		int[] pointsY = {y1, y2, y3, y4, y5};
		addPolygon(type, pointsX, pointsY, 5);
	}
	public void createPolygon(int type, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6){
		int[] pointsX = {x1, x2, x3, x4, x5, x6};
		int[] pointsY = {y1, y2, y3, y4, y5, y6};
		addPolygon(type, pointsX, pointsY, 6);
	}

	
	public void createTiles1() {
		//Sima mezők létrehozása, típus azonosítójuk: 1
		createPolygon(1, 0, 0, 134, 0, 230, 154, 138, 233, 0, 250);							//	A
		createPolygon(1, 370, 0, 508, 0, 585, 180, 367, 277, 230, 154, 387, 40);		//	B
		createPolygon(1, 508, 0, 673, 0, 814, 163, 585, 180);										//	C
		createPolygon(1, 138, 233, 230, 154, 367, 277);													//	D
		createPolygon(1, 0, 250, 138, 233, 276, 446, 238, 520, 0, 393);						//	E
		createPolygon(1, 138, 233, 367, 277, 276, 446);													//	F
		createPolygon(1, 585, 180, 814, 163, 649, 383);													//	G
		createPolygon(1, 814, 163, 1000, 353, 886, 363, 649, 383);									//	H
		createPolygon(1, 814, 163, 1000, 0, 1000, 353);													//	I
		createPolygon(1, 276, 446, 384, 485, 464, 700, 145, 700, 238, 520);					//	J
		createPolygon(1, 384, 485, 556, 548, 559, 700, 464, 700);									//	K
		createPolygon(1, 488, 420, 649, 383, 831, 530, 556, 548);									//	L
		createPolygon(1, 556, 548, 831, 530, 771, 700, 559, 700);									//	M
		createPolygon(1, 886, 363, 1000, 353, 1000, 590, 831, 530);								//	N

		//Laborok, típus azonosító: 2
		createPolygon(2, 134, 0, 370, 0, 387, 40, 230, 154);
		createPolygon(2, 831, 530, 1000, 590, 1000, 700, 771, 700);

		//Óvóhelyek, típus azonosító: 3
		createPolygon(3, 0, 393, 238, 520, 145, 700, 0, 700);
		createPolygon(3, 367, 277, 585, 180, 649, 383, 488, 420);

		//Raktárak, típus azonosító: 4
		createPolygon(4, 367, 277, 498, 323, 488, 420, 556, 548, 384, 485, 276, 446);
		createPolygon(4, 673, 0, 1000, 0, 814, 163);
		createPolygon(4, 649, 383, 886, 363, 831, 530);

		setNeighbors1();
	}

	public void setNeighbors1() {
		//A
		tiles.get(0).setNeighbor(tiles.get(14));
		tiles.get(0).setNeighbor(tiles.get(3));
		tiles.get(0).setNeighbor(tiles.get(4));
		//B
		tiles.get(1).setNeighbor(tiles.get(2));
		tiles.get(1).setNeighbor(tiles.get(3));
		tiles.get(1).setNeighbor(tiles.get(14));
		tiles.get(1).setNeighbor(tiles.get(17));
		//C
		tiles.get(2).setNeighbor(tiles.get(6));
		tiles.get(2).setNeighbor(tiles.get(19));
		//D
		tiles.get(3).setNeighbor(tiles.get(5));
		//E
		tiles.get(4).setNeighbor(tiles.get(8));
		tiles.get(4).setNeighbor(tiles.get(16));
		//F
		tiles.get(5).setNeighbor(tiles.get(18));
		//G
		tiles.get(6).setNeighbor(tiles.get(7));
		tiles.get(6).setNeighbor(tiles.get(17));
		//H
		tiles.get(7).setNeighbor(tiles.get(8));
		tiles.get(7).setNeighbor(tiles.get(13));
		tiles.get(7).setNeighbor(tiles.get(20));
		//I
		tiles.get(8).setNeighbor(tiles.get(19));
		//J
		tiles.get(9).setNeighbor(tiles.get(10));
		tiles.get(9).setNeighbor(tiles.get(16));
		tiles.get(9).setNeighbor(tiles.get(18));
		//K
		tiles.get(10).setNeighbor(tiles.get(12));
		tiles.get(10).setNeighbor(tiles.get(18));
		//L
		tiles.get(11).setNeighbor(tiles.get(12));
		tiles.get(11).setNeighbor(tiles.get(17));
		tiles.get(11).setNeighbor(tiles.get(18));
		tiles.get(11).setNeighbor(tiles.get(20));
		//M
		tiles.get(12).setNeighbor(tiles.get(15));
		//N
		tiles.get(13).setNeighbor(tiles.get(15));
		tiles.get(13).setNeighbor(tiles.get(20));
		//L1 - már minden szomszédja megvan
		//L2 - neki is
		//Ó1 - neki is
		//Ó2
		tiles.get(17).setNeighbor(tiles.get(18));
		//R1 - ezen a ponton már ennek is megvan minden szomszédja
		//R2 - ennek is
		//R3 - és ennek is
	}

	/**Ezzel a függvénnyel lekérdezhető egy adott indexű mező:	*/
	public Tile getTile(int i) {return tiles.get(i);}

	/**Ezzel pedig az összes mező:	*/
	public List<Tile> getTiles() {
		return tiles;
	}

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
