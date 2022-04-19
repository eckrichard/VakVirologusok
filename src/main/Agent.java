package main;

import java.util.ArrayList;

public abstract class Agent extends Item implements Steppable {
	protected long usable;
	protected ArrayList<Material> materials;
	protected Bag bag;

	public Agent(ArrayList<Material> m, String name){
		super(name);
		materials = m;
		usable = 5;
		bag = null;
	}

	public abstract void setStatus(long n, Virologist v);

	/**
	 * Lépteti az időt amíg még felhasználható a vírus
	 */
	public void Step() {
		if(usable > 0){
			usable--;
		}
	}

	/**
	 * Beállítja a táskát, amihez az ágens tartozik
	 * @param bag a táska amit beállítunk
	 */
	public void setBag(Bag bag) {
		this.bag = bag;
	}

	Bag getBag(){
		return bag;
	}

	long getUsable(){
		return usable;
	}

	void setUsable(long n){
		usable = n;
	}

	public ArrayList<Material> getNeededMaterials() {
		return materials;
	}
}
