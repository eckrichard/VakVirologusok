package main;

public class Cape extends ProtectiveGear {
	private long bonusAttribute;
	/**
	 * Hozzáadja a Cape-et a virológushoz
	 * @param v A virológus akinek hozzáadja a BonusBag-et
	 */
	public void setAttribute(Virologist v) {
		System.out.println("setAttribute: Cape");
		v.addGear(this);
	}
	/**
	 * Elveszi a Cape-et a virológustól
	 * @param v A virológus akitől elveszi a BonusBag-et
	 */
	public void takeAway(Virologist v) {
		System.out.println("takeAway: Cape");
		v.TakeGear(v,this);
	}
}
