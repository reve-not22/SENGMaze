//this counts a achange

//this is just the grid
class Grid
{
    static int[][] gridArray = new int[10][10];

    static void MakeBasicGrid()
    {
        for(int x = 0; x < gridArray.length; x++)
        {
            for(int y = 0; y < gridArray[x].length; y++)
            {
                gridArray[x][y] = 0;//set all values in grid to unwalkable
            }
        }
    }

    static void AddPaths()
    {
        //setting the walkable tiles in the example map
        //Row 0
        gridArray[0][1] = 1;//starting point
        //Row 1
        gridArray[1][1] = 1;
        gridArray[1][4] = 1;
        gridArray[1][5] = 1;
        gridArray[1][6] = 1;
        gridArray[1][7] = 1;
        gridArray[1][8] = 1;
        //Row 2
        gridArray[2][1] = 1;
        gridArray[2][4] = 1;
        gridArray[2][8] = 1;
        //Row 3
        gridArray[3][1] = 1;
        gridArray[3][6] = 1;
        gridArray[3][7] = 1;
        gridArray[3][8] = 1;
        //Row 4
        gridArray[4][1] = 1;
        gridArray[4][2] = 1;
        gridArray[4][3] = 1;
        gridArray[4][4] = 1;
        gridArray[4][5] = 1;
        gridArray[4][8] = 1;
        //Row 5
        gridArray[5][1] = 1;
        gridArray[5][3] = 1;
        gridArray[5][8] = 1;
        //Row 6
        gridArray[6][1] = 1;
        gridArray[6][3] = 1;
        gridArray[6][5] = 1;
        gridArray[6][6] = 1;
        gridArray[6][7] = 1;
        gridArray[6][8] = 1;
        //Row 7
        gridArray[7][1] = 1;
        gridArray[7][3] = 1;
        gridArray[7][5] = 1;
        gridArray[7][8] = 1;
        //Row 8
        gridArray[8][1] = 1;
        gridArray[8][3] = 1;
        gridArray[8][4] = 1;
        gridArray[8][5] = 1;
        gridArray[8][6] = 1;
        gridArray[8][8] = 1;
        gridArray[8][9] = 1;//finish point
        //row9 was all unwalkable

    }

    static void InitGrid()
    {
        MakeBasicGrid();
        AddPaths();

    }

    public static void main(String[] args)
    {
        Graph_Brett graph =  new Graph_Brett();
        int start = 0 * 10 + 1;
        int end = 8 * 10 + 9;

        InitGrid();
        for(int i = 0; i < gridArray.length; i++)
        {
            System.out.println("");
            for(int j = 0; j < gridArray[i].length; j++)
            {
                System.out.print(gridArray[i][j]);
                
            }
            
        }
        System.out.println("");
        graph.BFS(start, end, gridArray);
    }





}