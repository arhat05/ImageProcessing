package view;

import java.io.IOException;

/**
 * This interface has methods that are used to view messages after an action is done to an image.
 */
public interface ImageView {

  /**
   * Sets up all the buttons for the different operations that can be done to an image.
   */
  void buttons();

  /**
   * Shows the image on the image display in the view.
   */
  void showImage(String name);

  /**
   * Creates an image with the given operation on it.
   *
   * @param operation the edit that should be done to the image.
   */
  void editImage(String operation);

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  void renderMessage(String message) throws IOException;

  /**
   * Render a specific error message to the provided data destination.
   *
   * @param error the message to be transmitted
   */
  void throwError(String error);
}
