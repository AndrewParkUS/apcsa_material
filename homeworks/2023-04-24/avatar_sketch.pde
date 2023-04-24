void setup() {
  size(800, 800);
}

void drawAvatar(int x, int y) {
  fill(0, 0, 255);
  rect(x + 25, y + 75, 50, 100); 

  fill(255, 0, 0);
  ellipse(x + 50, y + 50, 50, 50); 

  stroke(0);
  strokeWeight(4);
  line(x + 25, y + 100, x, y + 150);
  line(x + 75, y + 100, x + 100, y + 150);

  line(x + 25, y + 175, x, y + 200);
  line(x + 75, y + 175, x + 100, y + 200);
}

void draw() {
  background(255);
  
  drawAvatar(50, 50);
  drawAvatar(200, 500);
}
