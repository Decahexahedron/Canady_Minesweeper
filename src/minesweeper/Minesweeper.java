package minesweeper;

public class Minesweeper {

    public static void main(String[] args) {
        Node n = new Node();
        System.out.println(n.memes);
    }
    static Node a0, a1, a2, a3, a4, a5, a6, a7, a8;
    static Node b0, b1, b2, b3, b4, b5, b6, b7, b8;
    static Node c0, c1, c2, c3, c4, c5, c6, c7, c8;
    static Node d0, d1, d2, d3, d4, d5, d6, d7, d8;
    static Node e0, e1, e2, e3, e4, e5, e6, e7, e8;
    static Node f0, f1, f2, f3, f4, f5, f6, f7, f8;
    
    static Node[][] a = {
        {a0, a1, a2, a3, a4, a5, a6, a7, a8},
        {b0, b1, b2, b3, b4, b5, b6, b7, b8},
        {c0, c1, c2, c3, c4, c5, c6, c7, c8},
        {d0, d1, d2, d3, d4, d5, d6, d7, d8},
        {e0, e1, e2, e3, e4, e5, e6, e7, e8},
        {f0, f1, f2, f3, f4, f5, f6, f7, f8}
    };
}
