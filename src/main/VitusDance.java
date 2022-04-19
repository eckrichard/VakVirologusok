package main;

public class VitusDance extends Effects {
	private long timeDancing;

	public VitusDance(){
		timeDancing = 0;
	}
	@Override
	public void Step() {
		if(timeDancing > 0) {
			timeDancing--;
		}
	}

	/**
	 * Beállítja a hatásnak az idejét
	 * @param n Az idő mértéke
	 */
	public void setTimeEffected(long n) {
		timeDancing = n;
	}

	public long getTime() {
		return timeDancing;
	}
}
