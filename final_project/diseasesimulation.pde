class Simulation {
  int gridSize; // size of each cell
  int gridWidth; // horiz cells
  int gridHeight; // vert cells
  int numPersons; // number of ppl

  Cell[][] grid; // cell grid
  ArrayList<Person> persons; // persons

  void generateGrid() {
    grid = new Cell[gridWidth][gridHeight];
    for (int x = 0; x < gridWidth; x++) { // loop thru each cell
      for (int y = 0; y < gridHeight; y++) {
        grid[x][y] = new Cell(x * gridSize, y * gridSize);
      }
    }
    
    // rendering
    for (Cell[] row : grid) {
      for (Cell cell : row) {
        rect(cell.x, cell.y, gridSize, gridSize);
      }
    }
  }

  void createPerson(boolean infect) {
    Person person = new Person(gridSize, infect);
    persons.add(person);
  }

  void setup() { // constructor
    gridSize = 10; // size per cell
    gridWidth = width / gridSize; // num of horiz cells
    gridHeight = height / gridSize; // num of vert cells
    numPersons = 100; // num of persons

    grid = new Cell[gridWidth][gridHeight];
    persons = new ArrayList<Person>();

    generateGrid();
    
    createPerson(true);
    for (int i = 0; i < numPersons - 1; i++) {
      createPerson(false); // create numPersons
    }
    
  }

  void update() {
    background(255); // black background

    // rendering people
    for (Person person : persons) {
      fill(person.infected ? color(255, 0, 0) : color(0)); // not working code
      fill(person.infected && person.alive ? color(255,0,0) : color(255,255,255)); // makes stuff weird
      rect(person.x, person.y, gridSize, gridSize);
    }

    // updating so they move/spread
    for (Person person : persons) {
      person.move(gridWidth, gridHeight);
      person.spreadDisease(persons);
    }
  }
}

class Cell {
  int x, y; // cell coords

  Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Person {
  int x, y; // coords of person
  boolean infected; // is infected?
  boolean alive; // is alive?
  int health; // health (0-100)
  int gridSize; // size of cell
  float infectionSpreadRate; // disease spread rate, scaled from 0 to 100
  float infectionDeadlinessRate; // disease deadliness rate, scaled from 0 to 100

  Person(int gridSize, boolean infect) {
    this.gridSize = gridSize;
    x = floor(random(width / gridSize)) * gridSize; // random position (x/y)
    y = floor(random(height / gridSize)) * gridSize; 
    infected = infect; // starts off not infected
    alive = true; // should start alive
    health = 100; // full health
    infectionSpreadRate = 100;
    infectionDeadlinessRate = 1; 
  }

  void move(int gridWidth, int gridHeight) {
    int direction = floor(random(4)); // random direction

    switch (direction) { // its like python!
      case 0: // up
        if (y > 0) y -= gridSize; 
        break;
      case 1: // right
        if (x < (gridWidth - 1) * gridSize) x += gridSize; 
        break;
      case 2: // down
        if (y < (gridHeight - 1) * gridSize) y += gridSize;
        break;
      case 3: // left
        if (x > 0) x -= gridSize; 
        break;
    }
  }

  void spreadDisease(ArrayList<Person> persons) {
    if (!infected) return; // can't spread disease if not infected

    for (Person other : persons) {
      if (other != this && !other.infected && dist(x, y, other.x, other.y) <= gridSize*3) {
        if (random(100) < infectionSpreadRate) {
          other.infect();
        }
      }
    }

    health -= infectionDeadlinessRate; // if infected u lose health

    if (health <= 0) {
      alive = false;
    }
  }

  void infect() {
    infected = true;
    health = 100; // reset health when infected
  }
}

Simulation simulation;

void setup() {
  size(1080, 720);
  simulation = new Simulation();
  simulation.setup();
}

void draw() {
  simulation.update();
  delay(20);
}
