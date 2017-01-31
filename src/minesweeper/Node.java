package minesweeper;

public class Node {

    Node ul, u, ur;
    Node l, r;
    Node dl, d, dr;
    int v;
    boolean hidden;
    String memes = "⁘▢□☐   ⚑ ⌖";
    @Override
    public String toString() {
        return "Node{" + "ul=" + ul + ", u=" + u + ", ur=" + ur + ", l=" + l + ", r=" + r + ", dl=" + dl + ", d=" + d + ", dr=" + dr + '}';
    }

    Node() {
        v = 0;
        hidden = true;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setUl(Node ul) {
        this.ul = ul;
    }

    public void setU(Node u) {
        this.u = u;
    }

    public void setUr(Node ur) {
        this.ur = ur;
    }

    public void setL(Node l) {
        this.l = l;
    }

    public void setR(Node r) {
        this.r = r;
    }

    public void setDl(Node dl) {
        this.dl = dl;
    }

    public void setD(Node d) {
        this.d = d;
    }

    public void setDr(Node dr) {
        this.dr = dr;
    }

    public Node getUl() {
        return ul;
    }

    public Node getU() {
        return u;
    }

    public Node getUr() {
        return ur;
    }

    public Node getL() {
        return l;
    }

    public Node getR() {
        return r;
    }

    public Node getDl() {
        return dl;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Node getD() {
        return d;
    }

    public Node getDr() {
        return dr;
    }

}
