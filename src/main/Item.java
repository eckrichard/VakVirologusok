package main;

public abstract class Item {
	protected String name;

	public Item(String name) {
		this.name = name;
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
}
