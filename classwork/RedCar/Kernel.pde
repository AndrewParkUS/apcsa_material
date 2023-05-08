public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    int kernelSize = 3; // Assuming a 3x3 kernel, adjust if needed
    int halfKernel = kernelSize / 2;
    
    // Check if the kernel is off the image
    if (x < halfKernel || x >= img.width - halfKernel || y < halfKernel || y >= img.height - halfKernel) {
      return color(0); // returns black
    }
    
    float sumR = 0;
    float sumG = 0;
    float sumB = 0;
    
    for (int i = -halfKernel; i <= halfKernel; i++) {
      for (int j = -halfKernel; j <= halfKernel; j++) {
        // get current pixel w double loop
        color c = img.get(x + i, y + j);
        
        // getting rgb
        float r = red(c);
        float g = green(c);
        float b = blue(c);
        
        // add
        sumR += r;
        sumG += g;
        sumB += b;
      }
  }
  
  // constrain so max goes to 255 and min goes to 0
  sumR = constrain(sumR, 0, 255);
  sumG = constrain(sumG, 0, 255);
  sumB = constrain(sumB, 0, 255);
  
  return color(sumR, sumG, sumB);
}


  /**Apply the kernel to the source,
  *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    int kernelSize = 3; 
    int halfKernel = kernelSize / 2;
    
    //changing each pixel
    for (int x = 0; x < source.width; x++) {
      for (int y = 0; y < source.height; y++) {
        color newColor = calcNewColor(source, x, y);
        
        // set new color
        destination.set(x, y, newColor);
      }
    }
  }


}
