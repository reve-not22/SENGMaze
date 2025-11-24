import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph_DD {

    private HashMap<Vertex_DD, ArrayList<Vertex_DD>> adjacentVertices;

    public Graph_DD()
    {
        adjacentVertices = new HashMap<>();
    }

    public Vertex_DD addVertex(int x, int y, int data) {
        Vertex_DD newVertex = new Vertex_DD(x, y, data);

        adjacentVertices.put(newVertex, new ArrayList<Vertex_DD>());

        return newVertex;
    }

    public void addEdge(Vertex_DD a, Vertex_DD b) {
        if (!adjacentVertices.get(a).contains(b)) {
            adjacentVertices.get(a).add(b);
            adjacentVertices.get(b).add(a);
        }
    }

    public Vertex_DD getVertex(int x, int y) {
        for (Vertex_DD v : getAllVertices()) {
            if (v.x == x && v.y == y) {
                return v;
            }
        }
        return null;
    }

    public Collection<Vertex_DD> getAdjVertices(Vertex_DD v) {
        return adjacentVertices.get(v);
    }

    public Collection<Vertex_DD> getAllVertices() {
        return adjacentVertices.keySet();
    }
}
