package main;

public class VitusDance extends Effects implements Steppable {
	private long timeDancing;

	/**
	 * Beállítja a hatásnak az idejét
	 * @param n Az idő mértéke
	 */
	public void setTimeEffected(long n) {
		System.out.println("setTimeEffetcted: VitusDance");
	}
}
