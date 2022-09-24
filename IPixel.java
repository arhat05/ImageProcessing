package model;

/**
 * This interface represents a single pixel in the image and stores its RGB values.
 */
public interface IPixel {
  /**
   * This method is used to get the red value because the instance variables are private.
   *
   * @return the value of the red.
   */
  public int getRed();

  /**
   * This method is used to get the green value because the instance variables are private.
   *
   * @return the value of the green.
   */
  public int getGreen();

  /**
   * This method is used to get the blue value because the instance variables are private.
   *
   * @return the value of the blue.
   */
  public int getBlue();
}

