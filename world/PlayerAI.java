package world;

import java.util.List;

public class PlayerAI extends CreatureAI {

    public PlayerAI(Creature creature, List<String> messages) {
        super(creature);
    }

    public void onEnter(int x, int y, Tile tile) {
        if (tile.isGround()) {
            creature.setX(x);
            creature.setY(y);
        } else if (tile.isDiggable()) {
        }
    }
}

