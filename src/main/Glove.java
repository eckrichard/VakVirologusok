package main;

public class Glove extends ProtectiveGear {
	/**
	 * Elveszi a Glove-ot a virológustól
	 * @param v A virológus akitől elveszi a Glove-ot
	 */
	public void takeAway(Virologist v) {
		System.out.println("takeAway: Glove");
	}
	/**
	 * Visszadobja az ágenst
	 * @param v A virológus akinek visszadobja az ágenst
	 * @param a Az ágens amit visszadob
	 */
	public void throwBack(Virologist v, Agent a) {
		System.out.println("throwBack");
	}
	/**
	 * Hozzáadja a Glove-ot a virológushoz
	 * @param v A virológus akinek hozzáadja a Glove-ot
	 */
	public void setAttribute(Virologist v) {
		System.out.println("setAttribute: Glove");
	}
}
