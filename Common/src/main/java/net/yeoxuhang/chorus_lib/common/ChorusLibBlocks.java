package net.yeoxuhang.chorus_lib.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;

public class ChorusLibBlocks {
    public static class LogBlock extends ChorusLibRotatedPillarBlock {
        public LogBlock(Properties properties) {
            super(properties);
        }
    }

    public static class Log extends LogBlock {
        public Log() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }

    public static class Wood extends ChorusLibRotatedPillarBlock {
        public Wood() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }

    public static class NetherLog extends LogBlock {
        public NetherLog() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }

    public static class NetherWood extends RotatedPillarBlock {
        public NetherWood() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }
    public static class EndLog extends LogBlock {
        public EndLog() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }

    public static class EndWood extends RotatedPillarBlock {
        public EndWood() {
            super(Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );

        }
    }

    public static class Stone extends Block {
        public Stone() {
            super(Properties.of()
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()

            );

        }
    }

    public static class NetherStone extends Block {
        public NetherStone() {
            super(Properties.of()
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()

            );
        }
    }
    public static class EndStone extends Block {
        public EndStone() {
            super(Properties.of()
                    .sound(SoundType.STONE)
                    .strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops()
            );
        }
    }
}
