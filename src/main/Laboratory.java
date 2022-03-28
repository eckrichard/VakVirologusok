package main;

public class Laboratory extends Tile {
	private GeneticCode geneticCode;

	/**
	 * A labor konstruktora
	 * @param code
	 */
	public Laboratory(GeneticCode code) {
		geneticCode = code;
	}

	/**
	 * Megmondja, hogy a mezőn melyik genetikai kód található
	 * @return A mezőn található genetikai kód
	 */
	public GeneticCode Palpate() {
		System.out.println("Palpate(): GeneticCode");
		return geneticCode;
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	@Override
	public GeneticCode GetCollectable() {
		System.out.println("GetCollectable(): GeneticCode");
		return this.Palpate();
	}
}
