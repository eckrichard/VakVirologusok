package main;

/**
 * Egy mező, amin a virológus védőfelszerelést tud majd szerezni. A feladata az, hogy ha a
 * virológus megkísérli felvenni a védőfelszerelést, akkor megmondja, hogy ott melyik védőfelszerelés
 * található.
 */
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

	/**
	 * Beállítja azt, hogy milyen védőfelszerelés találhatő a mezőn
	 * @param o a védőfelszerelés
	 */
	public void setCollectable(Object o){
		pG = (ProtectiveGear) o;
	}
}