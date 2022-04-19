package main;

public class Cape extends ProtectiveGear {
	private double bonusAttribute;

	public Cape(String name) {
		super(name);
		bonusAttribute = 82.3;
	}

	/**
	 * Hozzáadja a Cape-et a virológushoz
	 * @param v A virológus akinek hozzáadja a BonusBag-et
	 */
	public void setAttribute(Virologist v) {
		v.setAgentResistance(bonusAttribute);
	}
	/**
	 * Elveszi a Cape-et a virológustól
	 * @param v A virológus akitől elveszi a BonusBag-et
	 */
	public void takeAway(Virologist v) {
		v.setAgentResistance(-bonusAttribute);
		v.Unwear(this);
	}

	public double getBonus() {
		return bonusAttribute;
	}

	public void Wear(){
		setAttribute(virologist);
	}
}
