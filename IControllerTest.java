import org.junit.Test;

import java.io.StringReader;

import controller.IController;
import controller.IControllerImpl;
import model.ImageModelImpl;
import model.ImageVersions;
import model.Pixel;
import view.ImageView;
import view.ImageViewImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test the controller.
 */
public class IControllerTest {

  IControllerImpl c;

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

  ImageModelImpl model;

  /**
   * Tests to make sure an exception gets thrown for a null object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrown() {
    this.c = new IControllerImpl(null, null, null);
  }

  /**
   * Tests to make sure that the brighten function executed correctly.
   */
  @org.junit.Test
  public void brightenCommand() {
    Readable input = new StringReader("brighten 10 model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully brightened by 10 \n", out.toString());
  }

  /**
   * Tests to make sure that the darken function executed correctly.
   */
  @org.junit.Test
  public void darkenCommand() {
    Readable input = new StringReader("darken 10 model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully darkened by 10 \n", out.toString());
  }

  /**
   * Tests to make sure that the flip horizontally function executed correctly.
   */
  @org.junit.Test
  public void flipHorizontallyCommand() {
    Readable input = new StringReader("horizontal-flip model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully flipped horizontally \n", out.toString());
  }

  /**
   * Tests to make sure that the flip vertically function executed correctly.
   */
  @org.junit.Test
  public void flipVerticallyCommand() {
    Readable input = new StringReader("vertical-flip model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully flipped vertically \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleRedCommand() {
    Readable input = new StringReader("greyscale-red model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by red \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleGreenCommand() {
    Readable input = new StringReader("greyscale-green model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by green \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleBlueCommand() {
    Readable input = new StringReader("greyscale-blue model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by blue \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleValueCommand() {
    Readable input = new StringReader("greyscale-value model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by value \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleLumaCommand() {
    Readable input = new StringReader("greyscale-luma model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by luma \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void greyscaleIntensityCommand() {
    Readable input = new StringReader("greyscale-intensity model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully greyscale by intensity \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void saveCommand() {
    Readable input = new StringReader("save model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully saved \n", out.toString());
  }

  /**
   * Tests to make sure that the greyscale function executed correctly.
   */
  @org.junit.Test
  public void loadCommand() {
    Readable input = new StringReader("load model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully loaded \n", out.toString());
  }

  /**
   * Tests to make sure that the sepia function executed correctly.
   */
  @org.junit.Test
  public void sepiaCommand() {
    Readable input = new StringReader("sepia model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image successfully added the sepia filter \n", out.toString());
  }

  /**
   * Tests to make sure that the blur function executed correctly.
   */
  @org.junit.Test
  public void blurCommand() {
    Readable input = new StringReader("blur model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully blurred\n", out.toString());
  }

  /**
   * Tests to make sure that the sharpen function executed correctly.
   */
  @org.junit.Test
  public void sharpenCommand() {
    Readable input = new StringReader("sharpen model image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Image is successfully sharpened\n", out.toString());
  }

  /**
   * Tests to make sure that the correct message gets printed when an invalid is entered .
   */
  @org.junit.Test
  public void testInvalid() {
    Readable input = new StringReader("blur model1 image2");
    Appendable out = new StringBuffer();

    ImageModelImpl model = new ImageModelImpl(pixels, 3, 3, 255);
    ImageVersions images = new ImageVersions();
    images.add("model", model);
    ImageView view = new ImageViewImpl(images);
    IController controller = new IControllerImpl(input, images, view);
    controller.run();

    assertEquals("Invalid Filename", out.toString());
  }
}