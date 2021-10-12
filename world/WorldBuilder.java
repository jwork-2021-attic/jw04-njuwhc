package world;                                                                        

public class WorldBuilder {

    private int width;
    private int height;
    private Tile[][] tiles;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
    }

    public World build() {
        return new World(tiles);
    }

    private WorldBuilder randomizeTiles() {
        
        MazeGenerator mazeGenerator = new MazeGenerator(30);
        mazeGenerator.generateMaze();

        for (int width = 0; width < this.width; width++) {
            for (int height = 0; height < this.height; height++) {
                //switch (mazeGenerator.getMaze()[width][height]) {
                switch (mazeGenerator.getMaze()[height][width]) {
                    case 1:
                        tiles[width][height] = Tile.FLOOR;
                        break;
                    case 0:
                        tiles[width][height] = Tile.WALL;
                        break;
                }
            }
        }
        return this;
    }

    

    public WorldBuilder makeCaves() {
        return randomizeTiles();
    }
}
