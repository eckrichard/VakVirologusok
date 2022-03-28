package main;

public abstract class Item {
	private String name;
	/**
	 * Megadja hogy egyenlő e az egyik tárgy a másikkal
	 * @param i A tárgy amit összehasonlítunk
	 */
	public boolean ItemEqual(Item i) {
		return true;
	}
}
