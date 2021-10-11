package com.anish.elfs;

import java.awt.Color;

public class Elf extends Creature implements Comparable<Elf>{
    private int rank;

    public Elf(Color color, int rank, World world) {
        super(color, (char) 2, world);
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rank);
    }

    @Override
    public int compareTo(Elf o) {
        return Integer.valueOf(this.rank).compareTo(Integer.valueOf(o.rank));
    }

    public void swap(Elf another) {
        int x = this.getX();
        int y = this.getY();
        this.moveTo(another.getX(), another.getY());
        another.moveTo(x, y);
    }

}
