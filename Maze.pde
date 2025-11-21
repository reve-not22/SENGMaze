
float currentTime;
float previousTime;
float dt;

float stepTimer;
float stepDelay = 0.1;

Grid newGrid;
Graph_Brett graph;
int num = 0;
int start;
int end;

boolean canDo = false;

void setup()
{

  size(500, 500);

  graph =  new Graph_Brett();
  start = 0 * 10 + 1;
  end = 8 * 10 + 9;

  newGrid = new Grid();
  newGrid.InitGrid(num);
  graph.BFS(start, end, newGrid.gridArray);

}

void draw()
{
  background(110,110,110);
  dt = DeltaTime();
  stepTimer += dt;
  
  if (stepTimer >= stepDelay)
  {
    stepTimer = 0;
    newGrid.Update();  
  }
  
   newGrid.Draw();
  
}

void keyPressed()
{
  if(key == 'z')
  {
    graph =  new Graph_Brett();
    newGrid = new Grid();
    newGrid.InitGrid(0);
    start = 0 * 10 + 1;
    end = 8 * 10 + 9;
    graph.BFS(start, end, newGrid.gridArray);
  }
  if(key == 'q')
  {
    graph =  new Graph_Brett();
    newGrid = new Grid();
    start = 0 * 10;
    end = 3 * 10 + 9;
    newGrid.InitGrid(1);
    graph.BFS(start, end, newGrid.gridArray);
  }
  if(key == 'w')
  {
    graph =  new Graph_Brett();
    newGrid = new Grid();
    start = 0 * 10;
    end = 9 * 10 + 9;
    newGrid.InitGrid(2);
    graph.BFS(start, end, newGrid.gridArray);
  }
  if(key == 'e')
  {
    graph =  new Graph_Brett();
    newGrid = new Grid();
    start = 0 * 10;
    end = 9 * 10 + 9;
    newGrid.InitGrid(3);
    graph.BFS(start, end, newGrid.gridArray);
  }
  if(key == 'r')
  {
    graph =  new Graph_Brett();
    newGrid = new Grid();
    start = 0 * 10;
    end = 0 * 10 + 5;
    newGrid.InitGrid(4);
    graph.BFS(start, end, newGrid.gridArray);
  }
}

float DeltaTime()
{
  currentTime = millis();

  float deltaTime = (currentTime - previousTime) / 1000;
  previousTime = currentTime;
  return deltaTime;
}
