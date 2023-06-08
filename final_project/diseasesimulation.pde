import javax.swing.JOptionPane; // necessary for user input

class Simulation {
  int gridSize; // size of each cell
  int gridWidth; // horiz cells
  int gridHeight; // vert cells
  int numPersons; // number of ppl

  Cell[][] grid; // cell grid
  ArrayList<Person> persons; // persons

  int startTime; // simulation start time

  int aliveCount; // number of persons alive
  int infectedCount; // number of persons infected

  Simulation(int canvasWidth, int canvasHeight, int numPersons, int startingHealth, float infectionSpreadRate, float infectionDeadlinessRate) {
    gridSize = 10; // size per cell
    gridWidth = canvasWidth / gridSize; // num of horiz cells
    gridHeight = canvasHeight / gridSize; // num of vert cells
    this.numPersons = numPersons;

    grid = new Cell[gridWidth][gridHeight];
    persons = new ArrayList<Person>();

    generateGrid();

    createPerson(true, startingHealth, infectionSpreadRate, infectionDeadlinessRate);
    for (int i = 0; i < numPersons - 1; i++) {
      createPerson(false, startingHealth, infectionSpreadRate, infectionDeadlinessRate); // create numPersons
    }

    startTime = millis(); // simulation start time
  }

  void generateGrid() {
    grid = new Cell[gridWidth][gridHeight];
    for (int x = 0; x < gridWidth; x++) { // loop thru each cell
      for (int y = 0; y < gridHeight; y++) {
        grid[x][y] = new Cell(x * gridSize, y * gridSize);
      }
    }
  }

  void createPerson(boolean infect, int startingHealth, float infectionSpreadRate, float infectionDeadlinessRate) {
    Person person = new Person(gridSize, infect, startingHealth, infectionSpreadRate, infectionDeadlinessRate);
    persons.add(person);
  }

  void update() {
    background(255);

    // rendering people
    aliveCount = 0;
    infectedCount = 0;
    for (Person person : persons) {
      if (person.alive) {
        fill(person.infected ? color(255, 0, 0) : color(0));
        rect(person.x, person.y, gridSize, gridSize);
        if (person.infected) infectedCount++; // counting stats for visual interface
        aliveCount++;
      }
    }

    // updating so they move/spread
    for (Person person : persons) {
      if (person.alive) {
        person.move(gridWidth, gridHeight);
        person.spreadDisease(persons);
      }
    }
  }

  int getAliveCount() { // getters
    return aliveCount;
  }

  int getInfectedCount() {
    return infectedCount;
  }

  int getElapsedTime() { // time (for interface)
    int elapsedTime = millis() - startTime;
    return elapsedTime / 1000; // convert to seconds
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

  Person(int gridSize, boolean infect, int startingHealth, float infectionSpreadRate, float infectionDeadlinessRate) {
    this.gridSize = gridSize;
    x = floor(random(width / gridSize)) * gridSize; // random position (x/y)
    y = floor(random(height / gridSize)) * gridSize;
    infected = infect; // starts off not infected
    alive = true; // should start alive
    health = startingHealth; // starting health
    this.infectionSpreadRate = infectionSpreadRate;
    this.infectionDeadlinessRate = infectionDeadlinessRate;
  }

  void move(int gridWidth, int gridHeight) {
    int direction = floor(random(4)); // random direction

    switch (direction) { // very cool
      case 0: // up
        if (y > 0)
          y -= gridSize;
        break;
      case 1: // right
        if (x < (gridWidth - 1) * gridSize)
          x += gridSize;
        break;
      case 2: // down
        if (y < (gridHeight - 1) * gridSize)
          y += gridSize;
        break;
      case 3: // left
        if (x > 0)
          x -= gridSize;
        break;
    }
  }

  void spreadDisease(ArrayList<Person> persons) {
    if (!infected)
      return; // can't spread disease if not infected

    for (Person other : persons) {
      if (other != this && !other.infected && dist(x, y, other.x, other.y) <= gridSize * 3) {
        if (random(100) < infectionSpreadRate) {
          other.infect();
        }
      }
    }

    health -= infectionDeadlinessRate; // if infected, you lose health

    if (health <= 0) {
      alive = false; // make sure to make them disappear after dead
    }
  }

  void infect() {
    infected = true;
    health = 100; // reset health when infected
  }
}

Simulation simulation;

void settings() {
  int canvasWidth = 1080;
  int canvasHeight = 720;

  size(canvasWidth, canvasHeight);
}

void setup() {
  // user input
  int numPersons = Integer.parseInt(JOptionPane.showInputDialog("Number of persons"));
  int startingHealth = Integer.parseInt(JOptionPane.showInputDialog("Starting Health (Usual is 100):"));
  float infectionSpreadRate = Float.parseFloat(JOptionPane.showInputDialog("Infection Spread Rate (0-100):"));
  float infectionDeadlinessRate = Float.parseFloat(JOptionPane.showInputDialog("Infection Deadliness Rate (0-5):"));

  simulation = new Simulation(width, height, numPersons, startingHealth, infectionSpreadRate, infectionDeadlinessRate);
}

void draw() {
  simulation.update();
  delay(20);

  // visual interface
  int dashboardX = width - 200;
  int dashboardY = 10;
  int dashboardPadding = 10;

  fill(220); 
  rect(dashboardX, dashboardY, 190, 80);

  fill(0);
  textAlign(RIGHT, TOP);
  text("Alive: " + simulation.getAliveCount(), dashboardX + 180, dashboardY + dashboardPadding);
  text("Infected: " + simulation.getInfectedCount(), dashboardX + 180, dashboardY + 20 + dashboardPadding);
  text("Time: " + simulation.getElapsedTime() + "s", dashboardX + 180, dashboardY + 40 + dashboardPadding);
}
