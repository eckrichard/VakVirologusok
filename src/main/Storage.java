package main;

import java.util.ArrayList;
import java.util.List;

public class Storage extends Tile {
	private List<Material> materials = new ArrayList<Material>();

	/**
	 * A raktár konstruktora
	 * @param materials a raktárban található anyagok
	 */
	public Storage(List<Material> materials){
		this.materials = materials;
	}

	/**
	 * Megmondja, hogy melyik anyag található a mezőn.
	 * @return az anyag, amit a mrzőn fel lehet venni
	 */
	public Material Collect() {
		System.out.println("Collect(): Material");
		return materials.get(materials.size() - 1);
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	@Override
	public Material GetCollectable() {
		System.out.println("GetCollectable(): Material");
		return Collect();
	}
}
