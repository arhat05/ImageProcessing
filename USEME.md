### Commands are used as followed:
``` java
//Load an image(Koala.ppm) and name it "koala", which is the key for the value of Koala.ppm 
//in the map of versions.
load Koala.ppm koala

//brighten the image "koala" by a factor of 10, and add image "koala_bright" to the map of 
//versions.
brighten 10 koala koala_bright

//darken the image "koala" by a factor of 10, and add image "koala_dark" to the map of
//versions.
darken 10 koala koala_dark

//horizontally flip the image "koala_dark" and add image "koala_dark_hflipped" to the map of
//versions.
horizontal-flip koala_dark koala_dark_hflipped

//vertically flip the image "koala_dark_hflipped" and add image "koala_dark_vhflipped" to the map
//of versions.
vertical-flip koala_dark_hflipped koala_dark_vhflipped

//grey scale the image "koala_dark_vhflipped" by the red component, and add image 
//"koala_dark_vhflipped_grey_red" to the map of versions.
greyscale-red koala_dark_vhflipped koala_dark_vhflipped_grey_red

//grey scale the image "koala_dark_vhflipped" by the green component, and add image
//"koala_dark_vhflipped_grey_green" to the map of versions.
greyscale-green koala_dark_vhflipped koala_dark_vhflipped_grey_green

//grey scale the image "koala_dark_vhflipped" by the blue component, and add image
//"koala_dark_vhflipped_grey_blue" to the map of versions.
greyscale-blue koala_dark_vhflipped koala_dark_vhflipped_grey_blue

//greyscale the image "koala_dark_vhflipped" by the value of the image, and add image
//"koala_dark_vhflipped_grey_value" to the map of versions.
greyscale-value koala_dark_vhflipped koala_dark_vhflipped_grey_value

//greyscale the image "koala_dark_vhflipped" by the intensity of the image, and add image
//"koala_dark_vhflipped_grey_intensity" to the map of versions.
greyscale-intensity koala_dark_vhflipped koala_dark_vhflipped_grey_intensity

//greyscale the image "koala_dark_vhflipped" by the luma of the image, and add image
//"koala_dark_vhflipped_grey_luma" to the map of versions.
greyscale-luma koala_dark_vhflipped koala_dark_vhflipped_grey_luma

//blur the image "koala_dark_vhflipped_grey_luma", and add image 
//"koala_dark_vhflipped_grey_luma_blur" to the map of versions.
blur koala_dark_vhflipped_grey_luma koala_dark_vhflipped_grey_luma_blur

//sharpen the image "koala_dark_vhflipped_grey_luma", and add image 
//"koala_dark_vhflipped_grey_luma_sharp" to the map of versions
sharpen koala_dark_vhflipped_grey_luma koala_dark_vhflipped_grey_luma_sharp
```