/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import net.fabricmc.loader.api.FabricLoader
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The Octarine mod ID.
 */
val OCTARINE_MOD_ID = "octarine"

/**
 * Global logging instance.
 */
val LOGGER: Logger get() = LoggerFactory.getLogger("octarine")

/**
 * The Fabric loader instance
 */
val FABRIC get() = FabricLoader.getInstance()

/**
 * The Octarine mod instance.
 */
val OCTARINE get() = OctarineMod.instance

/**
 * The mod container for Octarine.
 */
val OCTARINE_CONTAINER get() = FABRIC.getModContainer(OCTARINE_MOD_ID)
