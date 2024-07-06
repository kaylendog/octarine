/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.block

import dog.kaylen.octarine.core.OctarineBlock
import net.minecraft.block.BlockState
import net.minecraft.particle.DustParticleEffect
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.joml.Vector3f
import java.util.*

object DeepslateOctironOre : OctarineBlock("deepslate_octiron_ore", FabricBlockSettings.of(Material.STONE)) {
    private const val PARTICLE_PROBABILITY = 0.1

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        // spawn particles with a probability of 0.1
        if (random.nextFloat() < PARTICLE_PROBABILITY) {
            return
        }

        // add particle
        world.addParticle(
            DustParticleEffect(Vector3f(1.0F, 1.0F, 1.0F), 1F),
            pos.x.toDouble(),
            pos.y.toDouble() + 2.0,
            pos.z.toDouble(),
            0.0,
            0.0,
            0.0,
        )
    }
}
