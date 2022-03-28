package main;

import java.util.ArrayList;
import java.util.List;

public class Bag {
	private long size;
	private Virologist virologist;
	private List<Agent> agents = new ArrayList<Agent>();
	private List<ProtectiveGear> protectiveGears = new ArrayList<ProtectiveGear>();
	private List<Material> materials = new ArrayList<Material>();

	/**
	 * A táska default konstruktora
	 */
	public Bag(){
		size = 30;
	}

	/**
	 * A táska ágenst hozzáadó konstruktora
	 * @param agent az ágens amit hozzáadunk
	 */
	public Bag(Agent agent){
		size = 30;
		agents.add(agent);
	}

	/**
	 * Kiveszi a listából az ágenst. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param a A kivenni kívánt ágens
	 */
	public void Discard(Agent a) {
		System.out.println("Discard(a: Agent): void");
		agents.remove(a);
	}
	/**
	 * Kiveszi a listából a védőfelszerelést. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param g A kivenni kívánt ágens
	 */
	public void Discard(ProtectiveGear g) {
		System.out.println("Discard(g: ProtectiveGear): void");
	}
	/**
	 * Kiveszi a listából az anyagot. Ezt nem helyezi sehova, a tárgy megsemmisül.
	 * @param m A kivenni kívánt ágens
	 */
	public void Discard(Material m) {
		System.out.println("Discard(m: Material): void");
	}

	/**
	 * Új ágenst ad a virológus raktárához.
	 * @param a A hozzáadott ágens
	 */
	public void Add(Agent a) {
		System.out.println("Add(a: Agent)");
		agents.add(a);
	}

	/**
	 * Új védőfelszerelést ad a virológus raktárához.
	 * @param g A hozzáadott védőfelszerelést
	 */
	public void Add(ProtectiveGear g) {
		System.out.println("Add(g: ProtectiveGear): void");
		protectiveGears.add(g);
	}

	/**
	 * Új anyagot ad a virológus raktárához.
	 * @param m A hozzáadott anyagot
	 */
	public void Add(Material m) {
		System.out.println("Add(m: Material): void");
		materials.add(m);
	}
}
