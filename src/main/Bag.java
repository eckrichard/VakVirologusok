package main;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	private long size;
	private Virologist virologist;
	private ArrayList<Agent> agents;
	private ArrayList<ProtectiveGear> protectiveGears;
	private ArrayList<Material> materials;

	/**
	 * A táska default konstruktora
	 */
	public Bag(){
		size = 30;
		virologist = null;
		agents = new ArrayList<Agent>();
		protectiveGears = new ArrayList<ProtectiveGear>();
		materials = new ArrayList<Material>();
	}

	void setVirologist(Virologist v){
		virologist = v;
	}

	void setSize(long n){
		size += n;
	}

	long getSize(){
		return size;
	}

	/**
	 * Kiveszi a listából az ágenst. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param a A kivenni kívánt ágens
	 */
	public void Discard(Agent a) {
		agents.remove(a);
	}
	/**
	 * Kiveszi a listából a védőfelszerelést. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param g A kivenni kívánt ágens
	 */
	public void Discard(ProtectiveGear g) {
		protectiveGears.remove(g);
	}
	/**
	 * Kiveszi a listából az anyagot. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param m A kivenni kívánt ágens
	 */
	public void Discard(Material m) {
		materials.remove(m);
	}

	/**
	 * Új ágenst ad a virológus raktárához.
	 * @param a A hozzáadott ágens
	 */
	public void Add(Agent a) {
		agents.add(a);
	}

	/**
	 * Új védőfelszerelést ad a virológus raktárához.
	 * @param g A hozzáadott védőfelszerelést
	 */
	public void Add(ProtectiveGear g) {
		protectiveGears.add(g);
	}

	/**
	 * Új anyagot ad a virológus raktárához.
	 * @param m A hozzáadott anyagot
	 */
	public void Add(Material m) {
		materials.add(m);
	}
}
