package main;

public class Timer {
    private Steppable stepable;

    public void Tick(){
        stepable.Step();
    }
}
