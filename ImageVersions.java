package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the IVersions interface.
 */
public class ImageVersions implements IVersions {
  private Map<String, ImageModel> versions;

  /**
   * A constructor that makes a hashmap of the different versions.
   */
  public ImageVersions() {
    this.versions = new HashMap<String, ImageModel>();
  }

  /**
   * This method adds a new version of the image to this map.
   *
   * @param name  the name of the new version.
   * @param model the model of the new image.
   */
  @Override
  public void add(String name, ImageModel model) {
    if (model != null || name != null) {
      this.versions.put(name, model);
    } else {
      throw new IllegalArgumentException("Invalid");
    }
  }

  /**
   * This gets the specific version.
   *
   * @param name the name of the version that they want to get.
   */
  @Override
  public ImageModel get(String name) {
    return this.versions.get(name);
  }


}
