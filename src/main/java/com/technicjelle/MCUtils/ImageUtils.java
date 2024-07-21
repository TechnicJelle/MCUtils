/*
 * This file is part of MCUtils, licensed under the MPL2 License (MPL).
 * Please keep tabs on https://github.com/TechnicJelle/MCUtils for updates.
 *
 * Copyright (c) TechnicJelle <https://technicjelle.com>
 * Copyright (c) contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.technicjelle.MCUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Utility functions for dealing with images
 */
public class ImageUtils {
	private ImageUtils() {
		throw new IllegalStateException("Utility class");
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
