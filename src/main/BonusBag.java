package main;

public class BonusBag extends ProtectiveGear {
	private long bonusAttribute;

	/**
	 * Hozzáadja a BonusBag-et a virológushoz
	 * @param v A virológus akinek hozzáadja a BonusBag-et
	 */
	public void setAttribute(Virologist v) {
		System.out.println("setAttribute: BonusBag");

		v.addGear(this);
	}
	/**
	 * Elveszi a BonusBag-et a virológustól
	 * @param v A virológus akitől elveszi a BonusBag-et
	 */
	public void takeAway(Virologist v) {
		System.out.println("takeAway: BonusBag");
		v.TakeGear(v,this);
	}
}