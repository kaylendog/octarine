package dog.kaylen.octarine.creatures.client.entity

import dog.kaylen.octarine.core.util.identifierOf
import dog.kaylen.octarine.creatures.entity.mob.GrimhoundEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.WolfEntityModel
import net.minecraft.util.Identifier

class GrimhoundEntityRenderer(
    ctx: EntityRendererFactory.Context,
    entityModel: WolfEntityModel<GrimhoundEntity>
) : MobEntityRenderer<GrimhoundEntity, WolfEntityModel<GrimhoundEntity>>(ctx, entityModel, 0.5f) {
    override fun getTexture(entity: GrimhoundEntity): Identifier {
        return identifierOf("textures/entity/grimhound/grimhound.png")
    }
}
