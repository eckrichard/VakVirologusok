package main;

public class Material extends Item {
	/**
	 * Csökkenti az anyag mennyiségét
	 * @param amount Az összeg amennyivel csökkenti
	 */
	public void lessMaterial(long amount) {
		System.out.println("lessMaterial");
	}
	/**
	 * Növeli az anyag mennyiségét
	 * @param amount Az összeg amennyivel növeli
	 */
	public void addMaterial(long amount) {
		System.out.println("addMaterial");
	}
}
