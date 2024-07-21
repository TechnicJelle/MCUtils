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

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Utility functions for dealing with configs
 */
public class ConfigUtils {
	private ConfigUtils() {
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
}
