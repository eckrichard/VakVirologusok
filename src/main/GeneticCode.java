package main;

public class GeneticCode {
	private Agent agent;

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
	 * @return sikeres vagy sikretelen volt az ágens létrehozása
	 */
	public boolean CreateAgent(Virologist v) {
		if(v.useMaterials(agent.getNeededMaterials())){
			v.addAgent(agent);
			return true;
		}
		else {
			return false;
		}
	}

	public Agent getAgent() {
		return agent;
	}
}
