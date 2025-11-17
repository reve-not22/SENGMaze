import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph {

    private HashMap<Vertex, ArrayList<Vertex>> adjacentVertices;

    public Graph()
    {
        adjacentVertices = new HashMap<>();
    }


    public Vertex addVertex(int x, int y, int data) {
        Vertex newVertex = new Vertex(x, y, data);

        adjacentVertices.put(newVertex, new ArrayList<Vertex>());

        return newVertex;
    }

    public void addEdge(Vertex a, Vertex b) {
        if (!adjacentVertices.get(a).contains(b)) {
            adjacentVertices.get(a).add(b);
            adjacentVertices.get(b).add(a);
        }
    }

    public Vertex getVertex(int x, int y) {
        for (Vertex v : getAllVertices()) {
            if (v.x == x && v.y == y) {
                return v;
            }
        }
        return null;
    }

    public Collection<Vertex> getAdjVertices(Vertex v) {
        return adjacentVertices.get(v);
    }

    public Collection<Vertex> getAllVertices() {
        return adjacentVertices.keySet();
    }
}
