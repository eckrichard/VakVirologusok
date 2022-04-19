package main;

public class Untouchable extends Effects implements Steppable {
	private long timeUntouchable;

	public Untouchable(){
		timeUntouchable = 0;
	}

	@Override
	public void Step() {
		if(timeUntouchable > 0) {
			timeUntouchable--;
			if(timeUntouchable == 0){
				virologist.setUntouchbale(false);
			}
		}
	}

	/**
	 * Beállítja a hatásnak az idejét
	 * @param n Az idő mértéke
	 */
	public void setTimeEffected(long n) {
		timeUntouchable = n;
		virologist.setUntouchbale(true);
	}

	public long getTime() {
		return timeUntouchable;
	}
}
