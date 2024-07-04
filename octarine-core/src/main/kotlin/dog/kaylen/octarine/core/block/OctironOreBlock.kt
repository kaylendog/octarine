/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.world.block

import dog.kaylen.octarine.common.OctarineBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.particle.DustParticleEffect
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3f
import net.minecraft.world.World
import java.util.*

object OctironOreBlock : OctarineBlock("octiron_ore", FabricBlockSettings.of(Material.STONE)) {
    private const val PARTICLE_PROBABILITY = 0.1

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        // spawn particles with a probability of 0.1
        if (random.nextFloat() < PARTICLE_PROBABILITY) {
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
            0.0,
        )
    }
}
