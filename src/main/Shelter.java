package main;

public class Shelter extends Tile {
	private ProtectiveGear pG;

	/**
	 * Az óvóhely konstruktora
	 * @param pG a mezőn található védőfelszerelés
	 */
	public Shelter(ProtectiveGear pG){
		this.pG = pG;
	}

	/**
	 * Megmondja, hogy melyik védőfelszerelés található a
	 * @return
	 */
	public ProtectiveGear Collect() {
		return pG;
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	public ProtectiveGear GetCollectable() {
		return Collect();
	}
}