package main;

import java.util.ArrayList;

public class BearDanceAgent extends Agent{

    private long duration;

    public BearDanceAgent(ArrayList<Material> m, String name){
        super(m,name);
        duration = Long.MAX_VALUE;
    }

    @Override
    public void setStatus(long n, Virologist v) {
        BearDance bearDance = new BearDance();
        bearDance.setTimeEffected(n);
        v.addEffect(bearDance);
    }

    public long getDuration(){
        return duration;
    }

    public void setDuration(long n){
        duration = n;
    }
}
