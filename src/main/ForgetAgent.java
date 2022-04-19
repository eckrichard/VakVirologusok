package main;

import java.util.ArrayList;

public class ForgetAgent extends Agent {

	public ForgetAgent(ArrayList<Material> m, String name) {
		super(m, name);
	}

	/**
	 * Elveszi a virológustól a genetikai kódjait
	 * @param v A virológus akitől elveszi a kódokat
	 */
	public void takeAwayCode(Virologist v) {
		v.getGeneticCodes().clear();
		v.setCodeCount(0);
	}
	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az időtartam ameddig hat
	 */
	public void setStatus(long n, Virologist v) {
		takeAwayCode(v);
	}
}
