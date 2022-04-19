package main;

import java.util.ArrayList;

public class Axe extends ProtectiveGear{
    private boolean usable;

    public Axe(String name){
        super(name);
        usable = true;
    }

    @Override
    public void takeAway(Virologist v) {
        v.getBag().Discard(this);
        ArrayList<ProtectiveGear> wear = v.getWear();
        for(ProtectiveGear pg : wear){
            if(this == pg){
                v.Unwear(this);
            }
        }
    }

    @Override
    public void setAttribute(Virologist v) {
        virologist = v;
    }

    @Override
    public void Wear() { }

    private void Attack(Virologist v){
        v.Die();
        usable = false;
    }

    public void Destroy(){
        this.takeAway(this.virologist);
    }

    public void Use(Virologist v, Agent a){
        this.Attack(v);
    }

    public boolean getUsable(){
        return usable;
    }
}
