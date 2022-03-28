package main;

import java.util.ArrayList;

public abstract class Agent extends Item implements Steppable {
	private long useable;
	private Bag bag;
	public abstract void setStatus(long n, Virologist v);

	/**
	 * Lépteti az időt amíg még felhasználható a vírus
	 */
	public void Step() {
		System.out.println("Step(): void");
		bag.Discard(this);
		bag = null;
	}

	/**
	 * Beállítja a táskát, amihez az ágens tartozik
	 * @param bag a táska amit beállítunk
	 */
	public void setBag(Bag bag) {
		this.bag = bag;
	}

	public ArrayList<Material> getNeededMaterials() {
		return null;
	}
}
