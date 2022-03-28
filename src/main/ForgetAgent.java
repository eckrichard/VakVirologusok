package main;

public class ForgetAgent extends Agent {

	/**
	 * Elveszi a virológustól a genetikai kódjait
	 * @param v A virológus akitől elveszi a kódokat
	 */
	public void takeAwayCode(Virologist v) {
		System.out.println("takeAwayCode: ForgetAgent");
	}
	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az időtartam ameddig hat
	 */
	public void setStatus(long n, Virologist v) {
		System.out.println("setStatus: ForgetAgent");
	}
}
