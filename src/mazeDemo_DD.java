import javax.swing.plaf.IconUIResource;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

public class mazeDemo_DD {

    static int[][] maze;
    static AbstractMap.SimpleEntry<Integer, Integer> startPoint = new AbstractMap.SimpleEntry<>(0, 0);
    static AbstractMap.SimpleEntry<Integer, Integer> endPoint = new AbstractMap.SimpleEntry<>(0, 0);

    public static void main (String[] args) throws FileNotFoundException {
        maze = readMazeFile("maze.txt");

        printMaze(maze);
        Graph_DD g = populateGraph(maze);

        DFS(g, g.getVertex(startPoint.getKey(), startPoint.getValue()), g.getVertex(endPoint.getKey(), endPoint.getValue()));
    }

    public static int[][] readMazeFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<ArrayList<Integer>> mazeArr = new ArrayList<>();

        Scanner sc = new Scanner(file);

        int y = 0;
        while (sc.hasNextLine()) {
            mazeArr.add(new ArrayList<>());
            String curLine = sc.nextLine();
            int x = 0;
            for (char c : curLine.toCharArray()) {
                    if (c == 'S') {
                        startPoint = new AbstractMap.SimpleEntry<>(x, y);
                        mazeArr.get(y).add(0);
                    }
                    else if (c == 'E'){
                        endPoint = new AbstractMap.SimpleEntry<>(x, y);
                        mazeArr.get(y).add(0);
                    }
                    else {
                        mazeArr.get(y).add(Character.getNumericValue(c));
                    }
                    x++;
            }
            y++;
        }

        int[][] returnArr = new int[mazeArr.size()][mazeArr.getFirst().size()];

        for (y = 0; y < mazeArr.size(); y++) {
            for (int x = 0; x < mazeArr.get(y).size(); x++) {
                returnArr[y][x] = mazeArr.get(y).get(x);
            }
        }

        return returnArr;
    }

    static Graph_DD populateGraph(int[][] m) {
        Graph_DD g = new Graph_DD();

        //add vertices
        for (int y = 0; y < m.length; y++) {
            for (int x = 0; x < m[0].length; x++) {
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

    static void printMaze(int[][] maze) {
        for (int y = 0; y < maze.length; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < maze[0].length; x++) {
                line.append(maze[y][x]);
            }
            System.out.println(line);
        }
    }

    static void DFS(Graph_DD g, Vertex_DD startV, Vertex_DD endV) {
        Stack<Vertex_DD> vertexStack = new Stack<Vertex_DD>();
        HashSet<Vertex_DD> visitedSet = new HashSet<Vertex_DD>();

        vertexStack.push(startV);

        while (vertexStack.size() > 0) {
            Vertex_DD currentVertex = vertexStack.pop();

            if (!visitedSet.contains(currentVertex)) {
                visitedSet.add(currentVertex);
                for (Vertex_DD v: g.getAdjVertices(currentVertex)) {

                    if (!visitedSet.contains(v)) {
                        v.predecessor = currentVertex;
                    }

                    vertexStack.push(v);
                }
            }

            ArrayList<Vertex_DD> path = new ArrayList<>();

            if (currentVertex.equals(endV)) {
                Vertex_DD v = currentVertex;
                while (v.predecessor != null) {
                    path.add(v);
                    v = v.predecessor;
                }
                path.add(startV);

                Collections.reverse(path);
                for (Vertex_DD vert : path) {
                    maze[vert.y][vert.x] = 5;
                    System.out.println(vert);
                }

                printMaze(maze);

                return;
            }
        }
        System.out.println("Could not find exit");
    }

}
