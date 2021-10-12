package com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

//import com.anish.elfs.BubbleSorter;
import com.anish.elfs.QuickSorter;
import com.anish.elfs.Elf;
import com.anish.elfs.World;

import asciiPanel.AsciiPanel;

import java.util.Random;

public class WorldScreen implements Screen {

    private World world;
    private Elf[][] elfs;
    private Elf[] elfs_line;
    String[] sortSteps;
    Random random = new Random();

    public WorldScreen() {
        world = new World();
        int x=10;
        int y=10;

        elfs = new Elf[16][16];
        elfs_line = new Elf[256];

        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                elfs[i][j] = new Elf(color,color.getRGB() & 0x00ffffff,world);
                //elfs[i][j] = new Elf(color,getRank(color),world);
                //elfs[i][j] = new Elf(color,color.getRed()*299+color.getGreen()*587+color.getBlue()*114,world);
            }
        }

        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
               world.put(elfs[i][j],x,y);
               x+=2;
            }
            x=10;
            y+=2;
        }

        elfs_line = twoD2OneD(elfs);
        


        //BubbleSorter<Elf> b = new BubbleSorter<>();
        QuickSorter<Elf> b = new QuickSorter<>();
        b.load(elfs_line);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private Elf[] twoD2OneD(Elf[][] elfs){
        Elf[] elfs_line = new Elf[256];
        int count=0;
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                elfs_line[count++] = elfs[i][j];
            }
        }
        return elfs_line;
    }


    private void execute(Elf[][] elfs, String step) {
        String[] couple = step.split("<->");
        getElfByRank(elfs, Integer.parseInt(couple[0])).swap(getElfByRank(elfs, Integer.parseInt(couple[1])));
    }

    private Elf getElfByRank(Elf[][] elfs, int rank) {
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                if (elfs[i][j].getRank() == rank) {
                    return elfs[i][j];
                    }
                }
            }
        return null;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        if (i < this.sortSteps.length) {
            this.execute(elfs, sortSteps[i]);
            i++;
        }

        return this;
    }


}

