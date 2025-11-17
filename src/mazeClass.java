import java.util.*;

public class mazeClass {

    static int[][] maze;


    public static void main (String[] args) {
        maze = init(10);

        printMaze(maze);
        Graph g = populateGraph(maze);

        DFS(g, g.getVertex(0, 0), g.getVertex(9, 0));
    }

    static Graph populateGraph(int[][] m) {
        Graph g = new Graph();

        //add vertices
        for (int y = 0; y < m.length; y++) {
            for (int x = 0; x < m.length; x++) {
                g.addVertex(x, y, m[y][x]);
            }
        }


        for (int y = 0; y < m.length; y++) {
            for (int x = 0; x < m[0].length; x++) {
                if (m[y][x] == 0) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            try {
                                if (m[y+i][x+j] == 0 && (j != 0 || i != 0)) { //if any adjacent tiles are empty
                                    g.addEdge(g.getVertex(x, y), g.getVertex(x+j, y+i));
                                }
                            }
                            catch (IndexOutOfBoundsException _) {

                            }
                        }
                    }

                }
            }
        }

        /*
        for (Vertex v : g.getAllVertices()) {
            System.out.println(v + " adjacent: " + g.getAdjVertices(v));
        }*/

        return g;
    }

    static int[][] init(int size) {
        int[][] arr = new int[size][size];

        /*for (int y = 0; y < size - 1; y++) { //top to bottom & left to right
            for (int x = 0; x < size - 1; x++) {
                if (x == 0) {
                    arr[y][x] = 1;
                }
                if (y == 0) {
                    arr[y][x] = 1;
                }
                if (x == 5) {
                    arr[y][x] = 1;
                }
                arr[3][5] = 0;
            }
        }*/

        //setting the walkable tiles in the example map
        //Row 0
        arr[0][1] = 1;
        //Row 1
        arr[1][1] = 1;
        arr[1][4] = 1;
        arr[1][5] = 1;
        arr[1][6] = 1;
        arr[1][7] = 1;
        arr[1][8] = 1;
        //Row 2
        arr[2][1] = 1;
        arr[2][4] = 1;
        arr[2][8] = 1;
        //Row 3
        arr[3][1] = 1;
        arr[3][6] = 1;
        arr[3][7] = 1;
        arr[3][8] = 1;
        //Row 4
        arr[4][1] = 1;
        arr[4][3] = 1;
        arr[4][4] = 1;
        arr[4][5] = 1;
        arr[4][8] = 1;
        //Row 5
        arr[5][1] = 1;
        arr[5][3] = 1;
        arr[5][8] = 1;
        //Row 6
        arr[6][1] = 1;
        arr[6][3] = 1;
        arr[6][5] = 1;
        arr[6][6] = 1;
        arr[6][7] = 1;
        arr[6][8] = 1;
        //Row 7
        arr[7][1] = 1;
        arr[7][3] = 1;
        arr[7][5] = 1;
        arr[7][8] = 1;
        //Row 8
        arr[8][1] = 1;
        arr[8][3] = 1;
        arr[8][4] = 1;
        arr[8][5] = 1;
        arr[8][6] = 1;
        arr[8][8] = 1;
        arr[8][9] = 1;

        return arr;
    }

    static void printMaze(int[][] maze) {
        for (int y = 0; y < maze.length; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < maze.length; x++) {
                line.append(maze[y][x]);
            }
            System.out.println(line);
        }
    }

    static void DFS(Graph g, Vertex startV, Vertex endV) {
        Stack<Vertex> vertexStack = new Stack<Vertex>();
        HashSet<Vertex> visitedSet = new HashSet<Vertex>();

        vertexStack.push(startV);

        while (vertexStack.size() > 0) {
            Vertex currentVertex = vertexStack.pop();

            if (!visitedSet.contains(currentVertex)) {
                visitedSet.add(currentVertex);
                for (Vertex v: g.getAdjVertices(currentVertex)) {

                    if (!visitedSet.contains(v)) {
                        v.predecessor = currentVertex;
                    }

                    vertexStack.push(v);
                }
            }

            ArrayList<Vertex> path = new ArrayList<>();

            if (currentVertex.equals(endV)) {
                Vertex v = currentVertex;
                while (v.predecessor != null) {
                    path.add(v);
                    v = v.predecessor;
                }
                path.add(startV);

                Collections.reverse(path);
                for (Vertex vert : path) {
                    System.out.println(vert);
                }

                return;
            }
        }
        System.out.println("Could not find exit");
    }

}
