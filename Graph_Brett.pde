
class Node
{
    Node(int d) {
        data = d;
    }

    Node next;
    int data;
}

class SimpleLinkedList //my version of a linked list
{
/*
    @Override
    public String toString() 
    {
        StringBuilder buildString = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null)// grab the rest
        {
            buildString.append(currentNode.data);
            currentNode = currentNode.next;
        }

        return buildString.toString();
    }
*/
    public void add(int n) 
    {
        Node newNode = new Node(n);
        // if no node, make a node
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            // but what if it's not empty!
            Node lastNode = head;
            while (lastNode.next != null)// searches to end
            {
                // swaps
                lastNode = lastNode.next;
            }
            lastNode.next = newNode; // adds
        }

    }

    public int top(int index) // searches and stores in currentNode, head is unaffected, deleting nothing
    {
        Node currentNode = head;

        int i = 0;

        while (currentNode != null) {
            if (i == index) // the last index
            {
                return currentNode.data;
            }
            currentNode = currentNode.next;
            i++;

        }
        return currentNode.data;

    }

    public int remove(int index) 
    {
        Node previousNode = null;
        Node currentNode = head;
        int i = 0;

        if (index == 0 && currentNode != null) 
        {
            int p = currentNode.data;
            head = currentNode.next; // this says hey, currentNode.next is empty(index = 0), set head to empty,
                                     // essentially deleting that data,
                                     // above catches data before deletion
            return p;
        }

        while (currentNode != null) {

            if (i == index) 
            {
                previousNode.next = currentNode.next;
                return currentNode.data;// return the stack on the top!
            }
            else 
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;

            }
        }

        if (currentNode == null) 
        {
            //System.out.println("Index to remove not found! ");

        }

        return head.data;

    }

    public boolean isEmpty() 
    {
        Node currentNode = head;
        if (currentNode == null) 
        {
            return true;
        }
        return false;
    }

    Node head;

}


interface Simple 
{

    public void push(int c);

    public int pop();

    public int peek();

    public boolean isEmpty();

}

class MyLinkedList implements Simple //think of this as a stack
{
    MyLinkedList() 
    {
        list = new SimpleLinkedList();
    }

    public void push(int c) 
    {
        list.add(c);
        index++;
    }

    public int pop() 
    {

        int p = list.remove(0);

        index--;
        return p;

    }

    public int peek() 
    {
        return list.top(index);
    }

    public boolean isEmpty() 
    {
        return list.isEmpty();
    }
/*
    @Override
    public String toString() 
    {
        return list.toString();
    }
*/
    SimpleLinkedList list;
    int index = 0;


}


class Graph_Brett
{

    ArrayList<Integer> visitedOrder = new ArrayList<Integer>();
    ArrayList<Integer> finalPath = new ArrayList<Integer>();

    boolean bfsFinished = false;
    boolean pathReady = false;
    
    int visitedStep = 0;
    int pathStep = 0;

  
    void BFS(int source, int target, theBox[][] gridArray)//bfs implmenting a queue
    {
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        MyLinkedList queue = new MyLinkedList();
        boolean[] visited = new boolean[rows * cols];
        int parrent[] = new int[rows * cols];

        for(int i = 0; i < parrent.length; i++)
        {
            parrent[i] = -1;//initialize no parrents
        }

        queue.push(source);
        visited[source] = true;

        boolean found = false;

        while(!queue.isEmpty())
        {
            int current = queue.pop();
            int row = current / cols;
            int col = current % cols;
            visitedOrder.add(current);

            if(current == target)
            {
                found = true;
                //break;// end 
            }

            //print("Visited: (" + row + ", " + col + ")");

            // Up, Down, Left, Right
            int[][] directions = {
                { -1,  0}, //up
                {0,  1}, //right
                { 1,  0}, //down
                { 0, -1}  //left  
            };

            for (int[] direction : directions)
            {
                int numRow = row + direction[0];
                int numCol = col + direction[1];

                if (numRow >= 0 && numRow < rows && numCol >= 0 && numCol < cols)
                {
                    if (gridArray[numRow][numCol].value == 1)
                    {
                        int neighbor = numRow * cols + numCol;

                        if (!visited[neighbor])
                        {
                            visited[neighbor] = true;
                            parrent[neighbor] = current;
                            queue.push(neighbor);
                        }
                    }
                }
            }
        }

        if(!found)
        {
            //print("No Path found");
            return;
        }

        reconstructPath(source, target, parrent, rows, cols, gridArray);

    }


    void reconstructPath(int start, int end, int[] parent, int rows, int cols, theBox[][] grid)
    {
        // build path backwards
        java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
        finalPath.clear();
        int current = end;
        while (current != -1) {
            path.add(current);
            finalPath.add(current);
            current = parent[current];
        }

        // reverse so it's start → end
        java.util.Collections.reverse(path);
        java.util.Collections.reverse(finalPath);

        // make a visual grid
        //char[][] visual = new char[rows][cols];

        

    }


}
