package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy mező, amin a virológus anyagot tud majd szerezni. A feladata az, hogy ha a virológus
 * megkísérli felvenni az anyagot, akkor megmondja, hogy ott melyik anyag található.
 */
public class Storage extends Tile {
	private ArrayList<Material> materials;

	/**
	 * A raktár konstruktora
	 * @param m a raktárban található anyagok
	 */
	public Storage(ArrayList<Material> m){
		super();
		this.materials = m;
	}

	public void setCollectable(ArrayList<Material> m) {this.materials = m;}

	/**
	 * Megmondja, hogy melyik anyag található a mezőn.
	 * @return az anyag, amit a mrzőn fel lehet venni
	 */
	public Material Collect() {
		return materials.get(materials.size() - 1);
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	@Override
	public Material GetCollectable() {
		return Collect();
	}

	/**
	 * Elpusztulnak a raktárban található anyagok (kiürül a lista, amibe
	 * tároljuk őket)
	 */
	public void DestroyMaterial(){
		materials.clear();
	}

	/**
	 * Kiírja az osztály attribútumainak értékeit
	 */
	public void Print(){
		System.out.println("Storage:");
		System.out.println("\tcapacity: " + capacity);
		System.out.print("\tadjacentTiles: ");
		if(adjacentTiles.size() != 0){
			for(int i = 0; i < adjacentTiles.size(); i++)
				System.out.print(adjacentTiles.get(i).getId() + ". tile ");
			System.out.println("");
		}
		if(adjacentTiles.size() == 0)
			System.out.println("null");
		System.out.print("\tvirologist: ");
		if(virologists.size() != 0){
			for(int i = 0; i < virologists.size(); i++)
				System.out.print(virologists.get(i).getId() + ". virologist ");
			System.out.println("");
		}
		if(virologists.size() == 0)
			System.out.println("null");
		System.out.print("\tmaterials: ");
		if(materials != null && materials.size() > 0){
			for(int i = 0; i < materials.size(); i++)
				System.out.print(materials.get(i).getId() + ". material ");
			System.out.println("");
		}
		else {
			System.out.println("null");
		}
		System.out.println("");
	}
}
