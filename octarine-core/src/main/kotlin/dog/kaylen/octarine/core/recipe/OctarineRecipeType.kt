package dog.kaylen.octarine.core.recipe

import dog.kaylen.octarine.core.util.identifierOf
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeType

abstract class OctarineRecipeType<T: Recipe<*>>(private val key: String) : RecipeType<T> {
    val identifier get() = identifierOf(key)
}
