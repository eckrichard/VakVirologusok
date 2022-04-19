package main;

public abstract class Item {
	protected String name;
	protected Virologist virologist;

	public Item(String name) {
		this.name = name;
		virologist = null;
	}

	/**
	 * Megadja hogy egyenlő e az egyik tárgy a másikkal
	 * @param i A tárgy amit összehasonlítunk
	 */
	public boolean ItemEqual(Item i) {
		if(this.name.equals(i.name)){
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	/**
	 * Beállítja, hogy melyik virológus birtokában van a tárgy
	 * @param v A virológus, akinél van
	 */
	public void setVirologist(Virologist v) {
		this.virologist = v;
	}
}
