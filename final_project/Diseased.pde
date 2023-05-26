class Simulation {
  int gridSize;  
  int gridWidth; 
  int gridHeight;
  int numPersons; 

  Cell[][] grid = new Cell[gridWidth][gridHeight];
  ArrayList<Person> persons; // all persons in simulation

  void generateGrid() {
    grid = new Cell[gridWidth][gridHeight];
    for (int x = 0; x < gridWidth; x++) {
      for (int y = 0; y < gridHeight; y++) {
        grid[x][y] = new Cell(x * gridSize, y * gridSize);
      }
    }
  }

  void createPerson() {
    Person person = new Person(gridSize);
    persons.add(person);
  }

  void setup() { // basically constructor + rest
    gridSize = 10; 
    gridWidth = width / gridSize;
    gridHeight = height / gridSize; 
    numPersons = 100; 

    grid = new Cell[gridWidth][gridHeight];
    persons = new ArrayList<Person>();
    generateGrid();

    for (int i = 0; i < numPersons; i++) { // loop to create persons
      createPerson();
    }
  }
}
