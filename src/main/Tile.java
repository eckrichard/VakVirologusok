package main;

import java.util.ArrayList;
import java.util.List;

public class Tile {
	protected long capacity;
	protected ArrayList<Tile> adjacentTiles;
	protected ArrayList<Virologist> virologits;

	public Tile(){
		capacity = 2;
		adjacentTiles = new ArrayList<Tile>();
		virologits = new ArrayList<Virologist>();
	}
	/**
	 * Eltávolítja az adott mezőről a virológust.
	 * @param v Az a virológus, aki ellép
	 */
	public void Remove(Virologist v) {
		virologits.remove(v);
	}

	/**
	 * Beteszi az adott mezőre a virológust.
	 * @param v Az a virológus, aki odalép
	 */
	public void Accept(Virologist v) {
		if(virologits.size() < capacity){
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
	
	public Virologist GetOtherVirologist(Virologist v) {
		if(virologits.size() > 1){
			for( Virologist virologist : virologits){
				if(virologist != v){
					return virologist;
				}
			}
		}
		return null;
	}
	
	public Object GetCollectable(){
		return null;
	}
}
