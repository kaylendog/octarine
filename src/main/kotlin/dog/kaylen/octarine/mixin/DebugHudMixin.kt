/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin

import dog.kaylen.octarine.world.chunk.OctarineChunk
import net.minecraft.client.gui.hud.DebugHud
import net.minecraft.world.chunk.WorldChunk
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
import java.util.ArrayList

@Mixin(DebugHud::class)
abstract class DebugHudMixin {
    @Shadow
    abstract fun getClientChunk(): WorldChunk?

    @Inject(method = ["getLeftText()LArrayList;"], at = [At("RETURN")], cancellable = true)
    fun injectDebugInfo(cir: CallbackInfoReturnable<ArrayList<String>>) {
        val chunk = this.getClientChunk() as OctarineChunk?
        val strings = cir.returnValue
        strings.add("")
        strings.add("Thaum: ${chunk?.thaum ?: "?"} Thaum Delta: ${chunk?.thaumChange ?: "?"}")
        cir.returnValue = strings
    }
}
