package main;

/**
 * A virológusra ható ágensek ősosztálya.
 */
public abstract class Effects implements Steppable{

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
}
