package main;

public class BearDance extends Effects {

    private long effected;

    public BearDance(){
        effected = 0;
    }

    @Override
    public void Step() {
        if(virologist.getTile() != null) {
            effected--;
        }
    }

    @Override
    public void setTimeEffected(long n) {
        effected = n;
    }

    public long getTime() {
        return effected;
    }
}
