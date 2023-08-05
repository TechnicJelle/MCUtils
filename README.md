# MCUtils
A small library with a collection of useful functions for Minecraft paper plugins.

## Installation
Visit https://jitpack.io/#TechnicJelle/MCUtils for details on how to install this library.

## Usage
Please see the javadoc for the full API reference: [technicjelle.com/MCUtils](https://technicjelle.com/MCUtils/com/technicjelle/MCUtils.html)

### Copy Plugin Resource to Config Directory
This function copies any resource file from your plugin jar to your plugin's config directory.
This is useful for adding default configuration files to your plugin.
```java
copyPluginResourceToConfigDir(plugin, String fromResource, String toConfigFile, boolean overwrite) 
```

### Download image from URL
This function downloads an image from a URL and returns the image as a BufferedImage.
```java
downloadImage(String)
downloadImage​(URL)
```

## TODO:
- [ ] Config helper stuff
- [ ] Logging helper stuff
- [ ] And more?
