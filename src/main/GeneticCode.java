package main;

public class GeneticCode {
	private Agent agent;
	public void addCode(Virologist v) {
	}

	/**
	 * A genetikai kód kontruktora
	 * @param a Az ágens, amit tartalmaz a genetikai kód
	 */
	public GeneticCode(Agent a){
		agent = a;
	}

	/**
	 * Létrehozza az ágenst és visszatér az eredményével,
	 * ami lehet sikeres létrehozatal vagy sikertelen.
	 * @param v A virológus, aki végzi a tevékenységet
	 * @param b Arra a kérdésre a válasz, hogy van-e elegendő anyga
	 * @return sikeres vagy sikretelen volt az ágens létrehozása
	 */
	public boolean CreateAgent(Virologist v, boolean b) {
		System.out.println("CreateAgent(v: Virologist): bool");
		v.useMaterials(null, null, b);
		if(b == true){
			v.addAgent(agent);
		}
		return b;
	}
}
