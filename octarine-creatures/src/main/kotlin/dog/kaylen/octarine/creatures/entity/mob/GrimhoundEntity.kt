package dog.kaylen.octarine.creatures.entity.mob

import dog.kaylen.octarine.creatures.item.MousepipeItem
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.world.EntityView
import net.minecraft.world.World

class GrimhoundEntity(entityType: EntityType<out WolfEntity>, world: World) : WolfEntity(
    entityType, world
) {
    override fun getEntityView(): EntityView {
        TODO("how?")
    }

    override fun tick() {
        super.tick()
        // prevent client ticks
        if (world.isClient) {
            return
        }
    }

    override fun initGoals() {
        // flee from players using horn
        goalSelector.add(1, object : EscapeDangerGoal(this, 2.0) {
            override fun isActive(): Boolean {
                return mob.isOnFire || mob.isFrozen
            }
        })
        goalSelector.add(3, FleeEntityGoal(
            this,
            LivingEntity::class.java,
            20F,
            2.0,
            4.0
        ) {
            it is PlayerEntity && it.activeItem.isOf(MousepipeItem()) && it.itemUseTimeLeft != 0
        })
        goalSelector.add(2, PounceAtTargetGoal(this, 0.4F))
        goalSelector.add(3, MeleeAttackGoal(this, 1.0, true))
        goalSelector.add(4, WanderAroundFarGoal(this, 2.0))
        // target attacker
        targetSelector.add(1, RevengeGoal(this))
        // target players
        targetSelector.add(2, TargetGoal(this, LivingEntity::class.java, true) {
            it is PlayerEntity
        })
    }
}
