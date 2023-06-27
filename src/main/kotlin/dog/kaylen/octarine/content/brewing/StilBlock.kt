/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.brewing

import dog.kaylen.octarine.common.OctarineBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material

object StilBlock : OctarineBlock("stil", FabricBlockSettings.of(Material.REPAIR_STATION))
