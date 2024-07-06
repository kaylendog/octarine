/*
 * (C) Copyright 2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.core.recipe.OctarineRecipeType
import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.content.brewing.StilRecipeType
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object OctarineRecipeTypes : OctarineRegistry<OctarineRecipeType<out Recipe<*>>, RecipeType<out Recipe<*>>>(Registry.RECIPE_TYPE) {
    // brewing
    val STIL_RECIPE = register(StilRecipeType)

    override fun identifierOfElement(element: OctarineRecipeType<out Recipe<*>>): Identifier {
        return element.identifier
    }
}
