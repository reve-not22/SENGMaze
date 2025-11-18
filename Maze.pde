
float currentTime;
float previousTime;
float dt;

float stepTimer;
float stepDelay = 0.1;

Grid newGrid;
Graph_Brett graph;
int start;
int end;

void setup()
{

  size(800, 600);

  graph =  new Graph_Brett();
  start = 0 * 10 + 1;
  end = 8 * 10 + 9;

  newGrid = new Grid();
  newGrid.InitGrid();
  graph.BFS(start, end, newGrid.gridArray);
}

void draw()
{
  dt = DeltaTime();
  stepTimer += dt;
  
  if (stepTimer >= stepDelay)
  {
    stepTimer = 0;
    newGrid.Update();
    
  }


  newGrid.Draw();
}


float DeltaTime()
{
  currentTime = millis();

  float deltaTime = (currentTime - previousTime) / 1000;
  previousTime = currentTime;
  return deltaTime;
}
