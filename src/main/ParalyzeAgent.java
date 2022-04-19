package main;

import java.util.ArrayList;

public class ParalyzeAgent extends Agent {
	private long duration;

	public ParalyzeAgent(ArrayList<Material> m, String name) {
		super(m, name);
		duration = 1;
	}

	/**
	 * Beállítja a virológusnak a státuszát
	 * @param v A virológus akinek beállítja a státuszát
	 * @param n Az időtartam ameddig tart
	 */
	public void setStatus(long n, Virologist v) {
		Paralyzed paralyzed = new Paralyzed();
		paralyzed.setTimeEffected(n);
		v.addEffect(paralyzed);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
}
