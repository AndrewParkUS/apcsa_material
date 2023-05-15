PImage car, output;
Kernel[] kernels;
String[] names;
int currentKernel;

void setup() {
  size(1450,500);
  car = loadImage("redcar.png");
  output = car.copy();

  currentKernel=0;
  names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };
  kernels = new Kernel[] {
    new Kernel( new float[][] {
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    }) ,
    new Kernel( new float[][] {
      {.111, .111, .111},
      {.111, .111, .111},
      {.111, .111, .111}
    }) ,
    new Kernel( new float[][] {
      {0, -1, 0},
      {-1, 5, -1},
      {0, -1, 0}
    }) ,
    new Kernel( new float[][] {
      {-1, -1, -1},
      {-1, 8, -1},
      {-1, -1, -1}
    }) ,
    new Kernel( new float[][] {
      {1, 0, -1},
      {2, 0, -2},
      {1, 0, -1}
    }) ,
    new Kernel( new float[][] {
      {-1, 0, 1},
      {-2, 0, 2},
      {-1, 0, 1}
    }) ,
    new Kernel( new float[][] {
      {1, 2,  1},
      {0, 0, 0},
      {-1, -2, -1}
    }),
    new Kernel( new float[][] {
      {-2, -1,  0},
      {-1, 1, 1},
      {0, 1, 2}
    })
  };
  image(car,0,0);
}

void draw() {
  if (keyPressed) {
    if (key == ' ') {
      currentKernel = (currentKernel + 1) % kernels.length;
      System.out.println("Applying " + names[currentKernel]);
      kernels[currentKernel].apply(car, output);
      image(output, car.width, 0);
      delay(500);
    }
  }
}
