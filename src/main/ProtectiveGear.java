package main;

public abstract class ProtectiveGear extends Item {
	private Shelter shelter;
	private Virologist virologist;
	public abstract void takeAway(Virologist v);
	public abstract void setAttribute(Virologist v);

	/**
	 * A függvény hívása után nem csak a táskában lesz benne a
	 * védőfelszerelés, hanem viselni is fogja a virológus
	 */
	public void Wear() {
		System.out.println("Wear(): void");
		setAttribute(virologist);
	}

	/**
	 * Beállítja, hogy melyik virológus birtokában van a tárgy
	 * @param v A virológus, akinél van
	 */
	public void setVirologist(Virologist v) {
		this.virologist = v;
	}
}
