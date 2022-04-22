package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A játékosok által irányított karakter. A feladata a virológus tevékenységeinek elvégzése
 */
public class Virologist {
	private long codeCount = 0;
	private double agentResistance;
	private boolean throwBackAvailable;
	private boolean untouchbale;
	private ArrayList<Effects> effects;
	private ArrayList<GeneticCode> geneticCodes;
	private ArrayList<ProtectiveGear> wear;
	private Bag bag;
	private Tile tile;

	/**
	 * A virológus egyik konstruktora
	 * @param tile a mező amin tartózkodik
	 * @param bag a táska, amitben tárolja a védőfelszerelését, anyagait és az ágenseket
	 */
	public Virologist(Tile tile, Bag bag){
		codeCount = 0;
		throwBackAvailable = false;
		agentResistance = 0;
		untouchbale = false;
		wear = new ArrayList<ProtectiveGear>();
		geneticCodes = new ArrayList<GeneticCode>();
		effects = new ArrayList<Effects>();
		this.bag = bag;
		this.tile = tile;
	}

	/**
	 * A virológus az egyik mezőről a másikra lép
	 * @param n A mező száma amire lép a virológus
	 */
	public void Move(long n) {
		Tile t2 = tile.GetNeighbor(n);
		tile.Remove(this);
		tile.Accept(this);
		tile = t2;
	}

	/**
	 * A virológus érinthetetlen effektjét adja vissza
	 */
	public boolean getUntouchable()
	{
		return untouchbale;
	}

	/**
	 * A virológus egy ágenst használ
	 * @param v A virológus akire az ágenst felkenték
	 * @param a A felkent ágens
	 */
	public void UseAgent(Virologist v, Agent a) {
		if(v.getUntouchable()){
			v.HitByAgent(a);
		}
	}

	/**
	 * Védőfelszerelést vesz el egy
	 * virológustól, ez meghívja a másik virológus giveGear metódusát, ha van elég hely a virológus
	 * táskájában
	 * @param from melyik virológustól
	 * @param g melyik felszerelést
	 */
	public void TakeGear(Virologist from, ProtectiveGear g) {
		from.giveGear(g);
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()){
			bag.Add(g);
		}
	}

	/**
	 * A genetikai kódot megtanulja (bekerül az ismert genetikai kódok listájába)
	 * @param g Az a genetikai kód, amit megismer
	 */
	public void LearnCode(GeneticCode g) {
		this.geneticCodes.add(g);
		codeCount++;
	}

	/**
	 * A védőfelszerelést felvesz a óvóhelyen. Meghívja a mező
	 * GetCollectable metódusát, ha van elég hely a táskájában
	 */
	public void CollectProtectiveGear() {
		ProtectiveGear pg = (ProtectiveGear) tile.GetCollectable();
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()){
			bag.Add(pg);
		}
	}

	/**
	 * Letapogat egy genetikai kódot
	 */
	public void PalpateWall() {
		GeneticCode geneticCode = (GeneticCode) tile.GetCollectable();
		if(!(geneticCodes.contains(geneticCode))){
			this.LearnCode(geneticCode);
		}
	}

	/**
	 * Védőfelszerelés felvételének elkezdése
	 * @param g az a védőfelszerelés, amit felvesz
	 */
	public void Wear(ProtectiveGear g) {
		if(!wear.contains(g)){
			wear.add(g);
			g.setVirologist(this);
			g.Wear();
		}
	}

	/**
	 * A virológust felkenték egy ágensel
	 * @param which A felkent ágens
	 */
	public void HitByAgent(Agent which) {
		Random rand = new Random();
		double attacppower = (double) rand.nextInt(1000) / 10.0;
		if(attacppower > agentResistance){
			which.setStatus(1, this);
		}
	}

	/**
	 * A virológus odaadja a védőfelszerelését egy másik virológusnak.
	 * Meghívja a táska megfelelő Discard metódusát
	 * @param g a felszerelés
	 */
	public void giveGear(ProtectiveGear g) {
		bag.Discard(g);
	}

	/**
	 * A virológus felveszi az anyagot. Ha elég hely van a táskájában, akkor
	 * meghívja a táska Add metódusát
	 */
	public void CollectMaterial() {
		Material material = (Material) tile.GetCollectable();
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()) {
			bag.Add(material);
			tile.setCollectable(null);
		}
	}

	/**
	 * Ágenst add a táskához
	 * @param a Az az ágens, amit hozzáadunk
	 */
	public void addAgent(Agent a) {
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()){
			bag.Add(a);
		}
	}

	/**
	 * Visszaadja a táskáját
	 * @return a táska
	 */
	public Bag getBag() {
		return bag;
	}

	/**
	 * Visszaadja, a viselt tárgyakat
	 * @return a viselt tárgyak
	 */
	public ArrayList<ProtectiveGear> getWear(){
		return wear;
	}

	/**
	 * Levesz egy védőfelszerelést
 	 * @param g melyiket veszi le
	 */
	public void Unwear(ProtectiveGear g){
		wear.remove(g);
	}

	/**
	 * Meghal a virológus, eltávolítjuk a mezőről, amin van, ezt a Tile remove
	 * metódusával és a tile értékének null-ra állításával éri el
	 */
	public void Die() {
		tile.Remove(this);
		tile = null;
	}

	/**
	 * Használja az anyagokat amiknek a mennyiségét
	 * a paraméterben kapja. Ha van ennyi anyaga akkor true-val tér vissza ha nincs akkor false-szal
	 * @param neededMaterials a szükséges anyagok
	 * @return van-e elég anyag a létrehozáshoz
	 */
	public boolean useMaterials(ArrayList<Material> neededMaterials) {
		if(bag.getMaterials().containsAll(neededMaterials)){
			bag.getMaterials().removeAll(neededMaterials);
			return true;
		}
		return false;
	}

	/**
	 * Visszaadja, hogy melyik mezőn áll
	 * @return a mező
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * Egy effectet add az effects listához
	 * @param e az új effect
	 */
	public void addEffect(Effects e){
		effects.add(e);
	}

	/**
	 * Visszaadja az ismert genetikai kódokat
	 * @return az ismert kódok
	 */
	public ArrayList<GeneticCode> getGeneticCodes(){
		return geneticCodes;
	}

	/**
	 * Beállítja a kódok számát
	 * @param n az új szám
	 */
	public void setCodeCount(int n){
		codeCount = n;
	}

	/**
	 * Beállítja az ágens ellenállást
	 * @param agentResistance az új ellenállás
	 */
	public void setAgentResistance(double agentResistance) {
		this.agentResistance = agentResistance;
	}

	/**
	 * Beállítja, hogy képes-e az ágens visszadobásra
	 * @param throwBackAvailable igen vagy nem
	 */
	public void setThrowBackAvailable(boolean throwBackAvailable) {
		this.throwBackAvailable = throwBackAvailable;
	}

	/**
	 * Visszaadja, hogy mennyire áll ellen az ágenseknek
	 * @return az ágensellenállás
	 */
	public double getAgentResistance() {
		return agentResistance;
	}

	/**
	 * Beállítja az érinthetetlenséget
	 * @param untouchbale igaz vagy hamis, hogy érinthetetlen
	 */
	public void setUntouchbale(boolean untouchbale) {
		this.untouchbale = untouchbale;
	}
}
