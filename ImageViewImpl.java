package view;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ImageUtil;
import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Darken;
import controller.commands.FlipHorizontally;
import controller.commands.FlipVertically;
import controller.commands.Greyscale;
import controller.commands.GreyscaleOverall;
import controller.commands.Load;
import controller.commands.Save;
import controller.commands.Sepia;
import controller.commands.Sharpen;

import model.IVersions;
import model.ImageModel;

/**
 * This class implements the ImageView interface.
 */
public class ImageViewImpl extends JFrame implements
        ActionListener, ItemListener, ListSelectionListener, ImageView {

  private JPanel mainPanel;
  private JLabel imageLabel;
  private String name;
  private IVersions images;
  private Appendable out;
  private JPanel histo;


  /**
   * A constructor that take in a model and an appendable to use for the text view.
   *
   * @param out the appendable.
   * @throws IllegalArgumentException when one of the inputs are null.
   */
  public ImageViewImpl(IVersions images, Appendable out) throws IllegalArgumentException {
    if (images == null || out == null) {
      throw new IllegalArgumentException("Invalid");
    }
    this.images = images;
    this.out = out;
  }

  /**
   * The constructor of the view that creates the GUI.
   *
   * @param images a hashmap that stores all the different versions of the images and its names.
   */
  public ImageViewImpl(IVersions images) {
    super();
    if (images == null) {
      throw new IllegalArgumentException("Image is null");
    }
    this.images = images;
    this.out = System.out;

    setTitle("Image Editor");
    setSize(500, 500);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

    //scroll bar
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);

    // panel for the buttons
    JPanel action = new JPanel();
    mainPanel.add(action);

    // load button
    JButton loadButton = new JButton("Load");
    loadButton.addActionListener(e -> editImage("Load"));
    action.add(loadButton);

    // save button
    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(e -> editImage("Save"));
    saveButton.setActionCommand("Save Image");
    action.add(saveButton);

    // panel for the image and histogram
    JPanel imagePanel = new JPanel();
    imagePanel.setLayout(new BorderLayout());


    imageLabel = new JLabel();

    JScrollPane imageScroll = new JScrollPane(imageLabel);
    imageScroll.setPreferredSize(new Dimension(500, 500));
    imagePanel.add(imageScroll, BorderLayout.CENTER);
    mainPanel.add(imageScroll);


    histo = new JPanel();
    mainPanel.add(histo);
    histo.setBorder(BorderFactory.createTitledBorder("Histogram"));


    mainPanel.add(imagePanel);

    this.buttons();
  }


  /**
   * Sets up all the buttons for the different operations that can be done to an image.
   */
  @Override
  public void buttons() {

    // edits panel
    JPanel edits = new JPanel();
    edits.setLayout(new BoxLayout(edits, BoxLayout.Y_AXIS));
    edits.setBorder(BorderFactory.createTitledBorder("Editor"));

    // blur button
    JButton blurButton = new JButton("Blur");
    blurButton.addActionListener(e -> editImage("Blur"));
    edits.add(blurButton);

    // FlipHorizontally
    JButton flipHorizontally = new JButton("Flip Horizontally");
    flipHorizontally.addActionListener(e -> editImage("Flip Horizontally"));
    edits.add(flipHorizontally);

    // FlipVertically
    JButton flipVertically = new JButton("Flip Vertically");
    flipVertically.addActionListener(e -> editImage("Flip Vertically"));
    edits.add(flipVertically);

    // Sepia
    JButton sepia = new JButton("Sepia");
    sepia.addActionListener(e -> editImage("Sepia"));
    edits.add(sepia);

    // Sharpen
    JButton sharpen = new JButton("Sharpen");
    sharpen.addActionListener(e -> editImage("Sharpen"));
    edits.add(sharpen);

    // Brighten button
    JButton brighten = new JButton("Brighten");
    brighten.addActionListener(e -> editImage("Brighten"));
    edits.add(brighten);

    // darken button
    JButton darken = new JButton("Darken");
    darken.addActionListener(e -> editImage("Darken"));
    edits.add(darken);

    // greyscaleOverall button
    JButton greyscaleOverall = new JButton("Greyscale Overall");
    greyscaleOverall.addActionListener(e -> editImage("Greyscale Overall"));
    edits.add(greyscaleOverall);

    // greyscaleRed button
    JButton greyscaleRed = new JButton("Greyscale Red");
    greyscaleRed.addActionListener(e -> editImage("Greyscale Red"));
    edits.add(greyscaleRed);

    // greyscaleGreen button
    JButton greyscaleGreen = new JButton("Greyscale Green");
    greyscaleGreen.addActionListener(e -> editImage("Greyscale Green"));
    edits.add(greyscaleGreen);

    // greyscaleBlue button
    JButton greyscaleBlue = new JButton("Greyscale Blue");
    greyscaleBlue.addActionListener(e -> editImage("Greyscale Blue"));
    edits.add(greyscaleBlue);

    // greyscaleLuma button
    JButton greyscaleLuma = new JButton("Greyscale Luma");
    greyscaleLuma.addActionListener(e -> editImage("Greyscale Luma"));
    edits.add(greyscaleLuma);

    // greyscaleValue button
    JButton greyscaleValue = new JButton("Greyscale Value");
    greyscaleValue.addActionListener(e -> editImage("Greyscale Value"));
    edits.add(greyscaleValue);

    // greyscaleIntensity button
    JButton greyscaleIntensity = new JButton("Greyscale Intensity");
    greyscaleIntensity.addActionListener(e -> editImage("Greyscale Intensity"));
    edits.add(greyscaleIntensity);

    JScrollPane editScroll = new JScrollPane(edits);
    editScroll.setAlignmentY(0);
    editScroll.setPreferredSize(new Dimension(100, 200));
    mainPanel.add(editScroll);
  }


  /**
   * Displays the image on the GUI, and it changes everytime an operation is performed on an image.
   *
   * @param name the name of the image that should be shown.
   */
  @Override
  public void showImage(String name) {
    this.name = name;
    ImageModel model = this.images.get(name);
    int end = name.lastIndexOf(".");
    String fileType = name.substring(end + 1);
    BufferedImage current = ImageUtil.toBufferedImage(fileType, model);
    ImageIcon icon = new ImageIcon(current);
    imageLabel.setIcon(icon);
    repaint();
    revalidate();
    histo.removeAll();
    JPanel histogramPanel = new Histogram(this.images.get(this.name).getImage());
    histo.add(histogramPanel);
    repaint();
    revalidate();
  }

  /**
   * Creates an image with the given operation on it.
   *
   * @param operation the edit that should be done to the image.
   */
  @Override
  public void editImage(String operation) throws IllegalArgumentException {
    switch (operation) {
      case "Load": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showOpenDialog(ImageViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          String fileName = f.getAbsolutePath();
          new Load(fileName, "", this).runCommand(this.images);
        }
      }
        this.showImage("");
      break;
      case "Save": {
        final JFileChooser fchooser = new JFileChooser(".");
        int retvalue = fchooser.showSaveDialog(ImageViewImpl.this);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          new Save(this.name, "", this).runCommand(this.images);
        }
      }
      break;
      case "Blur":
        new Blur(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Brighten":
        try {
          String value = JOptionPane.showInputDialog(this,
                  "Enter the value you want the image to be brighten to");
          new Brighten(Integer.parseInt(value), this, name,
                  "").runCommand(this.images);
        } catch (NumberFormatException e) {
          this.throwError("You must enter a number for the image");
          throw new IllegalArgumentException(e.getMessage());
        }
        this.showImage("");
        break;
      case "Darken":
        try {
          String value = JOptionPane.showInputDialog(this,
                  "Enter the value you want the image to be darken to");
          new Darken(Integer.parseInt(value),
                  this, name, "").runCommand(this.images);
        } catch (NumberFormatException e) {
          this.throwError("You must enter a number for the image");
          throw new IllegalArgumentException(e.getMessage());
        }
        this.showImage("");
        break;
      case "Flip Horizontally":
        new FlipHorizontally(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Flip Vertically":
        new FlipVertically(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Red":
        new Greyscale("red", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Green":
        new Greyscale("green", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Blue":
        new Greyscale("blue", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Luma":
        new Greyscale("luma", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Intensity":
        new Greyscale("intensity", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale value":
        new Greyscale("value", this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Greyscale Overall":
        new GreyscaleOverall(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Sepia":
        new Sepia(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      case "Sharpen":
        new Sharpen(this, name, "").runCommand(this.images);
        this.showImage("");
        break;
      default:
        break;
    }
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }

  /**
   * Render a specific error message to the provided data destination.
   *
   * @param error the message to be transmitted
   */
  public void throwError(String error) {
    JOptionPane.showMessageDialog(this, error);
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    return;
  }

  /**
   * Invoked when an item has been selected or deselected by the user.
   * The code written for this method performs the operations
   * that need to occur when an item is selected (or deselected).
   *
   * @param e the event to be processed
   */
  @Override
  public void itemStateChanged(ItemEvent e) {
    return;
  }

  /**
   * Called whenever the value of the selection changes.
   *
   * @param e the event that characterizes the change.
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    return;
  }
}
