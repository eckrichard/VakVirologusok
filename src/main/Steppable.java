package main;

import java.util.Timer;

public interface Steppable {
	public Timer timer = new Timer();
	public void Step();
}
