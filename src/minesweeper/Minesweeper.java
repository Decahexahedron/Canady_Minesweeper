package minesweeper;

import java.util.*;

public class Minesweeper {

    public static final int h = 9;
    public static final int w = 9;

    public static void main(String[] args) {
        init();
        numCheck();
        print();
        while (true) {
            input();
        }
    }
    static Node a0, a1, a2, a3, a4, a5, a6, a7, a8;
    static Node b0, b1, b2, b3, b4, b5, b6, b7, b8;
    static Node c0, c1, c2, c3, c4, c5, c6, c7, c8;
    static Node d0, d1, d2, d3, d4, d5, d6, d7, d8;
    static Node e0, e1, e2, e3, e4, e5, e6, e7, e8;
    static Node f0, f1, f2, f3, f4, f5, f6, f7, f8;
    static Node g0, g1, g2, g3, g4, g5, g6, g7, g8;
    static Node h0, h1, h2, h3, h4, h5, h6, h7, h8;
    static Node i0, i1, i2, i3, i4, i5, i6, i7, i8;

    static Node[][] a = {
        {a0, a1, a2, a3, a4, a5, a6, a7, a8},
        {b0, b1, b2, b3, b4, b5, b6, b7, b8},
        {c0, c1, c2, c3, c4, c5, c6, c7, c8},
        {d0, d1, d2, d3, d4, d5, d6, d7, d8},
        {e0, e1, e2, e3, e4, e5, e6, e7, e8},
        {f0, f1, f2, f3, f4, f5, f6, f7, f8},
        {g0, g1, g2, g3, g4, g5, g6, g7, g8},
        {h0, h1, h2, h3, h4, h5, h6, h7, h8},
        {i0, i1, i2, i3, i4, i5, i6, i7, i8}
    };

    static void input() {
        Scanner s = new Scanner(System.in);
        int x, y;
        boolean flagnext, cinput;
        String input;
        System.out.println("Flag or unflag a coordinate? (y/n)");
        input = s.nextLine();
        if (input.equalsIgnoreCase("y")) {
            flagnext = true;
            cinput = true;
        } else if (input.equalsIgnoreCase("n")) {
            flagnext = false;
            cinput = true;
        } else {
            flagnext = false;
            cinput = false;
        }
        if (cinput) {
            System.out.print("Please input an X value: ");
            x = s.nextInt();
            System.out.print("Please input an Y value: ");
            y = s.nextInt();
            if (flagnext) {
                if (a[x][y].isFlag()) {
                    a[x][y].setFlag(false);
                } else {
                    a[x][y].setFlag(true);
                }
            } else {
                a[x][y].setHidden(false);
            }
        }

    }

    static void print() {
        System.out.println("   1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < h; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < w; j++) {
                if (a[i][j].isHidden()) {
                    System.out.print("◼");
                } else {
                    if (a[i][j].isFlag()) {
                        System.out.print("⚑");
                    } else if (a[i][j].v == 0) {
                        System.out.print("□");
                    } else if (a[i][j].v == 10) {
                        System.out.print("≎");
                    } else {
                        System.out.print(a[i][j].v);
                    }
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void init() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = new Node();
            }
        }

        for (int t = 0; t < 13; t++) { // place mines
            int traph = (int) Math.floor(Math.random() * h);
            int trapw = (int) Math.floor(Math.random() * w);
            a[traph][trapw].setV(10);
        }

        for (int i = 0; i < h; i++) { //tail assign; height outer
            for (int j = 0; j < w; j++) { //width outer
                boolean up = false, down = false, left = false, right = false;
                if (a[i][j].v != 10) { // if not mine
                    if (i < h - 1) { //if not bottom
                        down = true;
                        a[i][j].setD(a[i + 1][j]);
                    }
                    if (j < w - 1) { //if not right
                        right = true;
                        a[i][j].setR(a[i][j + 1]);
                    }
                    if (i != 0) { //if not top
                        up = true;
                        a[i][j].setU(a[i - 1][j]);
                    }
                    if (j != 0) { //if not left
                        left = true;
                        a[i][j].setL(a[i][j - 1]);
                    }
                    if (up && left) {
                        a[i][j].setUl(a[i - 1][j - 1]);
                    }
                    if (up && right) {
                        a[i][j].setUr(a[i - 1][j + 1]);
                    }
                    if (down && left) {
                        a[i][j].setDl(a[i + 1][j - 1]);
                    }
                    if (down && right) {
                        a[i][j].setDr(a[i + 1][j + 1]);
                    }
                }
            }
        }
    }

    static void numCheck() {
        for (int i = 0; i < h; i++) { //numcheck; height outer
            for (int j = 0; j < w; j++) { //width outer
                if (a[i][j].v != 10) {
                    if (a[i][j].ul != null && a[i][j].ul.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].u != null && a[i][j].u.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].ur != null && a[i][j].ur.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].l != null && a[i][j].l.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].r != null && a[i][j].r.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].dl != null && a[i][j].dl.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].d != null && a[i][j].d.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                    if (a[i][j].dr != null && a[i][j].dr.v == 10) {
                        a[i][j].setV(a[i][j].v + 1);
                    }
                }
            }
        }
    }
}
