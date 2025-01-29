/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineMod
import dog.kaylen.octarine.core.api.NamespacedRegistry
import net.minecraft.block.BlockWithEntity
import net.minecraft.registry.Registries

object OctarineBlockWithEntities : NamespacedRegistry<BlockWithEntity>(OctarineMod.MOD_ID, Registries.BLOCK)
