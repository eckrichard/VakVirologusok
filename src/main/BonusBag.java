package main;

public class BonusBag extends ProtectiveGear {
	private long bonusAttribute;

	public BonusBag(String name) {
		super(name);
		bonusAttribute = 20;
	}

	/**
	 * Hozzáadja a BonusBag-et a virológushoz
	 * @param v A virológus akinek hozzáadja a BonusBag-et
	 */
	public void setAttribute(Virologist v) {
		v.getBag().setSize(bonusAttribute);
	}
	/**
	 * Elveszi a BonusBag-et a virológustól
	 * @param v A virológus akitől elveszi a BonusBag-et
	 */
	public void takeAway(Virologist v) {
		v.getBag().setSize(-bonusAttribute);
		v.Unwear(this);
	}

	public long getBonus(){
		return bonusAttribute;
	}

	public void Wear(){
		setAttribute(virologist);
	}

	@Override
	public void Destroy() {
		takeAway(virologist);
	}
}