package org.betterx.betterend.recipe;

import org.betterx.bclib.recipes.BCLRecipeBuilder;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTags;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class AlloyingRecipes {
    public static void register() {
        BCLRecipeBuilder.alloying(BetterEnd.makeID("additional_iron"), Items.IRON_INGOT)
                        .setInput(EndTags.ALLOYING_IRON, EndTags.ALLOYING_IRON)
                        .setOutputCount(3)
                        .setExperience(2.1F)
                        .build();
        BCLRecipeBuilder.alloying(BetterEnd.makeID("additional_gold"), Items.GOLD_INGOT)
                        .setInput(EndTags.ALLOYING_GOLD, EndTags.ALLOYING_GOLD)
                        .setOutputCount(3)
                        .setExperience(3F)
                        .build();
        BCLRecipeBuilder.alloying(BetterEnd.makeID("additional_copper"), Items.COPPER_INGOT)
                        .setInput(EndTags.ALLOYING_COPPER, EndTags.ALLOYING_COPPER)
                        .setOutputCount(3)
                        .setExperience(3F)
                        .build();
        BCLRecipeBuilder.alloying(BetterEnd.makeID("additional_netherite"), Items.NETHERITE_SCRAP)
                        .setInput(Blocks.ANCIENT_DEBRIS, Blocks.ANCIENT_DEBRIS)
                        .setOutputCount(3)
                        .setExperience(6F)
                        .setSmeltTime(1000)
                        .build();
    }
}
