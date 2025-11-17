public class Vertex_DD {
    public int x;
    public int y;
    public Vertex_DD predecessor;

    public int data;

    public Vertex_DD(int x, int y, int data) {this.x = x; this.y = y; this.data = data;}

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
