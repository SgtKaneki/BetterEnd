package org.betterx.betterend.recipe;

import org.betterx.bclib.recipes.BCLRecipeBuilder;
import org.betterx.betterend.BetterEnd;
import org.betterx.betterend.registry.EndBlocks;
import org.betterx.betterend.registry.EndItems;
import org.betterx.betterend.registry.EndTemplates;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class SmithingRecipes {

    public static void register() {
        BCLRecipeBuilder.copySmithingTemplate(
                BetterEnd.makeID("copy_plate_upgrade"),
                EndTemplates.PLATE_UPGRADE,
                Items.IRON_INGOT
        ).build();

        BCLRecipeBuilder.copySmithingTemplate(
                BetterEnd.makeID("copy_leather_handle_attachment"),
                EndTemplates.LEATHER_HANDLE_ATTACHMENT,
                Items.LEATHER
        ).build();

        BCLRecipeBuilder.copyCheapSmithingTemplate(
                BetterEnd.makeID("copy_handle_attachment"),
                EndTemplates.HANDLE_ATTACHMENT,
                Items.DIAMOND
        ).build();

        BCLRecipeBuilder.copyCheapSmithingTemplate(
                BetterEnd.makeID("copy_tool_assembly"),
                EndTemplates.TOOL_ASSEMBLY,
                Blocks.IRON_BLOCK
        ).build();

        BCLRecipeBuilder.copySmithingTemplate(
                BetterEnd.makeID("copy_netherite_upgrade"),
                EndTemplates.NETHERITE_UPGRADE,
                Blocks.NETHERRACK
        ).build();
    }
}
