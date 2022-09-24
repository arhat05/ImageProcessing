import org.junit.Before;

import model.ImageModel;
import model.ImageModelImpl;
import model.Pixel;


import static org.junit.Assert.assertEquals;

/**
 * Tests the methods in the ImageModelImpl class.
 */
public class ImageModelImplTest {


  Pixel pixel1 = new Pixel(120, 30, 60);
  Pixel pixel2 = new Pixel(200, 100, 50);
  Pixel pixel3 = new Pixel(140, 110, 90);
  Pixel pixel4 = new Pixel(80, 130, 100);
  Pixel pixel5 = new Pixel(70, 100, 200);
  Pixel pixel6 = new Pixel(125, 125, 125);
  Pixel pixel7 = new Pixel(240, 180, 190);
  Pixel pixel8 = new Pixel(190, 210, 135);
  Pixel pixel9 = new Pixel(180, 200, 250);
  Pixel[][] pixels = {{pixel1, pixel2, pixel3}, {pixel4, pixel5, pixel6}, {pixel7, pixel8, pixel9}};

  ImageModel image1;

  /**
   * Tests to make sure that the image can be initialized.
   */
  @Before
  public void init() {
    this.image1 = new ImageModelImpl(pixels, 3, 3, 255);
  }


  /**
   * Tests the brighten method.
   */
  @org.junit.Test
  public void brighten() {
    assertEquals(170, image1.brighten(50).getPixels(0, 0).getRed());
    assertEquals(80, image1.brighten(50).getPixels(0, 0).getGreen());
    assertEquals(110, image1.brighten(50).getPixels(0, 0).getBlue());
    assertEquals(255, image1.brighten(50).getPixels(2, 2).getBlue());
  }

  /**
   * Tests the darken method.
   */
  @org.junit.Test
  public void darken() {
    ImageModelImpl image1 = new ImageModelImpl(pixels, 3, 3, 255);

    assertEquals(70, image1.darken(50).getPixels(0, 0).getRed());
    assertEquals(0, image1.darken(50).getPixels(0, 0).getGreen());
    assertEquals(10, image1.darken(50).getPixels(0, 0).getBlue());
  }

  /**
   * Tests the flipHorizontally method.
   */
  @org.junit.Test
  public void flipHorizontally() {
    ImageModelImpl image1 = new ImageModelImpl(pixels, 3, 3, 255);

    assertEquals(140, image1.flipHorizontally().getPixels(0, 0).getRed());
    assertEquals(110, image1.flipHorizontally().getPixels(0, 0).getGreen());
    assertEquals(90, image1.flipHorizontally().getPixels(0, 0).getBlue());

    assertEquals(200, image1.flipHorizontally().getPixels(0, 1).getRed());
    assertEquals(100, image1.flipHorizontally().getPixels(0, 1).getGreen());
    assertEquals(50, image1.flipHorizontally().getPixels(0, 1).getBlue());


    assertEquals(120, image1.flipHorizontally().getPixels(0, 2).getRed());
    assertEquals(30, image1.flipHorizontally().getPixels(0, 2).getGreen());
    assertEquals(60, image1.flipHorizontally().getPixels(0, 2).getBlue());
  }

  /**
   * Tests the flipVertically method.
   */
  @org.junit.Test
  public void flipVertically() {
    ImageModelImpl image1 = new ImageModelImpl(pixels, 3, 3, 255);

    assertEquals(240, image1.flipVertically().getPixels(0, 0).getRed());
    assertEquals(180, image1.flipVertically().getPixels(0, 0).getGreen());
    assertEquals(190, image1.flipVertically().getPixels(0, 0).getBlue());

    assertEquals(80, image1.flipVertically().getPixels(1, 0).getRed());
    assertEquals(130, image1.flipVertically().getPixels(1, 0).getGreen());
    assertEquals(100, image1.flipVertically().getPixels(1, 0).getBlue());

    assertEquals(120, image1.flipVertically().getPixels(2, 0).getRed());
    assertEquals(30, image1.flipVertically().getPixels(2, 0).getGreen());
    assertEquals(60, image1.flipVertically().getPixels(2, 0).getBlue());
  }

  /**
   * Tests the greyscale method.
   */
  @org.junit.Test
  public void greyscaleRed() {
    ImageModelImpl image1 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(120, image1.greyscale("red").getPixels(0, 0).getRed());
    assertEquals(120, image1.greyscale("red").getPixels(0, 0).getGreen());
    assertEquals(120, image1.greyscale("red").getPixels(0, 0).getBlue());
  }


  @org.junit.Test
  public void greyscaleGreen() {
    ImageModelImpl image2 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(30, image2.greyscale("green").getPixels(0, 0).getRed());
    assertEquals(30, image2.greyscale("green").getPixels(0, 0).getGreen());
    assertEquals(30, image2.greyscale("green").getPixels(0, 0).getBlue());
  }

  @org.junit.Test
  public void greyscaleBlue() {
    ImageModelImpl image3 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(60, image3.greyscale("blue").getPixels(0, 0).getRed());
    assertEquals(60, image3.greyscale("blue").getPixels(0, 0).getGreen());
    assertEquals(60, image3.greyscale("blue").getPixels(0, 0).getBlue());
  }

  @org.junit.Test
  public void greyscaleValue() {
    ImageModelImpl image4 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(120, image4.greyscale("value").getPixels(0, 0).getRed());
    assertEquals(120, image4.greyscale("value").getPixels(0, 0).getGreen());
    assertEquals(120, image4.greyscale("value").getPixels(0, 0).getBlue());
  }

  @org.junit.Test
  public void greyscaleIntensity() {
    ImageModelImpl image5 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(70, image5.greyscale("intensity").getPixels(0, 0).getRed());
    assertEquals(70, image5.greyscale("intensity").getPixels(0, 0).getGreen());
    assertEquals(70, image5.greyscale("intensity").getPixels(0, 0).getBlue());
  }

  @org.junit.Test
  public void greyscaleLuma() {
    ImageModelImpl image6 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(51, image6.greyscale("luma").getPixels(0, 0).getRed());
    assertEquals(51, image6.greyscale("luma").getPixels(0, 0).getGreen());
    assertEquals(51, image6.greyscale("luma").getPixels(0, 0).getBlue());
  }

  @org.junit.Test
  public void sepiaTest() {
    ImageModelImpl image7 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(81, image7.matrix("sepia").getPixels(0, 0).getRed());
    assertEquals(72, image7.matrix("sepia").getPixels(0, 0).getGreen());
    assertEquals(56, image7.matrix("sepia").getPixels(0, 0).getBlue());
    assertEquals(188, image7.matrix("sepia").getPixels(2, 2).getBlue());
  }

  @org.junit.Test
  public void blurTest() {
    ImageModelImpl image8 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(69,
            image8.kernelProcessor("blur").getPixels(0, 0).getRed());
    assertEquals(41,
            image8.kernelProcessor("blur").getPixels(0, 0).getGreen());
    assertEquals(45,
            image8.kernelProcessor("blur").getPixels(0, 0).getBlue());
    assertEquals(105,
            image8.kernelProcessor("blur").getPixels(2, 2).getBlue());
  }

  @org.junit.Test
  public void sharpenTest() {
    ImageModelImpl image9 = new ImageModelImpl(pixels, 3, 3, 255);
    assertEquals(100,
            image9.kernelProcessor("sharpen").getPixels(0, 0).getRed());
    assertEquals(11,
            image9.kernelProcessor("sharpen").getPixels(0, 0).getGreen());
    assertEquals(51,
            image9.kernelProcessor("sharpen").getPixels(0, 0).getBlue());
    assertEquals(255,
            image9.kernelProcessor("sharpen").getPixels(2, 2).getBlue());
  }
}