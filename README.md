# Image Processing (v1)
## Preethi Gandluru and Arhat Shah
#### USE "Script.txt" FOR MAIN, "ScriptJAR.txt" FOR THE JAR FILE
#### Example mage from Google, Creator: Emmanuel Huybrechts, Copyright: © Emmanuel Huybrechts

This code represents an image processing application. Currently, the application has functionality 
for loading and image, brightening, darkening, grey-scaling 6 different ways through 
RGB, value, intensity, and luma, flipping an image horizontally and vertically, blurring, sharpening,   
and saving the resulting image from an operation at any point. Additionally, the 
application has functionality to quit the application at any point when provided the character
'q'.
### Design Patterns:
We used the Model View Controller(MVC) design pattern along with the command design pattern.

### Model Interfaces and Classes:
The model currently contains the interfaces and classes to represent singular pixels, images 
and a map of previous versions of the same image. The pixel class represents an individual pixel, 
with distinct red, green, and blue integer values(RGB). An image object is represented as a 
2D array of such pixels, and is constructed through the ImageModelImpl class, which implements 
the interface. The interface contains all the methods for the operations that can be performed, 
while the class implements these methods. The IVersions interface contains the methods used and 
implements by the class ImageVersions. This class constructs the Image versions object, which is
a Hashmap that represents versions of the image being processed, beginning from when the image is 
loaded. The class additionally implements the add and get methods, which adds a String name as a 
key, and an ImageModelImpl object to the map as a value, and retrieves a value at a provided key 
respectively. The Model additionally contains the ImageUtil class, which contains implementations 
on loading(reading information from a loaded file), and saving an edited file(writing to a new 
file).

### View Interfaces and Classes:
The view has an interface ImageView and is implemented through the ImageViewImpl class. This class
implements the renderMessage function. This function renders a message to the user through an 
appendable object. 

#### V3 view Updates:
The view has been updated to include a new function of the GUI that allows the user to have a 
graphical view of the image editor. It allows ease of access to the editor. It includes all same
functional elements of the previous elements. This view also implements a new class that displays 
a histogram of the image. It displays the red, blue, green, and average values of the image.
![](../../../../exScreenshot.png)

### Controller Interfaces and Classes
The controller takes care of communicating with the model and the view. The controller interface 
IController contains one method, run, which runs the program. The controller class implements this. 
The controller takes input from the user, and checks to see if the inputted command exists in the
HashMap that stores the commands. These commands are detailed below. The controller then executes 
the command, and passes the appropriate arguments to the model and view.

#### Commands:
The commands are implements through the ICommand interface. This interface contains the go method,
which takes a IVersions object as an argument. The individual commands implement the go method to 
perform the appropriate operation. To perform an operation, you must load an image and provide the 
name of the file, and give a string to rename the image. Then you can perform the operation, and,
if you want to save the image, you can provide use the save command, and provide the name of the 
image you want to save followed by the name of the file you would like to save as with a .ppm 
extension. An abstract commands class has been added to reduce code duplicate with all the command
classes. This abstract class implements the ICommands interface and all the command classes extend 
the abstract class. 



