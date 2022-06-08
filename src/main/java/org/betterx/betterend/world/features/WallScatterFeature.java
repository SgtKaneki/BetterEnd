package org.betterx.betterend.world.features;

import org.betterx.bclib.api.v2.levelgen.features.features.DefaultFeature;
import org.betterx.bclib.util.BlocksHelper;
import org.betterx.bclib.util.MHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public abstract class WallScatterFeature extends DefaultFeature {
    private static final Direction[] DIR = BlocksHelper.makeHorizontal();
    private final int radius;

    public WallScatterFeature(int radius) {
        this.radius = radius;
    }

    public abstract boolean canGenerate(WorldGenLevel world, RandomSource random, BlockPos pos, Direction dir);

    public abstract void generate(WorldGenLevel world, RandomSource random, BlockPos pos, Direction dir);

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
        final RandomSource random = featureConfig.random();
        final BlockPos center = featureConfig.origin();
        final WorldGenLevel world = featureConfig.level();
        int maxY = world.getHeight(Heightmap.Types.WORLD_SURFACE, center.getX(), center.getZ());
        int minY = BlocksHelper.upRay(world, new BlockPos(center.getX(), 0, center.getZ()), maxY);
        if (maxY < 10 || maxY < minY) {
            return false;
        }
        int py = MHelper.randRange(minY, maxY, random);

        MutableBlockPos mut = new MutableBlockPos();
        for (int x = -radius; x <= radius; x++) {
            mut.setX(center.getX() + x);
            for (int y = -radius; y <= radius; y++) {
                mut.setY(py + y);
                for (int z = -radius; z <= radius; z++) {
                    mut.setZ(center.getZ() + z);
                    if (random.nextInt(4) == 0 && world.isEmptyBlock(mut)) {
                        shuffle(random);
                        for (Direction dir : DIR) {
                            if (canGenerate(world, random, mut, dir)) {
                                generate(world, random, mut, dir);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private void shuffle(RandomSource random) {
        for (int i = 0; i < 4; i++) {
            int j = random.nextInt(4);
            Direction d = DIR[i];
            DIR[i] = DIR[j];
            DIR[j] = d;
        }
    }
}
