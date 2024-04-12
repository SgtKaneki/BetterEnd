package org.betterx.betterend.recipe;

import org.betterx.bclib.recipes.BCLRecipeBuilder;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.item.material.EndToolMaterial;
import org.betterx.betterend.registry.EndItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

public class AnvilRecipes {
    public static void register() {
        BCLRecipeBuilder.anvil(BetterEnd.makeID("ender_pearl_to_dust"), EndItems.ENDER_DUST)
                        .setPrimaryInputAndUnlock(Items.ENDER_PEARL)
                        .setAnvilLevel(Tiers.IRON.getLevel())
                        .setToolLevel(4)
                        .setDamage(5)
                        .build();
        BCLRecipeBuilder.anvil(BetterEnd.makeID("ender_shard_to_dust"), EndItems.ENDER_DUST)
                        .setPrimaryInputAndUnlock(EndItems.ENDER_SHARD)

                        .setAnvilLevel(Tiers.IRON.getLevel())
                        .setToolLevel(0)
                        .setDamage(3)
                        .build();
    }
}
