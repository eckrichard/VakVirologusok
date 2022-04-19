package main;

import java.util.ArrayList;

public class VitusDanceAgent extends Agent {
	private long duration;

	public VitusDanceAgent(ArrayList<Material> m, String name) {
		super(m, name);
		duration = 1;
	}

	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az idő mértéke
	 */
	public void setStatus(long n, Virologist v) {

	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
}
