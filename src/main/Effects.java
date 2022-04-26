package main;

/**
 * A virológusra ható ágensek ősosztálya.
 */
public abstract class Effects implements Steppable{
	protected int id;
	Virologist virologist;

	/**
	 * Lépteti az időt.
	 */
	public abstract void Step();

	/**
	 * Beállítja, hogy meddig hat a virológusra az ágens
	 * @param n meddig hat a hatás
	 */
	public abstract void setTimeEffected(long n);

	/**
	 * A hatásból hátralévő idő
	 * @return hátralévő idő
	 */
	public abstract long getTime();

	/**
	 * Visszaadja a az osztály azonosítóját
	 * @return id: azonosító szám
	 */
	public int getId(){
		return id;
	}

	/**
	 * Beállítja, hogy mennyi az id-je
	 * @param id a a kapott id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
