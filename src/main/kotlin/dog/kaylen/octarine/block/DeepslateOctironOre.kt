/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block

import dog.kaylen.octarine.ext.nextBoolean
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.particle.DustParticleEffect
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3f
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

object DeepslateOctironOre : OctarineBlock("deepslate_octiron_ore", FabricBlockSettings.of(Material.STONE)) {
    private const val PARTICLE_PROBABILITY = 0.1

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        // spawn particles with a probability of 0.1
        if (!random.nextBoolean(PARTICLE_PROBABILITY)) {
            return
        }

        // add particle
        world.addParticle(
            DustParticleEffect(Vec3f(1F, 1F, 1F), 1F),
            pos.x.toDouble(),
            pos.y.toDouble() + 2.0,
            pos.z.toDouble(),
            0.0,
            0.0,
            0.0
        )
    }
}
