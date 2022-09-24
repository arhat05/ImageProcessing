package model;

/**
 * This interface represents a model for an image and the different operations that can be done
 * to the image.
 */
public interface ImageModel {

  /**
   * This method takes an image and brightens it by adding a positive constant to the red,
   * green and blue components of all pixels and clamping to the maximum possible value if needed.
   *
   * @param value the constant value that the image should be brightened to.
   * @return a new image that is the brightened version of the original image.
   */
  ImageModel brighten(int value);

  /**
   * This method takes in an image and darkens it by subtracting a positive constant
   * from the values of all pixels and clamping to the minimum value if needed.
   *
   * @param value the constant value that the image should be darkened to.
   * @return a new image that is the darkened version of the original image.
   */
  ImageModel darken(int value);

  /**
   * This method flips a given image horizontally without changing the size of the image.
   *
   * @return a new image that is the horizontally flipped version of the original image.
   */
  ImageModel flipHorizontally();

  /**
   * This method flips a given image vertically without changing the size of the image.
   *
   * @return a new image that is the vertically flipped version of the original image.
   */
  ImageModel flipVertically();

  /**
   * This method sets an image to a greyscale.
   *
   * @param type the component type that should be greyscaled to.
   * @return a new image that is the greyscaled version of the original image.
   */
  ImageModel greyscale(String type);

  /**
   * This method turns an image to have a sepia tone.
   *
   * @return a new image that has a sepia tone compared to the original image.
   */
  ImageModel matrix(String filter);

  /**
   * This method is used to blur and sharpen an image by processing a kernel and apply the
   * given filter to it.
   *
   * @param filter the filter either blur or sharpen that should be done to an image.
   * @return A new image that has the filter provided done to it.
   */
  ImageModel kernelProcessor(String filter);

  /**
   * This method gets a specific pixel at a given place in the image.
   *
   * @param row the row where the pixel is from.
   * @param col the column where the pixel is from.
   * @return the pixel at that given location.
   */
  Pixel getPixels(int row, int col);


  /**
   * This method gets the height of the image.
   *
   * @return the height of the image.
   */
  int getHeight();

  /**
   * This method gets the width of the image.
   *
   * @return the width of the image.
   */
  int getWidth();

  /**
   * This method gets the max of the image.
   *
   * @return the max value of the image.
   */
  int getMaxValue();


  /**
   * This method gets all the pixels of an image.
   *
   * @return the pixels of the image.
   */
  Pixel[][] getImage();
}
