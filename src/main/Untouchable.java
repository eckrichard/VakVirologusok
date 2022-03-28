package main;

public class Untouchable extends Effects implements Steppable {
	private long timeUntouchable;

	/**
	 * Beállítja a hatásnak az idejét
	 * @param n Az idő mértéke
	 */
	public void setTimeEffected(long n) {
		System.out.println("setTimeEffected: Untouchable");
	}
}
