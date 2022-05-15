package Model;

import View.VirologistView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A játékosok által irányított karakter. A feladata a virológus tevékenységeinek elvégzése
 */
public class Virologist {
	private int id;
	private long codeCount = 0;
	private double agentResistance;
	private boolean throwBackAvailable;
	private boolean untouchbale;
	private ArrayList<Effects> effects;
	private ArrayList<GeneticCode> geneticCodes;
	private ArrayList<ProtectiveGear> wear;
	private Bag bag;
	private Tile tile;
	private Map map;

	private VirologistView view;

	/**
	 * A virológus egyik konstruktora
	 */
	public Virologist(){
		codeCount = 0;
		throwBackAvailable = false;
		agentResistance = 0;
		untouchbale = false;
		wear = new ArrayList<ProtectiveGear>();
		geneticCodes = new ArrayList<GeneticCode>();
		effects = new ArrayList<Effects>();
	}

	/**
	 * A virológus egyik konstruktora
	 * @param tile mező amin tartózkodik
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
		bag.setVirologist(this);
		this.tile = tile;
	}

	public void setBag(Bag b) { this.bag = b;	}
	public void setTile(Tile t) {
		this.tile = t;
		tile.Accept(this);
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void setGeneticCodes(ArrayList<GeneticCode> geneticCodes) {
		this.geneticCodes = geneticCodes;
	}

	public void setGeneticCodes(GeneticCode geneticCodes) {
		this.geneticCodes.add(geneticCodes);
	}

	/**
	 * A virológus az egyik mezőről a másikra lép
	 * @param n A mező száma amire lép a virológus
	 */
	public boolean Move(long n) {
		Tile t2 = tile.GetNeighbor(n);
		if(t2 != null && t2.virologists.size() < t2.capacity){
			tile.Remove(this);
			t2.Accept(this);
			tile = t2;
			return true;
		}
		return false;
	}

	/**
	 * A virológus érinthetetlen effektjét adja vissza
	 */
	public boolean getUntouchable()
	{
		return untouchbale;
	}
	public List<Effects> getEffects() {return this.effects;}
	/**
	 * A virológus egy ágenst használ
	 * @param v A virológus akire az ágenst felkenték
	 * @param a A felkent ágens
	 */
	public void UseAgent(Virologist v, Agent a) {
		if(!v.getUntouchable()){
			v.HitByAgent(a);
		}
		bag.Discard(a);
	}

	public void UseAgent(Virologist v, Agent a, boolean throwback) {
		if(!v.getUntouchable()){
			if(throwback){
				for(ProtectiveGear gear : v.getWear()){
					if(gear instanceof Glove){
						gear.Use(this, a);
						break;
					}
				}
			}
			else {
				v.HitByAgent(a);
			}
		}
		bag.Discard(a);
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
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize() && pg != null){
			bag.Add(pg);
			tile.setCollectable(null);
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
			g.setVirologist(this);
			g.Wear();
			wear.add(g);
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
		if(bag != null){
			bag.Discard(g);
		}
	}

	/**
	 * A virológus felveszi az anyagot. Ha elég hely van a táskájában, akkor
	 * meghívja a táska Add metódusát
	 */
	public void CollectMaterial() {
		Material material = (Material) tile.GetCollectable();
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()) {
			bag.Add(material);
		}
	}

	/**
	 * Agenst add a taskahoz
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
		map.virologistDie(this);
	}

	/**
	 * Használja az anyagokat amiknek a mennyiségét
	 * a paraméterben kapja. Ha van ennyi anyaga akkor true-val tér vissza ha nincs akkor false-szal
	 * @param neededMaterials a szükséges anyagok
	 * @return van-e elég anyag a létrehozáshoz
	 */
	public boolean useMaterials(ArrayList<Material> neededMaterials) {
		ArrayList<Material> need = new ArrayList<>();
		for(int i = 0; i < neededMaterials.size(); i++){
			for(Material material : bag.getMaterials()){
				if(material.ItemEqual(neededMaterials.get(i))){
					need.add(material);
					bag.Discard(material);
					break;
				}
			}
		}
		if(need.size() == neededMaterials.size()){
			return true;
		}
		else {
			for(Material material : need){
				bag.Add(material);
			}
			return false;
		}
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
		e.setVirologist(this);
		e.setTimeEffected(e.getTime());
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
		this.agentResistance += agentResistance;
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

	public boolean isThrowBackAvailable() {
		return throwBackAvailable;
	}

	/**
	 * Beállítja az érinthetetlenséget
	 * @param untouchbale igaz vagy hamis, hogy érinthetetlen
	 */
	public void setUntouchbale(boolean untouchbale) {
		this.untouchbale = untouchbale;
	}

	/**
	 * Visszaadja a az osztály azonosítóját
	 * @return id: azonosító szám
	 */
	public int getId(){
		return id;
	}

	public long getCodeCount() {
		return codeCount;
	}

	/**
	 * Beállítja, hogy mennyi az id-je
	 * @param id a a kapott id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Kiírja az osztály attribútumainak értékeit
	 */
	public void Print(){
		System.out.println("Virologist:");
		if(tile == null){
			System.out.println("\tnull");
		}
		else {
			System.out.print("\tgeneticCodes: ");
			if(geneticCodes.size() != 0){
				for(int i = 0; i < geneticCodes.size(); i++)
					System.out.print((geneticCodes.get(i).getId() + 1) + ". geneticCodes ");
				System.out.println("");
			}
			if(geneticCodes.size() == 0)
				System.out.println("null");
			System.out.println("\tcodeCount: " + codeCount);
			System.out.println("\tagentResistance: " + agentResistance);
			if(throwBackAvailable)
				System.out.println("\tthrowBackAvailable: true");
			if(!throwBackAvailable)
				System.out.println("\tthrowBackAvailable: false");
			System.out.println("\ttile: " + (tile.getId() + 1) + ". tile");
			if(bag == null)
				System.out.println("\tbag: null");
			if(bag != null)
				System.out.println("\tbag: " + (bag.getId() + 1) + ". bag");
			System.out.print("\twear: ");
			if(wear.size() != 0){
				for(int i = 0; i < wear.size(); i++)
					System.out.print((wear.get(i).getId() + 1) + ". ProtectiveGear ");
				System.out.println("");
			}
			if(wear.size() == 0)
				System.out.println("null");
			System.out.print("\teffects: ");
			if(effects.size() != 0){
				System.out.print((effects.get(0).getId() + 1) + ". Effects ");
				System.out.println("");
			}
			if(effects.size() == 0)
				System.out.println("null");
			System.out.println("");
		}
	}

	public void removeEffect(Effects effect) {
		this.effects.remove(effect);
	}
}
