package creatures.registry

import dog.kaylen.octarine.creatures.entity.mob.BalrogEntity
import dog.kaylen.octarine.creatures.entity.mob.GrimhoundEntity
import dog.kaylen.octarine.creatures.entity.mob.MoonDragonEntity
import dog.kaylen.octarine.creatures.entity.mob.SwampDragonEntity
import dog.kaylen.octarine.creatures.entity.passive.*
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType

object CreatureEntityTypes {
    // mobs
    val BALROG = create<BalrogEntity>("balrog") {}
    var GRIMHOUND = create<GrimhoundEntity>("grimhound") {}
    var MOON_DRAGON = create<MoonDragonEntity>("moon_dragon") {}
    var SWAMP_DRAGON = create<SwampDragonEntity>("swamp_dragon") {}

    // passive
    val CENTAUR = create<CentaurEntity>("centaur") {}
    val CHIMERA = create<ChimeraEntity>("chimera") {}
    val CROWHARK = create<CrowharkEntity>("crowhark") {}
    var DIRE_YAK = create<DireYakEntity>("dire_yak") {}
    var DUCK_BILLED_PLATYPUS = create<DuckBilledPlatypusEntity>("duck_billed_platypus") {}
    var GLOW_WORM = create<GlowWormEntity>("glow_worm") {}
    var GOBLIN = create<GoblinEntity>("goblin") {}
    var SALAMANDER = create<SalamanderEntity>("salamander") {}
    var WOOLLY_GOAT = create<WoollyGoatEntity>("woolly_goat") {}

    fun <T : Entity> create(name: String, block: FabricEntityTypeBuilder<T>.() -> Unit): EntityType<T> {
        return FabricEntityTypeBuilder.create<T>().apply(block).build()
    }
}
