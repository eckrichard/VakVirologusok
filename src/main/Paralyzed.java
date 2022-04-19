package main;

public class Paralyzed extends Effects{
	private long timeParalyzed;

	public Paralyzed(){
		timeParalyzed = 0;
	}

	@Override
	public void Step() {
		if(timeParalyzed > 0){
			timeParalyzed--;
		}
	}

	/**
	 * Beállítja a hatásnak az idejét
	 * @param n Az idő mértéke
	 */
	public void setTimeEffected(long n) {
		timeParalyzed = n;
	}

	@Override
	public long getTime() {
		return timeParalyzed;
	}
}
