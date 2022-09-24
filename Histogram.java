package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import model.Pixel;

/**
 * This class is used to create a histogram of the image.
 */
public class Histogram extends JPanel {
  private int[][] table = new int[4][256];
  private static double SCALERED;
  private static double SCALEGREEN;
  private static double SCALEBLUE;
  private static double SCALEAVG;

  /**
   * This is the constructor for the Histogram that takes a 2-D pixels that represents an image.
   * @param pixels The 2-D pixels of an image.
   */
  public Histogram(Pixel[][] pixels) {
    super();
    if (pixels == null) {
      throw new IllegalArgumentException("Incorrect List");
    }

    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        int r = pixels[i][j].getRed();
        int g = pixels[i][j].getGreen();
        int b = pixels[i][j].getBlue();
        int avg = (r + g + b) / 3;
        table[0][r]++;
        table[1][g]++;
        table[2][b]++;
        table[3][avg]++;
      }
    }
    this.setPreferredSize(new Dimension(260, 300));
  }

  private int[] getMax() {
    int maxRed = 0;
    int maxGreen = 0;
    int maxBlue = 0;
    int maxAvg = 0;
    int overallMax = 0;

    for (int i = 0; i < this.table[0].length; i++) {
      if (this.table[0][i] > maxRed) {
        maxRed = this.table[0][i];
      }
    }
    for (int i = 0; i < this.table[1].length; i++) {
      if (this.table[1][i] > maxGreen) {
        maxGreen = this.table[1][i];
      }
    }
    for (int i = 0; i < this.table[2].length; i++) {
      if (this.table[2][i] > maxBlue) {
        maxBlue = this.table[2][i];
      }
    }
    for (int i = 0; i < this.table[3].length; i++) {
      if (this.table[3][i] > maxAvg) {
        maxAvg = this.table[3][i];
      }
    }
    int[] maxes = {maxRed, maxGreen, maxBlue, maxAvg};

    return maxes;
  }

  /**
   * This method is used to paint the Histogram.
   * @param g The Graphics object.
   */
  @Override
  public void paintComponent(Graphics g) {
    SCALERED = (this.getHeight() * 0.2) / this.getMax()[0];
    SCALEGREEN = (this.getHeight() * 0.2) / this.getMax()[1];
    SCALEBLUE = (this.getHeight() * 0.2) / this.getMax()[2];
    SCALEAVG = (this.getHeight() * 0.2) / this.getMax()[3];
    super.paintComponent(g);
    Graphics2D graphics2D = (Graphics2D) g;

    AffineTransform originalTransform = graphics2D.getTransform();
    graphics2D.translate(0, this.getPreferredSize().getHeight());
    graphics2D.scale(1, -1);

    for (int i = 0; i < table[0].length; i++) {
      Color c = new Color(255,0,0,65);
      graphics2D.setColor(c);
      graphics2D.drawLine(i, 0, i, (int) (SCALERED * table[0][i]));
    }

    for (int i = 0; i < table[1].length; i++) {
      Color c = new Color(0,255,0, 65);
      graphics2D.setColor(c);
      graphics2D.drawLine(i, 0, i, (int) (SCALEGREEN * table[1][i]));
    }

    for (int i = 0; i < table[2].length; i++) {
      Color c = new Color(0,0,255, 65);
      graphics2D.setColor(c);
      graphics2D.drawLine(i, 0, i, (int) (SCALEBLUE * table[2][i]));
    }

    for (int i = 0; i < table[3].length; i++) {
      Color c = new Color(0, 0, 0, 65);
      graphics2D.setColor(c);
      graphics2D.drawLine(i, 0, i, (int) (SCALEAVG * table[3][i]));
    }

    graphics2D.setTransform(originalTransform);
  }

  /**
   * This method is used to get the table of values for the histogram,
   * is used for testing.
   * @return The table of values for the histogram.
   */
  public int[][] getTable() {
    return this.table;
  }

}
