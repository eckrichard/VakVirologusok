package main;

public class Shelter extends Tile {
	private ProtectiveGear p_g;

	/**
	 * Az óvóhely konstruktora
	 * @param p_g a mezőn található védőfelszerelés
	 */
	public Shelter(ProtectiveGear p_g){
		this.p_g = p_g;
	}

	/**
	 * Megmondja, hogy melyik védőfelszerelés található a
	 * @return
	 */
	public ProtectiveGear Collect() {
		System.out.println("Collect(): ProtectiveGear");
		return p_g;
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	public ProtectiveGear GetCollectable() {
		System.out.println("GetCollectable(): ProtectiveGear");
		return Collect();
	}
}