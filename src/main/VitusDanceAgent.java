package main;

public class VitusDanceAgent extends Agent {
	private long duration;
	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az idő mértéke
	 */
	public void setStatus(long n, Virologist v) {
		System.out.println("setStatus: VitusDanceAgent");
	}
}
