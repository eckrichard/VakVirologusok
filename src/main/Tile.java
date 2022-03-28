package main;

import java.util.ArrayList;
import java.util.List;

public class Tile {
	private long capacity;
	private List<Tile> adjacentTiles = new ArrayList<Tile>();
	private List<Virologist> virologits = new ArrayList<Virologist>();

	/**
	 * Eltávolítja az adott mezőről a virológust.
	 * @param v Az a virológus, aki ellép
	 */
	public void Remove(Virologist v) {
		System.out.println("Remove(v: Virologist)");
		virologits.remove(v);
	}

	/**
	 * Beteszi az adott mezőre a virológust.
	 * @param v Az a virológus, aki odalép
	 */
	public void Accept(Virologist v) {
		System.out.println("Accept(v: Virologist)");
		if(virologits.size() < 2){
			virologits.add(v);
		}
	}

	/**
	 * Megadja az n-edik szomszédos mezőt.
	 * @param n a mező száma
	 * @return A szomszédos mező
	 */
	public Tile GetNeighbor(long n) {
		System.out.println("GetNeighbor(n: long): Tile");
		return adjacentTiles.get((int)n);
	}

	/**
	 * Beállítja a szomszédos mezőt
	 * @param tile a szomszédos mező
	 */
	public void SetNeighbor(Tile tile){
		adjacentTiles.add(tile);
	}
	
	public Virologist GetOtherVirologist() {
		return null;
	}
	
	public Object GetCollectable(){
		return null;
	}
}
