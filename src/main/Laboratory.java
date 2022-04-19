package main;

import java.util.Random;

public class Laboratory extends Tile {
	private GeneticCode geneticCode;
	private BearDanceAgent bearDance;

	/**
	 * A labor konstruktora
	 * @param code
	 */
	public Laboratory(GeneticCode code) {
		geneticCode = code;
		bearDance = null;
	}

	public Laboratory(GeneticCode code, BearDanceAgent bearDanceAgent) {
		geneticCode = code;
		bearDance = bearDanceAgent;
	}

	/**
	 * Megmondja, hogy a mezőn melyik genetikai kód található
	 * @return A mezőn található genetikai kód
	 */
	public GeneticCode Palpate() {
		return geneticCode;
	}

	/**
	 * Mi a mezőn található gyüjthető tárgy
	 * @return Visszaadja, hogy mit lehet felvenni
	 */
	@Override
	public GeneticCode GetCollectable() {
		return this.Palpate();
	}

	public void LaboratoryInfect(Virologist v){
		Random rand = new Random();
		double random = (double)rand.nextInt(1000) / 10.0;
		if(v.getUntouchable() == false && random > v.getAgentResistance()){
			v.HitByAgent(bearDance);
		}
	}

	public boolean isInfects(){
		if(bearDance != null){return true;}
		return false;
	}
}
