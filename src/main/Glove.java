package main;

public class Glove extends ProtectiveGear {
	int remainingUses;
	public Glove(String name) {
		super(name);
		remainingUses = 3;
	}

	/**
	 * Elveszi a Glove-ot a virológustól
	 * @param v A virológus akitől elveszi a Glove-ot
	 */
	public void takeAway(Virologist v) {
		v.setThrowBackAvailable(false);
		v.Unwear(this);
	}
	/**
	 * Visszadobja az ágenst
	 * @param v A virológus akinek visszadobja az ágenst
	 * @param a Az ágens amit visszadob
	 */
	public void throwBack(Virologist v, Agent a) {
		if(v.getUntouchable() == false){
			remainingUses--;
			v.HitByAgent(a);
		}
	}
	/**
	 * Hozzáadja a Glove-ot a virológushoz
	 * @param v A virológus akinek hozzáadja a Glove-ot
	 */
	public void setAttribute(Virologist v) {
		v.setThrowBackAvailable(true);
	}

	@Override
	public void Wear() {
		setAttribute(virologist);
	}

	public int getRemainingUses() {
		return remainingUses;
	}

	public void Use(Virologist v, Agent a) {
		throwBack(v, a);
	}

	public void Destroy(){
		takeAway(virologist);
	}
}
