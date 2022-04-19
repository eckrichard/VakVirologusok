package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public void giveGear(ProtectiveGear g) {
		bag.Discard(g);
	}

	public void CollectMaterial() {
		Material material = (Material) tile.GetCollectable();
		if(bag.getMaterials().size() + bag.getAgents().size() + bag.getProtectiveGears().size() < bag.getSize()) {
			bag.Add(material);
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

	public Bag getBag() {
		return bag;
	}

	public ArrayList<ProtectiveGear> getWear(){
		return wear;
	}
	
	public void Unwear(ProtectiveGear g){
		wear.remove(this);
	}

	public void Die() {
		tile.Remove(this);
		tile = null;
	}

	public boolean useMaterials(ArrayList<Material> neededMaterials) {
		if(bag.getMaterials().containsAll(neededMaterials)){
			return true;
		}
		return false;
	}

	public Tile getTile() {
		return tile;
	}

	public void addEffect(Effects e){
		effects.add(e);
	}

	public ArrayList<GeneticCode> getGeneticCodes(){
		return geneticCodes;
	}

	public void setCodeCount(int n){
		codeCount = n;
	}

	public void setAgentResistance(double agentResistance) {
		this.agentResistance = agentResistance;
	}

	public void setThrowBackAvailable(boolean throwBackAvailable) {
		this.throwBackAvailable = throwBackAvailable;
	}

	public double getAgentResistance() {
		return agentResistance;
	}

	public void setUntouchbale(boolean untouchbale) {
		this.untouchbale = untouchbale;
	}
}
