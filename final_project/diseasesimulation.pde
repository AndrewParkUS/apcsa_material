class Simulation {
  int gridSize; // size of each cell
  int gridWidth; // horiz cells
  int gridHeight; // vert cells
  int numPersons; // number of ppl

  Cell[][] grid; // cell grid
  ArrayList<Person> persons; // persons

  void generateGrid() {
    grid = new Cell[gridWidth][gridHeight];
    for (int x = 0; x < gridWidth; x++) {
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

  void createPerson() {
    Person person = new Person(gridSize);
    persons.add(person);
  }

  void setup() { // constructor!
    gridSize = 10; // size per cell
    gridWidth = width / gridSize; // num of horiz cells
    gridHeight = height / gridSize; // num of vert cells
    numPersons = 100; // num of persons

    grid = new Cell[gridWidth][gridHeight];
    persons = new ArrayList<Person>();

    generateGrid();

    for (int i = 0; i < numPersons; i++) {
      createPerson();
    }
  }

  void update() {
    background(255); // black background

    // rendering people
    for (Person person : persons) {
      fill(person.infected ? color(255, 0, 0) : color(0));
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
  float infectionSpreadRate; // disease spread rate

  Person(int gridSize) {
    this.gridSize = gridSize;
    x = floor(random(width / gridSize)) * gridSize; // random position (x/y)
    y = floor(random(height / gridSize)) * gridSize; 
    infected = false; // starts off not infected
    alive = true; // should start alive
    health = 100; // full health
    infectionSpreadRate = 10; // change rate
  }

  void move(int gridWidth, int gridHeight) {
    int direction = floor(random(4)); // random direction

    switch (direction) {
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
      if (other != this && !other.infected && dist(x, y, other.x, other.y) <= gridSize) {
        if (random(100) < infectionSpreadRate) {
          other.infect();
        }
      }
    }

    health--; // if infected u lose health

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
  size(800, 600);
  simulation = new Simulation();
  simulation.setup();
}

void draw() {
  simulation.update();
  delay(100);
}
