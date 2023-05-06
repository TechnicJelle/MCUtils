package com.technicjelle;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MCUtils {

	private MCUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Copies any resource from your plugin's resource folder in the jar, to your plugin's config folder.
	 *
	 * @param plugin       Your plugin instance. Usually <code>this</code>
	 * @param fromResource The path to the resource, relative to your plugin's resource folder
	 * @param toConfigFile The path to the config file, relative to your plugin's data folder
	 * @param overwrite    Whether to overwrite the config file if it already exists
	 * @throws IOException If the resource could not be found or copied
	 */
	public static void copyPluginResourceToConfigDir(@NotNull JavaPlugin plugin, @NotNull String fromResource, @NotNull String toConfigFile, boolean overwrite) throws IOException {
		Path toPath = plugin.getDataFolder().toPath().resolve(toConfigFile);

		if (Files.exists(toPath) && !overwrite) return;
		Files.createDirectories(toPath.getParent());
		try (
				@Nullable InputStream in = plugin.getResource(fromResource);
				// To prevent creating empty files, make output stream null if input stream is null:
				@Nullable OutputStream out = in == null ? null : Files.newOutputStream(toPath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
		) {
			if (in == null) throw new IOException("Resource not found: " + fromResource);
			in.transferTo(out);
		}
	}

	/**
	 * Downloads an image from the given URL.
	 *
	 * @param url URL of the image
	 * @return The image, or <code>null</code> if it could not be found, or the url was invalid
	 */
	public static @Nullable BufferedImage downloadImage(@NotNull String url) {
		try {
			return downloadImage(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Downloads an image from the given URL.
	 *
	 * @param url URL of the image
	 * @return The image, or <code>null</code> if it could not be found
	 */
	public static @Nullable BufferedImage downloadImage(@NotNull URL url) {
		try (
				InputStream in = url.openStream()
		) {
			return ImageIO.read(in);
		} catch (IOException e) {
			return null;
		}
	}
}