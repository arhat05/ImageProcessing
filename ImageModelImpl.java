package model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the image model interface and all its methods. All these methods relate
 * to the image view.
 */
public class ImageModelImpl implements ImageModel {

  private Pixel[][] image;
  private int height;
  private int width;
  private int maxValue;


  /**
   * A constructor that in the pixels, height, and width that represents an image.
   *
   * @param image    a 2D array that stores the pixels of the image and its rgb values.
   * @param height   the height of the image.
   * @param width    the width of the image.
   * @param maxValue the maximum value of the image.
   */
  public ImageModelImpl(Pixel[][] image, int height, int width, int maxValue) {
    this.image = image;
    this.height = height;
    this.width = width;
    this.maxValue = maxValue;
  }

  /**
   * This method takes an image and brightens it by adding a positive constant to the red,
   * green and blue components of all pixels and clamping to the maximum possible value if needed.
   *
   * @param value the constant value that the image should be brightened to.
   * @return a new image that is the brightened version of the original image.
   */
  @Override
  public ImageModel brighten(int value) {
    Pixel[][] edited = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int red;
        int green;
        int blue;
        if (value + image[i][j].getRed() > maxValue) {
          red = maxValue;
        } else {
          red = this.image[i][j].getRed() + value;
        }
        if (value + image[i][j].getGreen() > maxValue) {
          green = maxValue;
        } else {
          green = this.image[i][j].getGreen() + value;
        }
        if (value + image[i][j].getBlue() > maxValue) {
          blue = maxValue;
        } else {
          blue = this.image[i][j].getBlue() + value;
        }
        edited[i][j] = new Pixel(red, green, blue);
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }

  /**
   * This method takes in an image and darkens it by subtracting a positive constant
   * from the values of all pixels and clamping to the minimum value if needed.
   *
   * @param value the constant value that the image should be darkened to.
   * @return a new image that is the darkened version of the original image.
   */
  @Override
  public ImageModel darken(int value) {
    Pixel[][] edited = new Pixel[this.height][this.width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int red;
        int green;
        int blue;
        if (value > image[i][j].getRed()) {
          red = 0;
        } else {
          red = this.image[i][j].getRed() - value;
        }
        if (value > image[i][j].getGreen()) {
          green = 0;
        } else {
          green = this.image[i][j].getGreen() - value;
        }
        if (value > image[i][j].getBlue()) {
          blue = 0;
        } else {
          blue = this.image[i][j].getBlue() - value;
        }
        edited[i][j] = new Pixel(red, green, blue);
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }

  /**
   * This method flips a given image horizontally without changing the size of the image.
   *
   * @return a new image that is the horizontally flipped version of the original image.
   */
  @Override
  public ImageModel flipHorizontally() {
    Pixel[][] edited = new Pixel[this.height][this.width];
    Pixel temp;
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width / 2; j++) {
        temp = this.image[i][j];
        edited[i][j] = this.image[i][this.width - 1 - j];
        edited[i][this.width - 1 - j] = temp;
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }

  /**
   * This method flips a given image vertically without changing the size of the image.
   *
   * @return a new image that is the vertically flipped version of the original image.
   */
  @Override
  public ImageModel flipVertically() {
    Pixel[][] edited = new Pixel[this.height][this.width];
    Pixel temp;
    for (int i = 0; i < this.height / 2; i++) {
      for (int j = 0; j < this.width; j++) {
        temp = this.image[i][j];
        edited[i][j] = this.image[this.height - 1 - i][j];
        edited[this.height - 1 - i][j] = temp;
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }

  /**
   * This method sets an image to a greyscale.
   *
   * @param type the component type that should be greyscaled to.
   * @return a new image that is the greyscaled version of the original image.
   */
  @Override
  public ImageModel greyscale(String type) {
    Pixel[][] edited = new Pixel[this.height][this.width];
    switch (type) {
      case "red":
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            edited[i][j] = new Pixel(image[i][j].getRed(),
                    image[i][j].getRed(),
                    image[i][j].getRed());
          }
        }
        return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      case "green": {
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            edited[i][j] = new Pixel(image[i][j].getGreen(),
                    image[i][j].getGreen(),
                    image[i][j].getGreen());
          }
        }
      }
      return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      case "blue": {
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            edited[i][j] = new Pixel(image[i][j].getBlue(),
                    image[i][j].getBlue(),
                    image[i][j].getBlue());
          }
        }
      }
      return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      case "value": {
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            if (image[i][j].getRed() > image[i][j].getGreen() &&
                    image[i][j].getRed() > image[i][j].getBlue()) {
              edited[i][j] = new Pixel(image[i][j].getRed(),
                      image[i][j].getRed(),
                      image[i][j].getRed());
            } else if (image[i][j].getGreen() > image[i][j].getRed() &&
                    image[i][j].getGreen() > image[i][j].getBlue()) {
              edited[i][j] = new Pixel(image[i][j].getGreen(),
                      image[i][j].getGreen(),
                      image[i][j].getGreen());
            } else {
              edited[i][j] = new Pixel(image[i][j].getBlue(),
                      image[i][j].getBlue(),
                      image[i][j].getBlue());
            }
          }
        }
      }
      return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      case "intensity": {
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int average = (image[i][j].getRed() + image[i][j].getBlue() +
                    image[i][j].getGreen()) / 3;
            edited[i][j] = new Pixel(average, average, average);
          }
        }
      }
      return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      case "luma": {
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int luma = (int) ((0.2126 * image[i][j].getRed()) +
                    (0.7152 * image[i][j].getGreen()) + (0.0722 * image[i][j].getBlue()));
            edited[i][j] = new Pixel(luma, luma, luma);
          }
        }
      }
      return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
      default:
        System.out.println("Try again");
        return null;
    }
  }

  /**
   * This method turns an image to have a sepia tone.
   *
   * @return a new image that has a sepia tone compared to the original image.
   */
  @Override
  public ImageModel matrix(String filter) {
    Map<String, double[][]> filters = new HashMap<String, double[][]>();
    double[][] greyscale =
        {{0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}, {0.2126, 0.7152, 0.0722}};
    double[][] sepia = {{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};
    filters.put("greyscale", greyscale);
    filters.put("sepia", sepia);

    Pixel[][] edited = new Pixel[this.height][this.width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int newRed;
        int newGreen;
        int newBlue;

        if ((int) ((image[i][j].getRed() * filters.get(filter)[0][0]) +
                (image[i][j].getGreen() * filters.get(filter)[0][1]) +
                (image[i][j].getBlue() * filters.get(filter)[0][2])) > this.maxValue) {
          newRed = maxValue;
        } else {
          newRed = (int) ((image[i][j].getRed() * filters.get(filter)[0][0]) +
                  (image[i][j].getGreen() * filters.get(filter)[0][1]) +
                  (image[i][j].getBlue() * filters.get(filter)[0][2]));
        }

        if ((int) ((image[i][j].getRed() * filters.get(filter)[1][0]) +
                (image[i][j].getGreen() * filters.get(filter)[1][1]) +
                (image[i][j].getBlue() * filters.get(filter)[1][2])) > this.maxValue) {
          newGreen = maxValue;
        } else {
          newGreen = (int) ((image[i][j].getRed() * filters.get(filter)[1][0]) +
                  (image[i][j].getGreen() * filters.get(filter)[1][1]) +
                  (image[i][j].getBlue() * filters.get(filter)[1][2]));
        }

        if ((int) ((image[i][j].getRed() * filters.get(filter)[2][0]) +
                (image[i][j].getGreen() * filters.get(filter)[2][1]) +
                (image[i][j].getBlue() * filters.get(filter)[2][2])) > this.maxValue) {
          newBlue = maxValue;
        } else {
          newBlue = (int) ((image[i][j].getRed() * filters.get(filter)[2][0]) +
                  (image[i][j].getGreen() * filters.get(filter)[2][1]) +
                  (image[i][j].getBlue() * filters.get(filter)[2][2]));
        }

        edited[i][j] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }

  /**
   * This method is used to blur and sharpen an image by processing a kernel and apply the
   * given filter to it.
   *
   * @param filter the filter either blur or sharpen that should be done to an image.
   * @return A new image that has the filter provided done to it.
   */
  @Override
  public ImageModel kernelProcessor(String filter) {
    Map<String, double[][]> filters = new HashMap<String, double[][]>();
    double[][] blur = {{0.0625, 0.125, 0.0625}, {0.125, 0.25, 0.125}, {0.0625, 0.125, 0.0625}};
    double[][] sharpen =
        {{-0.125, -0.125, -0.125, -0.125, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
                {-0.125, 0.25, 1, 0.25, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
                {-0.125, -0.125, -0.125, -0.125, -0.125}};
    filters.put("blur", blur);
    filters.put("sharpen", sharpen);

    Pixel[][] edited = new Pixel[this.height][this.width];
    // to access each pixel
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int newRed = 0;
        int newGreen = 0;
        int newBlue = 0;

        for (int i2 = 0; i2 < filters.get(filter).length; i2++) {
          for (int j2 = 0; j2 < filters.get(filter)[0].length; j2++) {
            int kerX = i - filters.get(filter).length / 2 + i2;
            int kerY = j - filters.get(filter)[0].length / 2 + j2;
            if (kerX >= 0 && kerY >= 0 && kerX < this.height && kerY < this.width) {
              newRed += (int) ((this.image[kerX][kerY].getRed()) *
                      (filters.get(filter)[i2][j2]));
              newGreen += (int) ((this.image[kerX][kerY].getGreen()) *
                      (filters.get(filter)[i2][j2]));
              newBlue += (int) ((this.image[kerX][kerY].getBlue()) *
                      (filters.get(filter)[i2][j2]));
            }
          }
        }
        if (newRed > this.maxValue) {
          newRed = this.maxValue;
        } else if (newRed < 0) {
          newRed = 0;
        }

        if (newGreen > this.maxValue) {
          newGreen = this.maxValue;
        } else if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue > this.maxValue) {
          newBlue = this.maxValue;
        } else if (newBlue < 0) {
          newBlue = 0;
        }

        edited[i][j] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new ImageModelImpl(edited, this.height, this.width, this.maxValue);
  }


  /**
   * This method gets a specific pixel at a given place in the image.
   *
   * @param row the row where the pixel is from.
   * @param col the column where the pixel is from.
   * @return the pixel at that given location.
   */
  public Pixel getPixels(int row, int col) {
    return this.image[row][col];
  }

  /**
   * This method gets the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * This method gets the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * This method gets the max of the image.
   *
   * @return the max value of the image.
   */
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * This method gets all the pixels of an image.
   *
   * @return the pixels of the image.
   */
  public Pixel[][] getImage() {
    return this.image;
  }
}