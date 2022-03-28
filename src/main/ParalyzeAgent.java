package main;

public class ParalyzeAgent extends Agent {
	private long duration;
	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az időtartam ameddig tart
	 */
	public void setStatus(long n, Virologist v) {
		System.out.println("setStatus: ParalzeAgent");
	}
}
