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
	 * A táska konstruktora. Beállítja a size-ot 30-ra, a virológust null-ra, a litákat pedig
	 * példányosítja
	 */
	public Bag(){
		size = 30;
		virologist = null;
		agents = new ArrayList<Agent>();
		protectiveGears = new ArrayList<ProtectiveGear>();
		materials = new ArrayList<Material>();
	}

	/**
	 * A virologist-et a paraméterként kapott értékre állítja
	 * @param v a virológus, amit beállít
	 */
	public void setVirologist(Virologist v){
		virologist = v;
	}

	/**
	 * A táska méretének a setterje
	 * @param n az amennyivel növeli a méretet
	 */
	public void setSize(long n){
		size += n;
	}

	/**
	 * Megmondja, hogy mennyi a táska mérete
	 * @return táska mérete
	 */
	public long getSize(){
		return size;
	}

	/**
	 * Megmondja, hogy milyen ágensei vannak
	 * @return az ágensek
	 */
	public ArrayList<Agent> getAgents() {
		return agents;
	}

	/**
	 * Megmondja, hogy milyen anyagai vannak
	 * @return az anyagok
	 */
	public ArrayList<Material> getMaterials() {
		return materials;
	}

	/**
	 * Megmondja, hogy milyen védőfelszerelései vannak
	 * @return az védőfelszerelések
	 */
	public ArrayList<ProtectiveGear> getProtectiveGears() {
		return protectiveGears;
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
