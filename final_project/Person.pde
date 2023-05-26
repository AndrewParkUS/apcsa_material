class Person {
  int x, y; 
  boolean infected; 
  boolean alive;
  int health;

  Person(int gridSize) {
    x = floor(random(width / gridSize)) * gridSize; 
    y = floor(random(height / gridSize)) * gridSize;
    infected = false;
    alive = true;
    health = 100; // initial health is full
  }
  
  boolean checkAliveStatus() {
    
  }

 
}
