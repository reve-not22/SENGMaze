public class Vertex {
    public int x;
    public int y;
    public Vertex predecessor;

    public int data;

    public Vertex(int x, int y, int data) {this.x = x; this.y = y; this.data = data;}

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
