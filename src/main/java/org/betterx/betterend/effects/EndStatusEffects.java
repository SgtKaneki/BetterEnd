package org.betterx.betterend.effects;

import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.effects.status.EndVeilEffect;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class EndStatusEffects {
    public final static MobEffect END_VEIL = registerEffect("end_veil", new EndVeilEffect());

    public static <E extends MobEffect> MobEffect registerEffect(String name, E effect) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, BetterEnd.makeID(name), effect);
    }
}
