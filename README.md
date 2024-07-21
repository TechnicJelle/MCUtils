# MCUtils
[![Latest Release](https://repo.bluecolored.de/api/badge/latest/releases/com/technicjelle/MCUtils?name=Latest%20Release&prefix=v)](https://repo.bluecolored.de/#/releases/com/technicjelle/MCUtils)

A small library with a collection of useful functions for Minecraft Paper plugins.

## Install as dependency in Maven/Gradle
Visit https://repo.bluecolored.de/#/releases/com/technicjelle/MCUtils
for instructions on how to add this library as a dependency to your project.

You may want to shade the library!

## Usage/Overview of Features
Please see the javadoc for the full API reference:
- main (latest commit): https://technicjelle.com/MCUtils
- latest release: https://repo.bluecolored.de/javadoc/releases/com/technicjelle/MCUtils/latest
  - Also has docs for previous releases (v2.0 and up)

### Copy Plugin Resource to Config Directory
This function copies any resource file from your plugin jar to your plugin's config directory.
This is useful for adding default configuration files to your plugin.
```java
ConfigUtils.copyPluginResourceToConfigDir(plugin, String fromResource, String toConfigFile, boolean overwrite) 
```

### Download image from URL
This function downloads an image from a URL and returns the image as a BufferedImage.
```java
ImageUtils.downloadImage(String)
ImageUtils.downloadImage(URL)
```

## TODO:
- [ ] Config helper stuff
- [ ] Logging helper stuff
- [ ] And more?
