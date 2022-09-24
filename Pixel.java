package model;

/**
 * Implementation of the IPixel interface.
 */
public class Pixel implements IPixel {
  private int red;
  private int green;
  private int blue;

  /**
   * A constructor that takes the RGB values.
   *
   * @param red   the red value.
   * @param green the green value.
   * @param blue  the blue value.
   */
  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * This method is used to get the red value because the instance variables are private.
   *
   * @return the value of the red.
   */
  public int getRed() {
    return this.red = red;
  }

  /**
   * This method is used to get the green value because the instance variables are private.
   *
   * @return the value of the green.
   */
  public int getGreen() {
    return this.green = green;
  }

  /**
   * This method is used to get the blue value because the instance variables are private.
   *
   * @return the value of the blue.
   */
  public int getBlue() {
    return this.blue = blue;
  }
}
