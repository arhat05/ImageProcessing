import org.junit.Test;

import view.ImageViewImpl;


/**
 * This class tests the image view.
 */
public class ImageViewTest {

  ImageViewImpl v2;


  /**
   * tests to make sure an exception gets thrown for a null object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrown() {
    this.v2 = new ImageViewImpl(null);
  }
}