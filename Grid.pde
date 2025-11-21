
//this is just the grid

class theBox
{
  theBox()
  {
  }

  void setPosition(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  void SetColour()
  {
    if (value == 0)
    {
      r = 255;
      g = 0;
      b = 0;
    }
    if (value == 1)
    {
      r = 110;
      g = 110;
      b = 110;
    }
  }



  void Update()
  {
  }

  void Draw()
  {
    fill(r, g, b);
    square(x, y, boxWidth);
  }

  int x;
  int y;

  float r;
  float g;
  float b;

  int value;

  int boxWidth = 30;
}

class Grid
{

  theBox[][] gridArray = new theBox[10][10];

  void MakeBasicGrid()
  {

    for (int x = 0; x < gridArray.length; x++)
    {

      for (int y = 0; y < gridArray[x].length; y++)
      {
        gridArray[y][x] = new theBox();
        gridArray[y][x].setPosition(x * 30, y * 30);
        gridArray[y][x].value = 0;//set all values in grid to unwalkable
      }
    }
  }
  
  void LoadFromFile(String fileName)
  {
    String[] lines = loadStrings(fileName);
    int rows = lines.length;//number of lines in the file
    int cols = lines[0].length();//number of characters in that line
    
    gridArray = new theBox[rows][cols];
    
    for(int r = 0; r < rows; r++)
    {
      for(int c = 0; c < cols; c++)
      {
        gridArray[r][c] = new theBox();
        gridArray[r][c].setPosition(c * 30, r * 30);
        char ch = lines[r].charAt(c);
        int val = 0;
        
        if(ch == '1')
        {
          val = 1;
        }
        else if(ch == 'S')
        {
          val = 1;
        }
        else if(ch == 'E')
        {
          val = 1;
        }
        
        gridArray[r][c].value = val;
        gridArray[r][c].SetColour();

        
      }
    }
    
  }

  void AddPaths()
  {
    //setting the walkable tiles in the example map
    //Row 0
    gridArray[0][1].value = 1;//starting point

    //Row 1
    gridArray[1][1].value = 1;
    gridArray[1][4].value = 1;
    gridArray[1][5].value = 1;
    gridArray[1][6].value = 1;
    gridArray[1][7].value = 1;
    gridArray[1][8].value = 1;
    //Row 2
    gridArray[2][1].value = 1;
    gridArray[2][4].value = 1;
    gridArray[2][8].value = 1;
    //Row 3
    gridArray[3][1].value = 1;
    gridArray[3][6].value = 1;
    gridArray[3][7].value = 1;
    gridArray[3][8].value = 1;
    //Row 4
    gridArray[4][1].value = 1;
    gridArray[4][2].value = 1;
    gridArray[4][3].value = 1;
    gridArray[4][4].value = 1;
    gridArray[4][5].value = 1;
    gridArray[4][8].value = 1;
    //Row 5
    gridArray[5][1].value = 1;
    gridArray[5][3].value = 1;
    gridArray[5][8].value = 1;
    //Row 6
    gridArray[6][1].value = 1;
    gridArray[6][3].value = 1;
    gridArray[6][5].value = 1;
    gridArray[6][6].value = 1;
    gridArray[6][7].value = 1;
    gridArray[6][8].value = 1;
    //Row 7
    gridArray[7][1].value = 1;
    gridArray[7][3].value = 1;
    gridArray[7][5].value = 1;
    gridArray[7][8].value = 1;
    //Row 8
    gridArray[8][1].value = 1;
    gridArray[8][3].value = 1;
    gridArray[8][4].value = 1;
    gridArray[8][5].value = 1;
    gridArray[8][6].value = 1;
    gridArray[8][8].value = 1;
    gridArray[8][9].value = 1;//finish point
    //row9 was all unwalkable
    for (int x = 0; x < gridArray.length; x++)
    {

      for (int y = 0; y < gridArray[x].length; y++)
      {
        gridArray[x][y].SetColour();
      }
    }
  }

  void InitGrid(int num)
  {
    if(num == 0)
    {
      MakeBasicGrid();
      AddPaths();
    }
    
    if(num == 1)
    {
      MakeBasicGrid();
      LoadFromFile("maze.txt");
      
    }
    
    if(num == 2)
    {
      MakeBasicGrid();
      LoadFromFile("maze1.txt");
      
    }
    
    if(num == 3)
    {
      MakeBasicGrid();
      LoadFromFile("maze2.txt");
     
    }
    
    if(num == 4)
    {
      MakeBasicGrid();
      LoadFromFile("maze3.txt");
      
    }
    
  }

  void Update()
  {
    if (graph.visitedStep < graph.visitedOrder.size()) {
      int v = graph.visitedOrder.get(graph.visitedStep);
      int r = v / 10;
      int c = v % 10;
      newGrid.gridArray[r][c].r = 255;
      newGrid.gridArray[r][c].g = 255;
      newGrid.gridArray[r][c].b = 0;
      graph.visitedStep++;
    }
    // once all visited nodes are shown, show path turning green
    else if (graph.visitedStep >= graph.visitedOrder.size() && graph.pathStep < graph.finalPath.size()) {
      int p = graph.finalPath.get(graph.pathStep);
      int r = p / 10;
      int c = p % 10;
      newGrid.gridArray[r][c].r = 0;
      newGrid.gridArray[r][c].g = 255;
      newGrid.gridArray[r][c].b = 0;
      graph.pathStep++;
    }
  }

  void Draw()
  {
    for (int x = 0; x < gridArray.length; x++)
    {
      for (int y = 0; y < gridArray[x].length; y++)
      {
        gridArray[x][y].Draw();
      }
    }
  }
}
