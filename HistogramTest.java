import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import view.Histogram;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the histogram class and its methods.
 */
public class HistogramTest {

  Histogram h1;
  Pixel pixel1 = new Pixel(120, 30, 60);
  Pixel pixel2 = new Pixel(200, 100, 50);
  Pixel pixel3 = new Pixel(140, 110, 90);
  Pixel pixel4 = new Pixel(80, 110, 100);
  Pixel pixel5 = new Pixel(70, 100, 200);
  Pixel pixel6 = new Pixel(125, 125, 125);
  Pixel pixel7 = new Pixel(240, 180, 190);
  Pixel pixel8 = new Pixel(120, 210, 135);
  Pixel pixel9 = new Pixel(180, 200, 250);
  Pixel[][] pixels = {{pixel1, pixel2, pixel3}, {pixel4, pixel5, pixel6}, {pixel7, pixel8, pixel9}};

  /**
   * Tests to make sure that the image can be initialized.
   */
  @Before
  public void init() {
    this.h1 = new Histogram(pixels);
  }

  /**
   * tests to make sure an exception gets thrown for a null object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAnExceptionBeingThrown() {
    this.h1 = new Histogram(null);
  }

  /**
   * Tests to make sure that the histogram returns the correct values.
   */
  @org.junit.Test
  public void testValues() {
    assertEquals(2, h1.getTable()[0][120]);
    assertEquals(1, h1.getTable()[0][80]);
    assertEquals(0, h1.getTable()[1][0]);
    assertEquals(1, h1.getTable()[1][125]);
    assertEquals(2, h1.getTable()[1][100]);
    assertEquals(2, h1.getTable()[1][110]);
    assertEquals(1, h1.getTable()[2][60]);
  }
}