public class Kernel {
  float[][] kernel;

  /** Constructor takes the kernel that will be applied to the image.
  * This implementation only allows 3x3 kernels.
  */
  public Kernel(float[][] init) {
    kernel = init;
  }

  /** If part of the kernel is off of the image, return black. Otherwise,
  * calculate the convolution of r/g/b separately, and return that color.
  * If the calculation for any of the r,g,b values is outside the range
  * 0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255).
  */
  color calcNewColor(PImage img, int x, int y) {
    float rSum = 0;
    float gSum = 0;
    float bSum = 0;
    int kernelSize = 3;
  
    for (int i = 0; i < kernelSize; i++) {
      for (int j = 0; j < kernelSize; j++) {
        int px = x + i - 1; // coordinates of pixel
        int py = y + j - 1;
  
        // if pixel outside image
        if (px < 0 || px >= img.width || py < 0 || py >= img.height) {
          return color(0);
        }
  
        // pixel color
        color c = img.get(px, py);
  
        // apply kernel
        float kernelValue = kernel[i][j];
        rSum += red(c) * kernelValue;
        gSum += green(c) * kernelValue;
        bSum += blue(c) * kernelValue;
      }
    }
  
    // constrain to 0-255
    int r = round(constrain(rSum, 0, 255));
    int g = round(constrain(gSum, 0, 255));
    int b = round(constrain(bSum, 0, 255));
  
    return color(r, g, b);
  }


  /** Apply the kernel to the source and save the data to the destination. */
  void apply(PImage source, PImage destination) {
    for (int x = 0; x < source.width; x++) {
      for (int y = 0; y < source.height; y++) {
        // calc new color & apply
        color newColor = calcNewColor(source, x, y);
        destination.set(x, y, newColor);
      }
    }
  }
}
