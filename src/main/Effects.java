package main;

public abstract class Effects implements Steppable{

	Virologist virologist;

	/**
	 * Lépteti az időt.
	 */
	public abstract void Step();
	
	public abstract void setTimeEffected(long n);

	public abstract long getTime();
}
