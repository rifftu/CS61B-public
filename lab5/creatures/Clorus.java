package creatures;

import creatures.Plip;
import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {


    public Clorus(double e) {
        super("clorus");
        energy = e;
    }

    public Clorus() {
        this(1);
    }

    public String name() {return "Clorus";}

    public void move() {changeE(-0.03);}

    public void stay() {changeE(-0.01);}

    public Color color() {return color(34, 0, 231); }

    public void attack(Creature c) {
        changeE(c.energy());
    }

    public Clorus replicate() {
        Clorus baby = new Clorus(energy/2);
        changeE(-energy/2);
        return baby;
    }

    protected void changeE(double diff) {
        energy = Math.max(energy + diff, 0);
        energy = Math.min(energy, 2);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();
        boolean hasSpace = false;
        boolean anyPlip = false;
        // TODO
        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        // for () {...}
        for (Direction dir : neighbors.keySet()) {
            Occupant neighbor = neighbors.get(dir);
            if (neighbor.name().equals("empty")) {
                hasSpace = true;
                emptyNeighbors.add(dir);
            } else if (neighbor.name().equals("plip")) {
                anyPlip = true;
                plipNeighbors.add(dir);
            }
        }
        if (!hasSpace) {
            return new Action(Action.ActionType.STAY);
        }
        // Rule 2
        // HINT: randomEntry(emptyNeighbors)
        if(anyPlip) {
            return new Action(Action.ActionType.ATTACK,randomEntry(plipNeighbors));
        }

        if(energy >= 1.0) {
            return new Action(Action.ActionType.REPLICATE,randomEntry(emptyNeighbors));
        }
        // Rule 3

        // Rule 4
        return new Action(Action.ActionType.STAY);
    }


}
