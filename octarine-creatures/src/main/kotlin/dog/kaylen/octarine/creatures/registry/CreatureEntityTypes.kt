package dog.kaylen.octarine.creatures.registry

import dog.kaylen.octarine.core.registry.OctarineEntityTypes.createMob
import dog.kaylen.octarine.creatures.entity.mob.BalrogEntity
import dog.kaylen.octarine.creatures.entity.mob.GrimhoundEntity
import dog.kaylen.octarine.creatures.entity.mob.MoonDragonEntity
import dog.kaylen.octarine.creatures.entity.mob.SwampDragonEntity
import dog.kaylen.octarine.creatures.entity.passive.*
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.SpawnGroup

object CreatureEntityTypes {
    // mobs
    val BALROG = createMob("balrog", ::BalrogEntity) {}
    var GRIMHOUND = createMob("grimhound", ::GrimhoundEntity) {
        setDimensions(EntityDimensions.fixed(0.85F, 0.6F))
        spawnGroup(SpawnGroup.MONSTER)
    }
    var MOON_DRAGON = createMob("moon_dragon", ::MoonDragonEntity) {}
    var SWAMP_DRAGON = createMob("swamp_dragon", ::SwampDragonEntity) {}

    // passive
    val CENTAUR = createMob("centaur", ::CentaurEntity) {}
    val CHIMERA = createMob("chimera", ::ChimeraEntity) {}
    val CROWHARK = createMob("crowhark", ::CrowharkEntity) {}
    var DIRE_YAK = createMob("dire_yak", ::DireYakEntity) {}
    var DUCK_BILLED_PLATYPUS = createMob("duck_billed_platypus", ::DuckBilledPlatypusEntity) {}
    var GLOW_WORM = createMob("glow_worm", ::GlowWormEntity) {}
    var GOBLIN = createMob("goblin", ::GoblinEntity) {}
    var SALAMANDER = createMob("salamander", ::SalamanderEntity) {}
    var WOOLLY_GOAT = createMob("woolly_goat", ::WoollyGoatEntity) {}
}
