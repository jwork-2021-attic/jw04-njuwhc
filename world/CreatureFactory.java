package world;

import java.util.List;

import asciiPanel.AsciiPanel;

public class CreatureFactory {

    private World world;

    public CreatureFactory(World world) {
        this.world = world;
    }

    public Creature newPlayer(List<String> messages) {
        Creature player = new Creature(this.world, (char)2, AsciiPanel.brightWhite);
        world.addAtEmptyLocation(player);
        new PlayerAI(player, messages);
        return player;
    }


}
