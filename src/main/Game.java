package main;

public class Game {

	private Map map;
	private boolean gaímerunning;

	public Game(){
		map = new Map();
	}

	public void startGame() {
		map.Build();
		gaímerunning = true;
	}
	
	public void endGame() {
		gaímerunning = false;
	}
}
