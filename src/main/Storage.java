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
	 * @param materials a raktárban található anyagok
	 */
	public Storage(ArrayList<Material> materials){
		materials = new ArrayList<Material>();
		this.materials = materials;
	}

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
}
