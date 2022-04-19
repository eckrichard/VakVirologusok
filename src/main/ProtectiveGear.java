package main;

public abstract class ProtectiveGear extends Item {
	protected Shelter shelter;

	public ProtectiveGear(String name) {
		super(name);
	}

	public abstract void takeAway(Virologist v);
	public abstract void setAttribute(Virologist v);

	/**
	 * A függvény hívása után nem csak a táskában lesz benne a
	 * védőfelszerelés, hanem viselni is fogja a virológus
	 */
	public abstract void Wear();

	public void Use(Virologist v, Agent a) {}

	public abstract void Destroy();
}
