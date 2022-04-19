package main;

import java.util.ArrayList;

public class UntouchableAgent extends Agent {
	private long duration;

	public UntouchableAgent(ArrayList<Material> m, String name) {
		super(m, name);
		duration = 1;
	}

	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az idő mértéke
	 */
	public void setStatus(long n, Virologist v) {
		Untouchable untouchable = new Untouchable();
		untouchable.setTimeEffected(n);
		v.addEffect(untouchable);
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}
}
