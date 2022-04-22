package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A mező ősosztály, ami a tárolja, hogy melyik virológusok vannak rajta és hogy mennyi
 * virológus lehet a mezőn. A feladata a szomszédos mezők tárolása és a virológusok mezőn
 * való tartózkodásának kezelése.
 */
public class Tile {
	protected long capacity;
	protected ArrayList<Tile> adjacentTiles;
	protected ArrayList<Virologist> virologits;

	/**
	 * Egy mező konstruktora
	 */
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

	/**
	 * Visszaadja a másik virológust a mezőről
	 * @param v a mi virológusunk
	 * @return a másik virológus
	 */
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

	/**
	 * Beállítja a felvehető tárgyat/kódot
	 * @param o
	 */
	public void setCollectable(Object o){ }

	/**
	 * Megmondja, hogy milyen gyűjthető objektum van a mezőn
	 * @return a felvehető tárgy/kód
	 */
	public Object GetCollectable(){
		return null;
	}
}
