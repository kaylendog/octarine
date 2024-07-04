package dog.kaylen.octarine.common

import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeType

abstract class OctarineRecipeType<T: Recipe<*>>(private val key: String) : RecipeType<T> {
    val identifier get() = identifierOf(key)
}
