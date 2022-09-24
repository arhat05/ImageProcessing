package model;

/**
 * This creates a map of all the different versions of images that were edited.
 */
public interface IVersions {

  /**
   * This method adds a new version of the image to this map.
   * @param name the name of the new version.
   * @param model the model of the new image.
   */
  void add(String name, ImageModel model);

  /**
   * This gets the specific version.
   *
   * @param name the name of the version that they want to get.
   */
  ImageModel get(String name);


}
